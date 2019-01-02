package tests.signUp;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bson.Document;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import basicConfig.Consts;
import basicConfig.LaunchApp;
import dataRepository.EnterMRNPageData;
import dataRepository.SignUpPageData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import modules.SignUpUsingMRNFlow;
import tests.Login.LogInTestBaseClass;
import utilities.GetDataBaseConnection;
import utilities.Utility;

public class SignUpUsingMRN {
	
	public static  AndroidDriver driver = null; 
	SignUpUsingMRNFlow signUpUsingMRNFlow = null;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	Random rand = new Random();
	int mobileNumber =  rand.nextInt((1000999999 - 1000000000) + 1) + 1000000000;
	MongoCollection<Document> userOTP, user= null;
	
    @BeforeSuite
	public void lauchAppforSignUp(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		signUpUsingMRNFlow = new SignUpUsingMRNFlow(driver);
		signUpUsingMRNFlow.launchScreen.skipButton.click();
    	MongoDatabase db = GetDataBaseConnection.connectToDatabase("10.151.15.37","27018","catest_minervadb","catest_minerva","catest_minerva");
    	System.out.println("Connected to the database successfully"); 
        userOTP = db.getCollection("userOTP");
        user = db.getCollection("user");

	}
    
    @BeforeMethod
    public void navigateOnSignUpScreen()
    {
    	try{
    	signUpUsingMRNFlow.homePage.appointmentTab.click();
    	}catch(StaleElementReferenceException e){
    		signUpUsingMRNFlow.homePage.appointmentTab.click();
    	}
    	signUpUsingMRNFlow.homePage.signUpButton.click();
    }
     
    private void navigateOnHomePage()
    {
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        signUpUsingMRNFlow.homePage.loginWindowCrossButton.click();
    }
    
    @Test
    public void backButtonClickActionOnEnterMRNScreen(){
    	try{
    	log.info("back button click action on enter MRN page");	
    	signUpUsingMRNFlow.signUpPage.caAlreadyVisited.click();
    	signUpUsingMRNFlow.enterMRNPage.backButton.click();
    	Assert.assertEquals(signUpUsingMRNFlow.signUpPage.signUPScreenHeader.getText(), SignUpPageData.SIGN_UP_HEADER);
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    	log.info("done");
    }
    
    @Test
    public void headerTextOnEnterMRNScreen(){
    	try{
    	log.info("header text on enter MRN page");	
    	signUpUsingMRNFlow.signUpPage.caAlreadyVisited.click();
    	Assert.assertEquals(signUpUsingMRNFlow.enterMRNPage.headerText.getText(), EnterMRNPageData.HEADER_TEXT);
    	signUpUsingMRNFlow.enterMRNPage.backButton.click();
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    	log.info("done");	
    }
    
    @Test
    public void verifyMRNfieldLabelOnEnterMRNScreen(){
    	try{
    	log.info("verifyMRNfieldLabel on enter MRN page");	
    	signUpUsingMRNFlow.signUpPage.caAlreadyVisited.click();   	
    	Assert.assertEquals(signUpUsingMRNFlow.enterMRNPage.screenText.getText(), EnterMRNPageData.ENTER_MRN_FIELD_LABEL);
    	signUpUsingMRNFlow.enterMRNPage.backButton.click();
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    	log.info("done");	
    }
    
    @Test
    public void nextButtonClickActionWithoutEnteringMRN(){
    	try{
    	log.info("verifyMRNfieldLabel on enter MRN page");	
    	signUpUsingMRNFlow.signUpPage.caAlreadyVisited.click();   
    	signUpUsingMRNFlow.enterMRNPage.nextButton.click();
    	Assert.assertEquals(signUpUsingMRNFlow.enterMRNPage.MRNFieldBlankError.isDisplayed(), true);
    	signUpUsingMRNFlow.enterMRNPage.backButton.click();
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    	log.info("done");	
    }
    
    @Test
    public void invalidMRNOnEnterMRNScreen(){
    	try{
    	log.info("verifyMRNfieldLabel on enter MRN page");	
    	signUpUsingMRNFlow.signUpPage.caAlreadyVisited.click();   
    	signUpUsingMRNFlow.enterMRNPage.nextButton.click();
    	signUpUsingMRNFlow.enterMRNPage.enterMRNInputField.sendKeys("1212121222");
    	Assert.assertEquals(signUpUsingMRNFlow.enterMRNPage.screenText.getText(), EnterMRNPageData.ENTER_MRN_FIELD_LABEL);
    	signUpUsingMRNFlow.enterMRNPage.backButton.click();
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    	log.info("done");
    	    }

}
