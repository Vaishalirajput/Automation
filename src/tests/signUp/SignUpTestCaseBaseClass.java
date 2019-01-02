package tests.signUp;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import basicConfig.Consts;
import basicConfig.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import modules.*;
import tests.Login.LogInTestBaseClass;
import utilities.GetDataBaseConnection;
import utilities.TouchA;
import utilities.Utility;
import dataRepository.*;

public class SignUpTestCaseBaseClass {
	public static  AndroidDriver driver = null; 
	SignUpFlow signUpFlow = null;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	Random rand = new Random();
	int mobileNumber =  rand.nextInt((1000999999 - 1000000000) + 1) + 1000000000;
	MongoCollection<Document> userOTP, user= null;
	
    @BeforeSuite
	public void lauchAppforSignUp(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		signUpFlow = new SignUpFlow(driver);
		signUpFlow.launchScreen.skipButton.click();
    	MongoDatabase db = GetDataBaseConnection.connectToDatabase("10.151.15.37","27018","catest_minervadb","catest_minerva","catest_minerva");
    	System.out.println("Connected to the database successfully"); 
        userOTP = db.getCollection("userOTP");
        user = db.getCollection("user");

	}
    
    @BeforeMethod
    public void navigateOnSignUpScreen()
    {
    	try{
    	signUpFlow.homePage.appointmentTab.click();
    	}catch(StaleElementReferenceException e){
    		signUpFlow.homePage.appointmentTab.click();
    	}
    	signUpFlow.homePage.signUpButton.click();
    }
     
    private void navigateOnHomePage()
    {
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
        signUpFlow.homePage.loginWindowCrossButton.click();
    }

    @Test
    public void verifyHeaderOnSignUpScreen(){
    	try{
    	Assert.assertEquals(signUpFlow.signUpPage.signUPScreenHeader.getText(), SignUpPageData.SIGN_UP_HEADER);
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyButtonsOnSignUpScreen(){
    	try{
    	Assert.assertEquals(signUpFlow.signUpPage.caNotVisited.getText(),SignUpPageData.CA_NOT_VISITED_TEXT);
    	Assert.assertEquals(signUpFlow.signUpPage.caAlreadyVisited.getText(), "I have visited Columbia Asia and have a Medical Record Number");
    	Assert.assertEquals(signUpFlow.signUpPage.patientHasMRN.getText(),"YES");
    	Assert.assertEquals(signUpFlow.signUpPage.patientHasNoMRN.getText(),"NO");
    	navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void backButtonClickActionOnSignUpScreen(){
    	try{
    		signUpFlow.signUpPage.signUpBackButton.click();
    		Assert.assertEquals(signUpFlow.homePage.loginWindow.isDisplayed(),true);
    		signUpFlow.homePage.loginWindowCrossButton.click();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    
    @Test
    public void clickActionOnYESButton(){
    	try{
    		signUpFlow.signUpPage.caAlreadyVisited.click();
    		Assert.assertEquals(signUpFlow.enterMRNScreen.headerText.getText(),"Enter MRN");
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void clickActionOnNoButton(){
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(),"Your Personal Details");
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }

    @Test
    public void personalDetailsScreenBackButtonClickAction()   
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.backButton.click();
    		Assert.assertEquals(signUpFlow.signUpPage.signUPScreenHeader.getText(), SignUpPageData.SIGN_UP_HEADER);
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void headerTextOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(),PersonalDetailsPageData.HEADER_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyFirstNameFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.firstName.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyMiddleNameFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.middleName.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyLastNameFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.lastName.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyDOBFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.dob.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyGenderFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.gender.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyMobileNoFieldOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.mobileNumber.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyGenderDropDownOptionsOnPersonalDetailsScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.gender.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.genderMale.getText(),"Male");
    		Assert.assertEquals(signUpFlow.personalDetailsPage.genderFemale.getText(),"Female");
    		Assert.assertEquals(signUpFlow.personalDetailsPage.genderIndeterminate.getText(),"Indeterminate");
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }

    @Test
    public void verifyDefaultCountryCode()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.countryCode.getText(),"+91");
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    } 
    
    @Test
    public void NextButtonClickActionWithoutEnteringValues()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.nextButton.click();
    		Assert.assertEquals(signUpFlow.personalDetailsPage.firstNameFieldBlankError.isDisplayed(),true);
    		Assert.assertEquals(signUpFlow.personalDetailsPage.dobFieldBlankError.isDisplayed(),true);
    		Assert.assertEquals(signUpFlow.personalDetailsPage.genderBlankError.isDisplayed(),true);
    		
    		Dimension size = driver.manage().window().getSize();
           	int starty = (int) (size.height * 0.8);
           	int endy = (int) (size.height * 0.6);
           	int startx = (int)(size.width * 0.5);
           	
           	TouchA.swipe(startx, starty, startx, endy, 1000);
    		
    		Assert.assertEquals(signUpFlow.personalDetailsPage.mobileNoFieldBlankError.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    } 
  
    //need to be fixed
    @Test
    public void minimumAgeValidation()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		//signUpFlow.personalDetailsPage.dob.click();
    		
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
   
    //need to be fixed
    @Test
    public void leadingAndTrailingSpaceInNameFields()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("  vaishali  ");
    		signUpFlow.personalDetailsPage.middleName.sendKeys("  M  ");
    		signUpFlow.personalDetailsPage.lastName.sendKeys("  Rajput  ");
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void numberInNameFields()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("vaishali1");
    		signUpFlow.personalDetailsPage.middleName.sendKeys("m1");
    		signUpFlow.personalDetailsPage.lastName.sendKeys("1Rajput");
    		Assert.assertEquals(signUpFlow.personalDetailsPage.numberInFirstNameField.isDisplayed(),true);
    		Assert.assertEquals(signUpFlow.personalDetailsPage.numberInMiddleNameField.isDisplayed(),true);
    		Assert.assertEquals(signUpFlow.personalDetailsPage.numberInLastNameField.isDisplayed(),true);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
 //Sign Up without MRN → Let’s Verify screen   
    
    @Test
    public void verifyHeaderTextOnLetsVerifyScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.enterOTPPage.headerText.getText(), EnterOTPPage.HEADER_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | org.openqa.selenium.StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyBackButtonClickActionOnLetsVerifyScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	signUpFlow.enterOTPPage.backButton.click();
        	
        	Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(), PersonalDetailsPageData.HEADER_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | org.openqa.selenium.StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void verifyTextOnLetsVerifyScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.enterOTPPage.screenText.getText(), EnterOTPPage.ENTER_OTP_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | org.openqa.selenium.StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    public void autoverificationTextOnLetsVerifyScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.enterOTPPage.otpAutoVerificationText.getText(),EnterOTPPage.OTP_AUTO_VERIFICATION_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    public void autoverificationFailureTextOnLetsVerifyScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.enterOTPPage.otpAutoVerificationFailureText.getText(),EnterOTPPage.OTP_AUTO_VERIFICATION_FAILURE_TEXT);
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError |StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    public void pencilIconClickOnLetsVerifyScreen()
    {
    	try{
    		
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	signUpFlow.enterOTPPage.pencilIcon.click();
        	Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(), PersonalDetailsPageData.HEADER_TEXT);

    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }


    
    @Test
    public void resendButtonClickOnLetsVerifyScreen()  
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp1 = OTP.iterator().next().getString("oneTimePassword");
        	signUpFlow.enterOTPPage.resendButton.click();
        	Thread.sleep(3000);
        	OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp2 = OTP.iterator().next().getString("oneTimePassword");
        	System.out.println("otp1 "+ otp1+ "otp2 "+otp2);
        	Assert.assertEquals(otp1.equals(otp2), false);
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    
    @Test
    public void NextButtonClickWithoutEnteringOTPOnLetsVerifyScreen()  
    {
    	try{
    		
    		System.out.println("NextButtonClickWithoutEnteringOTPOnLetsVerifyScreen");
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError| StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
  
    @Test
    public void NextButtonClickOnEnteringIncorrectOTPOnLetsVerifyScreen()  
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	String otp = "1234";
        	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
          	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void NextButtonClickOnEnteringOTPOnLetsVerifyScreen()  
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();       	
        	signUpFlow.setPasswordPage.backButton.click();
        	//driver.pressKey(new KeyEvent(AndroidKey.BACK));
          	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    } 

  // Sign Up without MRN → Set Password
    
    @Test
    public void verifyHeaderTextOnSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	signUpFlow.setPasswordPage.backButton.click();
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    
    @Test
    public void backButtonClickActionOnSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	signUpFlow.setPasswordPage.backButton.click();
        	Assert.assertEquals(signUpFlow.enterOTPPage.headerText.getText(), EnterOTPPage.HEADER_TEXT);
        	
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }

    @Test
    public void passwordMismatchOnSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	signUpFlow.setPasswordPage.password.sendKeys("Test@123");
        	signUpFlow.setPasswordPage.confirmPassword.sendKeys("Test@1234");

        	signUpFlow.setPasswordPage.nextButton.click();
        	
        	//Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	//signUpFlow.setPasswordPage.backButton.click();
        	//Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(), PersonalDetailsPageData.HEADER_TEXT);
        	Assert.assertEquals(signUpFlow.setPasswordPage.passwordMismatchError.isDisplayed(), true);
        	signUpFlow.setPasswordPage.backButton.click();
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }

    @Test
    public void passwordFieldsBlankOnSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	//signUpFlow.setPasswordPage.password.sendKeys("Test@123");
        	//signUpFlow.setPasswordPage.confirmPassword.sendKeys("Test@1234");

        	signUpFlow.setPasswordPage.nextButton.click();
        	
        	//Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	//signUpFlow.setPasswordPage.backButton.click();
        	//Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(), PersonalDetailsPageData.HEADER_TEXT);
        	//Assert.assertEquals(signUpFlow.setPasswordPage.passwordMismatchError.isDisplayed(), true);
        	Assert.assertEquals(signUpFlow.setPasswordPage.passwordFieldBlankError.isDisplayed(), true);
        	Assert.assertEquals(signUpFlow.setPasswordPage.confirmPasswordFieldBlankError.isDisplayed(), true);
        	signUpFlow.setPasswordPage.backButton.click();
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
     
    @Test
    public void clickNextButtonWithoutSelectingCheckBoxSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	signUpFlow.setPasswordPage.password.sendKeys("Test@123");
        	signUpFlow.setPasswordPage.confirmPassword.sendKeys("Test@1234");
        	signUpFlow.setPasswordPage.checkBox.click();
        	signUpFlow.setPasswordPage.nextButton.click();
        	Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	//Assert.assertEquals(signUpFlow.setPasswordPage.headerText.getText(), SetPasswordPageData.HEADER_TEXT);
        	//signUpFlow.setPasswordPage.backButton.click();
        	//Assert.assertEquals(signUpFlow.personalDetailsPage.personalDetailsScreenHeader.getText(), PersonalDetailsPageData.HEADER_TEXT);
        	//Assert.assertEquals(signUpFlow.setPasswordPage.passwordMismatchError.isDisplayed(), true);
        	//Assert.assertEquals(signUpFlow.setPasswordPage.passwordFieldBlankError.isDisplayed(), true);
        	//Assert.assertEquals(signUpFlow.setPasswordPage.confirmPasswordFieldBlankError.isDisplayed(), true);
        	signUpFlow.setPasswordPage.backButton.click();
        	signUpFlow.enterOTPPage.backButton.click();
        	signUpFlow.personalDetailsPage.backButton.click();
    		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
    		navigateOnHomePage();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
      
 
  //Sign Up without MRN → success page
    @Test
    public void clickNextButtonOnSetPasswordScreen()
    {
    	try{
    		signUpFlow.signUpPage.caNotVisited.click();
    		signUpFlow.personalDetailsPage.firstName.sendKeys("Vaishali");
    		signUpFlow.personalDetailsPage.dob.click();
        	signUpFlow.personalDetailsPage.testDay.click();
        	signUpFlow.personalDetailsPage.okButtonOnCal.click();
        	signUpFlow.personalDetailsPage.gender.click();
        	signUpFlow.personalDetailsPage.genderFemale.click();
        	signUpFlow.personalDetailsPage.mobileNumber.sendKeys(Integer.toString(mobileNumber));
        	signUpFlow.personalDetailsPage.nextButton.click();
        	
        	Thread.sleep(2000);
        	Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
        	String otp = OTP.iterator().next().getString("oneTimePassword");
        	
         	String abc[] = otp.split("");
        	
        	driver.findElement(By.id("et1")).sendKeys(abc[0]);
        	driver.findElement(By.id("et2")).sendKeys(abc[1]);
        	driver.findElement(By.id("et3")).sendKeys(abc[2]);
        	driver.findElement(By.id("et4")).sendKeys(abc[3]);
        	signUpFlow.enterOTPPage.nextButton.click();
        	
        	signUpFlow.setPasswordPage.password.sendKeys("Test@123");
        	signUpFlow.setPasswordPage.confirmPassword.sendKeys("Test@123");
        	
        	signUpFlow.setPasswordPage.nextButton.click();
        	
        	Assert.assertEquals(signUpFlow.successPage.headerText.getText(), SuccessScreenData.HEADER_TEXT);
        	Assert.assertEquals(signUpFlow.successPage.screenTextOne.getText(), SuccessScreenData.SCREEN_TEXT_ONE);
        	//Assert.assertEquals(signUpFlow.successPage.screenTextTwo.getText(), SuccessScreenData.SCREEN_TEXT_TWO);
        	Assert.assertEquals(signUpFlow.successPage.nextButton.getText(), SuccessScreenData.NEXT_BUTTON);

        	String userId = user.find().sort(Sorts.descending("_id")).iterator().next().getString("username");
        	//String userId = USER.iterator().next().getString("username");
        	Assert.assertEquals(signUpFlow.successPage.userId.getText(), userId);
        	signUpFlow.successPage.nextButton.click();
        	
        	//Utility.logout();
    	}catch(org.openqa.selenium.NoSuchElementException | java.lang.AssertionError | InterruptedException | StaleElementReferenceException e){
    		Utility.relaunchApp();
    		Assert.fail(e.toString());
    	}
    }
    

    
    
    /* 

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
  
    */
    
    
}
