
package tests.Login;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import modules.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.*;
import basicConfig.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static dataRepository.LoginPageData.*;
import static dataRepository.ForgotUserIdPageData.*;
import static dataRepository.ForgotPasswordPageData.*;
import static dataRepository.SignUpPageData.*;

import java.io.File;

import static credentials.LoginCredentials.*;

public class LogInTestBaseClass {
	
	public static  AndroidDriver driver = null; 
	LoginFlow loginFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
	private String screenText[] = new String[40];
	
    @BeforeSuite
	public void lauchAppforLogin(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		loginFlow = new LoginFlow(driver);
		loginFlow.launchScreen.skipButton.click();
	}

    @BeforeMethod
    public void beforeTestMethod()
    {
    	try{
    	loginFlow.homePage.appointmentTab.click();
    	}catch(StaleElementReferenceException e){
    	System.out.print("stale element exception ocured-------------------------------");
    	loginFlow.homePage.appointmentTab.click();
    	}
       	loginFlow.homePage.loginButton.click();
       	
    }
    
   
    private void navigateToHomeScreen(){
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        loginFlow.homePage.loginWindowCrossButton.click();
    }
    
    @Test 	
    public void verifyCALogo(){
    	log.info("TC_01: To verify the CA logo.");
    	try{
    	Boolean logoDisplayed = loginFlow.loginPage.caLOGO.isDisplayed();
    	Assert.assertEquals(logoDisplayed.booleanValue(),true);
    	navigateToHomeScreen(); 
    	}
    	catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{   	
    	    Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
    
    @Test	
    public void verifyUserIDLabel(){
    	log.info("TC_02: To verify the User ID label and its text");
    	try{
    	String userIDLable = loginFlow.loginPage.userIdLabel.getText();
    	Assert.assertEquals(userIDLable,USERID_LABEL);
    	navigateToHomeScreen();
    	}
    	catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
 
    @Test
    public void verifyForgotUserIDButton(){
    	log.info("TC_03: To verify the Forgot User ID button and its text");
    	try{
    	String forgotUserIDButton = loginFlow.loginPage.forgotUsetIdLink.getText();
    	Assert.assertEquals(forgotUserIDButton,FORGOT_USERID_LINK_TEXT);
    	navigateToHomeScreen();
    	}
    	catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
    
    @Test
    public void verifyPasswordLabel(){
    	log.info("TC_04: To verify the password label and its text.");
    	try{
    	String passwordLabel = loginFlow.loginPage.passwordLabel.getText();
    	Assert.assertEquals(passwordLabel,PASSWORD_LABEL);
    	navigateToHomeScreen();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
    
    @Test
    public void verifyForgotPasswordButton(){
    	log.info("TC_05: To verify Forgot password Button and its text.");
    	try{
    	String forgotPasswordLabel = loginFlow.loginPage.forgotPasswordLink.getText();
    	Assert.assertEquals(forgotPasswordLabel, FORGOT_PASSWORD_LINK_TEXT);
    	navigateToHomeScreen();
    	}
    	catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
    
    
    @Test
    public void verifySignUpButton(){
    	log.info("TC_06: To verify Sign Up Button and its text.");
    	try{
    	String signUpButton = loginFlow.loginPage.signUpButton.getText();
    	Assert.assertEquals(signUpButton, SIGNUP_BUTTON_TEXT);
    	navigateToHomeScreen();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }
    
    @Test
    public void verifyLoginButton(){
    	log.info("TC_07: To verify Login Button and its text.");
    	try{
    	String loginButton = loginFlow.loginPage.logInButton.getText();
    	Assert.assertEquals(loginButton, LOGIN_BUTTON_TEXT);
    	navigateToHomeScreen();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
    	
    	
    }

    @Test
	public void forgotUserIDButtonClickAction(){
		log.info("TC_08 & TC_09: Forgot User ID button tappable verification and redirection from retrieve userid to login screen");
		try{
       	loginFlow.loginPage.forgotUsetIdLink.click();
       	String forgotUserIDScreenHeader  = 	loginFlow.forgotUserIDPage.userIDScreenHeader.getText();
       	Assert.assertEquals(forgotUserIDScreenHeader, FORGOT_USERID_HEADER);
        loginFlow.forgotUserIDPage.forgotUserIdBackButton.click();
        navigateToHomeScreen();
		}
		catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
			Assert.fail(e.toString());
    	
    	}
    	
	}
  
    @Test
	public void forgotPasswordButtonClickAction(){
		log.info("TC_11 & TC_12: Forgot Password button tappable verification and redirection from retrieve password to login screen");
		try{
       	loginFlow.loginPage.forgotPasswordLink.click();
       	String forgotPasswordScreenHeader  = 	loginFlow.forgotPasswordPage.passwordScreenHeader.getText();
       	Assert.assertEquals(forgotPasswordScreenHeader, FORGOT_PASSWORD_HEADER);
       	loginFlow.forgotPasswordPage.forgotPasswordBackButton.click();
    	navigateToHomeScreen();
		}
		catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
			Assert.fail(e.toString());
    	
    	}
       
	}
  
	@Test
	public void signUpButtonClickAction(){
		log.info("TC_14 & 15: Sign up button tappable verification and redirection from Sign up screen to login screen");
        try{
		loginFlow.loginPage.signUpButton.click();
       	String signUpScreenHeader = loginFlow.signUpScreenPage.signUPScreenHeader.getText();
       	Assert.assertEquals(signUpScreenHeader, SIGN_UP_HEADER);
       	driver.pressKey(new KeyEvent(AndroidKey.BACK));
       	navigateToHomeScreen();
        }
        catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
        	Assert.fail(e.toString());
    	
    	}
       	
	}

    
	@Test
	public void loginButtonClickAction(){
		log.info("TC_17: Login button tappable verification");
		try{
       	Assert.assertEquals(driver.currentActivity(),LOGIN_SCREEN_ACTIVITY);
       	navigateToHomeScreen();
		}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
			Assert.fail(e.toString());
    	
    	}
	}
	/*
	@Test
	public void loginusingValidCredentials(){
		log.info("TC_18: User credential verification");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
        Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
       		Assert.fail(e.toString());
    	
    	}
       
       	

	}*/
	
	@Test //need to fix
	public void loginUsingInvalidCredentials() throws InterruptedException
	{
		log.info("TC_19: User credential verification using invalid credentials");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(INVALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(INVALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	//Thread.sleep(20000);
// testing code
       	ITesseract instance = new Tesseract();
		instance.setDatapath("tessdata");
		File res[] = new File[40];
		for(int i = 0; i< 30; i++){
			Thread.sleep(200);
			res[i]=driver.getScreenshotAs(OutputType.FILE);			
		}
       	
       	Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i = 0; i< 30; i++){
					try {
						screenText[i] = instance.doOCR(res[i]);
			            System.out.println(screenText[i]);
			            System.out.println(i+"------------------------------");
			        } catch (TesseractException e) {
			            System.err.println(e.getMessage());
			        }
				}				
			}			 
		});
	    t2.start();
 // testing code ends here      	
       	navigateToHomeScreen();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
       		Assert.fail(e.toString());
    	
    	}
       
	}
	
	@Test(priority = 1)
	public void invalidCredErrorVerification(){
		int flag = 0;
		for (int i = 0; i<30; i++){
			if(screenText[i].contains("Invalid User ID or Password")){
				flag = 1;
				break;
			}				
            //System.out.println("invalidCredErrorVerification test case passed");
		}
		if(flag == 0)
			Assert.fail("invalidCredErrorVerification test case failed");	
	}
/*	
	@Test
	public void loginWitho
	utEnteringCredentials(){
		log.info("TC_22 To validate the Login without entering any credentials");
		try{
		loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.userIdBlankErrorMessage.getText(),USERID_BLANK_ERROR);
       	Assert.assertEquals(loginFlow.loginPage.passwordBlankErrorMessage.getText(),PASSWORD_BLANK_ERROR);
       	navigateToHomeScreen();
		}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
			Assert.fail(e.toString());
    	
    	}
	}
	
	@Test
	public void loginWithpoutPassword(){
		log.info("TC_23: To validate the Login with just entering the user ID");
		try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.passwordBlankErrorMessage.getText(),PASSWORD_BLANK_ERROR);
       	navigateToHomeScreen();
		}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
			Assert.fail(e.toString());
    	
    	}
	}
	
	@Test
	public void loginWithoutUserID(){
		log.info("TC_24: To validate the Login with just entering the Password");
		try{
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	Assert.assertEquals(loginFlow.loginPage.userIdBlankErrorMessage.getText(),USERID_BLANK_ERROR);
       	navigateToHomeScreen();
		}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
			Assert.fail(e.toString());
    		
    	}
        
	}
	
	@Test
	public void loginUsingBlockedUserCredentials() throws InterruptedException{
		log.info("TC_25: To validate the Login with an inactive/blocked user credentials");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys("blocked");
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys("blocked");
       	loginFlow.loginPage.logInButton.click();
       	Thread.sleep(10000);
       	navigateToHomeScreen();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
       		Assert.fail(e.toString());

    	}
	}
	
	@Test
	public void loginUsingUserIdInUpperCase(){
	    log.info("TC_26: To validate login with valid user credentials having username in upper case");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME.toUpperCase());
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
    	Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
       		Assert.fail(e.toString());
    	}
       
	}
	
	@Test
	public void loginUsingUserIdInLowerCase(){
		log.info("TC_27: To validate login with valid user credentials having username in lower case");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME.toLowerCase());
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
        Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
       		Assert.fail(e.toString());
    	}
       
	}
	
	@Test
	public void loginUsingUserIdWithLeadingAndTrailingSpaces(){
		log.info("TC_28: To validate login with valid user credentials with leading and trailing spaces in user ID");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys("  "+VALID_USERNAME+"  ");
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
        Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
       		Assert.fail(e.toString());
    	}
        
	}
	
	@Test
	public void loginUsingPasswordWithLeadingAndTrailingSpaces(){
		log.info("TC_29: To validate login with valid user credentials with leading and trailing spaces in the password");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys("  "+VALID_PASSWORD+"  ");
       	loginFlow.loginPage.logInButton.click();
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
        Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    	    Utility.relaunchApp();
       		Assert.fail(e.toString());

    	}
       	
	}

	@Test
	public void loginUisngSpecialCharacterInPassword(){
		log.info("TC_30: To validate login with valid user credentials with special characters in the password");
       	log.info("entering user id");
       	try{
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	log.info("entering user password");
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	System.out.print(driver.currentActivity());
        Assert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).isDisplayed(), true);
        Utility.logout();
       	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e)
    	{
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	
    	}
       	
       	
	}*/
	
	

}
