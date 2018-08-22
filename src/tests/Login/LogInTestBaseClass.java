
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
    
    @Test (priority = 0)	
    public void verifyCALogo(){
    	Boolean logoDisplayed = loginFlow.loginPage.caLOGO.isDisplayed();
    	if(logoDisplayed == true)
    	{
    	log.info("Logo is displayed on the screen");
    	}
    	else {
    		log.info("Logo is not displayed on the screen");
    	}
    	
    }
    
    @Test (priority = 1)	
    public void verifyUserIDLabel(){
    	Boolean userIDLable = loginFlow.loginPage.userIdLabel.isDisplayed();
    	if(userIDLable == true)
    	{
    	log.info("User ID lable is displayed on the screen");
    	}
    	else {
    		log.info("User ID lable is not displayed on the screen");
    	}
    	
    }
    
    @Test (priority = 2)	
    public void verifyForgotUserIDButton(){
    	Boolean forgotUserIDButton = loginFlow.loginPage.forgotUsetIdLink.isDisplayed();
    	if(forgotUserIDButton == true)
    	{
    	log.info("forgotUserIDButton is displayed on the screen");
    	}
    	else {
    		log.info("forgotUserIDButton is not displayed on the screen");
    	}
    	
    }
    
    @Test
    public void verifyPasswordLabel(){
    	Boolean passwordLabel = loginFlow.loginPage.passwordLabel.isDisplayed();
    	if(passwordLabel == true)
    	{
    	log.info("passwordLabel is displayed on the screen");
    	}
    	else {
    		log.info("passwordLabel is not displayed on the screen");
    	}
    	
    }
    
    @Test
    public void verifyForgotPasswordButton(){
    	Boolean forgotPasswordButton = loginFlow.loginPage.forgotPasswordLink.isDisplayed();
    	if(forgotPasswordButton == true)
    	{
    	log.info("ForgotPassword button is displayed on the screen");
    	}
    	else {
    		log.info("ForgotPassword button is not displayed on the screen");
    	}
    	
    }
    
    @Test
    public void verifySignUpButton(){
    	Boolean signUpButton = loginFlow.loginPage.signUpButton.isDisplayed();
    	if(signUpButton == true)
    	{
    	log.info("signUpButton is displayed on the screen");
    	}
    	else {
    		log.info("signUpButton is not displayed on the screen");
    	}
    	
    }
    
    @Test
    public void verifyLoginButton(){
    	Boolean loginButton = loginFlow.loginPage.logInButton.isDisplayed();
    	if(loginButton == true)
    	{
    	log.info("loginButton is displayed on the screen");
    	}
    	else {
    		log.info("loginButton is not displayed on the screen");
    	}
    	
    }
    
    @Test
	public void forgotUserIDButtonClickAction(){
		log.info("forgot User ID button tappable verification");
		loginFlow.loginPage.forgotUsetIdLink.click();
		System.out.println(driver.currentActivity());

     //we are here
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
       	loginFlow.loginPage.userIdField.sendKeys("blocked");
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys("blocked");
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
