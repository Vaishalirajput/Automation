package tests.signUp;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bson.Document;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import basicConfig.Consts;
import basicConfig.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import modules.*;
import tests.Login.LogInTestBaseClass;
import utilities.GetDataBaseConnection;

public class SignUpTestCaseBaseClass {
	public static  AndroidDriver driver = null; 
	SignUpFlow signUpFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
    @BeforeSuite
	public void lauchAppforSignUp(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		signUpFlow = new SignUpFlow(driver);
		signUpFlow.launchScreen.skipButton.click();
	}
    
    @Test
    public void signUp(){
    	signUpFlow.homePage.appointmentTab.click();
    	signUpFlow.homePage.signUpButton.click();
    	signUpFlow.signUpPage.caNotVisited.click();
    	signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    	signUpFlow.personalDetailsPage.dob.click();
    	//driver.findElement(By.xpath("//android.view.View[@index=15]")).click();
    	signUpFlow.personalDetailsPage.test.click();
    	driver.findElement(By.id("amdp_ok")).click();
    	signUpFlow.personalDetailsPage.gender.click();
    	signUpFlow.personalDetailsPage.genderFemale.click();
    	signUpFlow.personalDetailsPage.mobileNumber.sendKeys("8586000000");
    	signUpFlow.personalDetailsPage.nextButton.click();
    	
    	MongoDatabase db = GetDataBaseConnection.connectToDatabase("10.151.15.37","27018","catest_minervadb","catest_minerva","catest_minerva");
        System.out.println("Connected to the database successfully"); 
        MongoCollection<Document> userOTP = db.getCollection("userOTP");
        
        //We can user following class to find data: BsonString, BsonInt32, BsonFloat, etc.   
        Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        
        String otp = OTP.iterator().next().getString("oneTimePassword");
        
    	//String otp = "1234";
    	String abc[] = otp.split("");
    	System.out.println(abc[0]);
    	
    	driver.findElement(By.id("et1")).sendKeys(abc[0]);;
    	driver.findElement(By.id("et2")).sendKeys(abc[1]);;
    	driver.findElement(By.id("et3")).sendKeys(abc[2]);;
    	driver.findElement(By.id("et4")).sendKeys(abc[3]);;
        //signUpFlow.enterOTPPage.otpInputField.sendKeys("5656");
        signUpFlow.enterOTPPage.nextButton.click();
        
        signUpFlow.setPasswordPage.password.sendKeys("Test@123");
        signUpFlow.setPasswordPage.confirmPassword.sendKeys("Test@123");
        signUpFlow.setPasswordPage.nextButton.click();
        
    	
    }
}
