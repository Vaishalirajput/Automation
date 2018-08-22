
package tests.Login;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import modules.*;
import utilities.*;
import basicConfig.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static dataRepository.LoginPageData.*;
import static dataRepository.ForgotUserIdPageData.*;
import static dataRepository.ForgotPasswordPageData.*;
import static dataRepository.SignUpPageData.*;

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
    public void verifyCALogo(){
    	log.info("TC_01: To verify the CA logo.");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	Boolean logoDisplayed = loginFlow.loginPage.caLOGO.isDisplayed();
    	Assert.assertEquals(logoDisplayed.booleanValue(),true);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test	
    public void verifyUserIDLabel(){
    	log.info("TC_02: To verify the User ID label and its text");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String userIDLable = loginFlow.loginPage.userIdLabel.getText();
    	Assert.assertEquals(userIDLable,USERID_LABEL);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test
    public void verifyForgotUserIDButton(){
    	log.info("TC_03: To verify the Forgot User ID button and its text");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String forgotUserIDButton = loginFlow.loginPage.forgotUsetIdLink.getText();
    	Assert.assertEquals(forgotUserIDButton,FORGOT_USERID_LINK_TEXT);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test
    public void verifyPasswordLabel(){
    	log.info("TC_04: To verify the password label and its text.");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String passwordLabel = loginFlow.loginPage.passwordLabel.getText();
    	Assert.assertEquals(passwordLabel,PASSWORD_LABEL);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test
    public void verifyForgotPasswordButton(){
    	log.info("TC_05: To verify Forgot password Button and its text.");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String forgotPasswordLabel = loginFlow.loginPage.forgotPasswordLink.getText();
    	Assert.assertEquals(forgotPasswordLabel, FORGOT_USERID_LINK_TEXT);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    
    @Test
    public void verifySignUpButton(){
    	log.info("TC_06: To verify Sign Up Button and its text.");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String signUpButton = loginFlow.loginPage.signUpButton.getText();
    	Assert.assertEquals(signUpButton, SIGNUP_BUTTON_TEXT);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test
    public void verifyLoginButton(){
    	log.info("TC_07: To verify Login Button and its text.");
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
    	String loginButton = loginFlow.loginPage.logInButton.getText();
    	Assert.assertEquals(loginButton, LOGIN_BUTTON_TEXT);
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    	
    }
    
    @Test
	public void forgotUserIDButtonClickAction(){
		log.info("TC_08 & TC_09: Forgot User ID button tappable verification and redirection from retrieve userid to login screen");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.forgotUsetIdLink.click();
       	String forgotUserIDScreenHeader  = 	loginFlow.forgotUserIDPage.userIDScreenHeader.getText();
       	Assert.assertEquals(forgotUserIDScreenHeader, FORGOT_USERID_HEADER);
       	loginFlow.forgotUserIDPage.forgotUserIdBackButton.click();
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
	}
    
    @Test
	public void forgotPasswordButtonClickAction(){
		log.info("TC_11 & TC_12: Forgot Password button tappable verification and redirection from retrieve password to login screen");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.forgotPasswordLink.click();
       	String forgotPasswordScreenHeader  = 	loginFlow.forgotPasswordPage.passwordScreenHeader.getText();
       	Assert.assertEquals(forgotPasswordScreenHeader, FORGOT_PASSWORD_HEADER);
       	loginFlow.forgotPasswordPage.forgotPasswordBackButton.click();
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
	}
  
	@Test
	public void signUpButtonClickAction(){
		log.info("TC_14 & 15: Sign up button tappable verification and redirection from Sign up screen to login screen");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.signUpButton.click();
       	String signUpScreenHeader = loginFlow.signUpScreenPage.signUPScreenHeader.getText();
       	Assert.assertEquals(signUpScreenHeader, SIGN_UP_HEADER);
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
	}

    
	@Test
	public void loginButtonClickAction(){
		log.info("TC_17: Login button tappable verification");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	Assert.assertEquals(driver.currentActivity(),LOGIN_SCREEN_ACTIVITY);
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
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
	public void loginUsingInvalidCredentials() throws InterruptedException
	{
		log.info("TC_19: User credential verification using invalid credentials");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys(INVALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(INVALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	Thread.sleep(20000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
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
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
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
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
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
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
        
	}
	
	@Test
	public void loginUsingBlockedUserCredentials() throws InterruptedException{
		log.info("TC_25: To validate the Login with an inactive/blocked user credentials");
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	log.info("entering user id");
       	loginFlow.loginPage.userIdField.sendKeys("blocked");
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys("blocked");
       	loginFlow.loginPage.logInButton.click();
       	Thread.sleep(20000);
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
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
