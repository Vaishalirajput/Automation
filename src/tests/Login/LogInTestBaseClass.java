package tests.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.*;
import basicConfig.*;

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
    public void LoginUsingUserID(){
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.userIdField.sendKeys("AA0611");
       	loginFlow.loginPage.passwordField.sendKeys("Test@123");
       	loginFlow.loginPage.logInButton.click();
       	driver.findElement(By.className("android.widget.ImageButton")).click();
       	TouchActions action = new TouchActions(driver);
       	Dimension size = driver.manage().window().getSize();
       	System.out.println(size.getHeight());
       	System.out.println(size.getWidth());
    }
	
	

}
