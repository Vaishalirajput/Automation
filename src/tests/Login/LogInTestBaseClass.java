package tests.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.*;
import basicConfig.*;
import io.appium.java_client.android.AndroidDriver;

public class LogInTestBaseClass {
	
	public static  WebDriver driver = null; 
	SoftAssert sAssert = null;
	LoginFlowPage loginFlow;
	
    @BeforeSuite
	public void lauchAppforLogin(){
    	driver = (WebDriver)LaunchApp.getDriver();
		System.out.println("driver initialized");
		loginFlow = new LoginFlowPage(driver);
		sAssert = new SoftAssert();
		loginFlow.launchScreen.skipButton.click();
	}
    
    @Test
    public void LoginUsingUsername(){
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();

    }
	
	

}
