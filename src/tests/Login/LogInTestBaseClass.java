
package tests.Login;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.*;
import utilities.*;
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
    public void LLoginUsingUserID() throws InterruptedException{
    	loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.userIdField.sendKeys("AA0611");
       	loginFlow.loginPage.passwordField.sendKeys("Test@123");
       	loginFlow.loginPage.logInButton.click();
       	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       	sAssert.assertEquals(driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")).getText(), "Home");
       	TouchA.tap(950, 800);
       
        LogOut.logout();
        
        
    }
    
	
	

}
