
package tests.Login;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import modules.*;
import utilities.*;
import basicConfig.*;
import io.appium.java_client.android.AndroidDriver;

import static dataRepository.LoginPageData.*;
import static credentials.LoginCredentials.*;

public class LogInTestBaseClass {
	
	public static  AndroidDriver driver = null; 
	LoginFlow loginFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
    @BeforeSuite
	public void lauchAppforLogin(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		loginFlow = new LoginFlow((WebDriver)driver);
		loginFlow.launchScreen.skipButton.click();
	}
    
    
	@Test
	public void loginButtonClickAction(){
		log.info("TC_17: Login button tappable verification");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	Assert.assertEquals(driver.currentActivity(),LOGIN_SCREEN_ACTIVITY);
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
	}
	
	@Test
	public void loginusingValidCredentials(){
		log.info("TC_18: User credential verification");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}
	
	@Test //need to fix
	public void loginUsingInvalidCredentials()
	{
		log.info("TC_19: User credential verification using invalid credentials");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(INVALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(INVALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
       
	}
	
	@Test
	public void loginWithoutEnteringCredentials(){
		log.info("TC_22 To validate the Login without entering any credentials");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.userIdBlankErrorMessage.getText(),USERID_BLANK_ERROR);
       	Assert.assertEquals(loginFlow.loginPage.passwordBlankErrorMessage.getText(),PASSWORD_BLANK_ERROR);
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
	}
	
	@Test
	public void loginWithpoutPassword(){
		log.info("TC_23: To validate the Login with just entering the user ID");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.passwordBlankErrorMessage.getText(),PASSWORD_BLANK_ERROR);
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
	}
	
	@Test
	public void loginWithoutUserID(){
		log.info("TC_24: To validate the Login with just entering the Password");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.userIdBlankErrorMessage.getText(),USERID_BLANK_ERROR);
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
        
	}
	
	@Test
	public void loginUsingBlockedUserCredentials(){
		log.info("TC_25: To validate the Login with an inactive/blocked user credentials");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(BLOCKED_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(BLOCKED_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	log.info("to be done");
       	driver.navigate().back();
        loginFlow.homePage.loginWindowCrossButton.click();
	}
	
	@Test
	public void loginUsingUserIdInUpperCase(){
	    log.info("TC_26: To validate login with valid user credentials having username in upper case");
	    loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME.toUpperCase());
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}
	
	@Test
	public void loginUsingUserIdInLowerCase(){
		log.info("TC_27: To validate login with valid user credentials having username in lower case");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME.toLowerCase());
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}
	
	@Test
	public void loginUsingUserIdWithLeadingAndTrailingSpaces(){
		log.info("TC_28: To validate login with valid user credentials with leading and trailing spaces in user ID");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys("  "+VALID_USERNAME+"  ");
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}
	
	@Test
	public void loginUsingPasswordWithLeadingAndTrailingSpaces(){
		log.info("TC_29: To validate login with valid user credentials with leading and trailing spaces in the password");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys("  "+VALID_PASSWORD+"  ");
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}
	
	@Test
	public void loginUisngSpecialCharacterInPassword(){
		log.info("TC_30: To validate login with valid user credentials with special characters in the password");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       	LogOut.logout();
	}

}
