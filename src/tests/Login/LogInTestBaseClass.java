
package tests.Login;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import modules.*;
import utilities.*;
import basicConfig.*;

import static dataRepository.LoginPageData.*;
import static credentials.LoginCredentials.*;

public class LogInTestBaseClass {
	
	public static  WebDriver driver = null; 
	SoftAssert sAssert = null;
	LoginFlow loginFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
    @BeforeSuite
	public void lauchAppforLogin(){
    	driver = (WebDriver)LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		loginFlow = new LoginFlow(driver);
		sAssert = new SoftAssert();
		loginFlow.launchScreen.skipButton.click();
	}
    
    @Test
    public void homeScreenUIValidation(){
    	log.info("inside1");
    }
    
    @Test
    public void logInScreenUIValidation(){
    	log.info("logInScreenUIValidation");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("verifying the label of userID field");
       	sAssert.assertEquals(loginFlow.loginPage.userIdLabel.getText(), USERID_LABEL);
        driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
       	
    }
    
    @Test
    public void logInUsingInvalidUserId()
    {
    	log.info("inside3");
    }
    
    @Test 
    public void logInUsingInvalidPassword()
    {
    	log.info("inside4");
    }
    
      
    @Test
    public void loginUsingValidUserID(){
    	log.info("inside5");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       	//sAssert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       
        LogOut.logout();
        
        
    }
    
	
	

}
