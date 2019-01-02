package utilities;

import static credentials.LoginCredentials.VALID_PASSWORD;
import static credentials.LoginCredentials.VALID_USERNAME;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import basicConfig.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import modules.LoginFlow;

public class Utility {
	private static int a = 0;

	public static AndroidDriver driver = LaunchApp.getDriver();;
	static LoginFlow loginFlow = new LoginFlow(driver);;
	
	public static void login(){
		loginFlow.homePage.appointmentTab.click();
       	loginFlow.homePage.loginButton.click();
       	loginFlow.loginPage.userIdField.sendKeys(VALID_USERNAME);
       	loginFlow.loginPage.passwordField.sendKeys(VALID_PASSWORD);
       	loginFlow.loginPage.logInButton.click();
       	
       //	btnAccept
       	//com.mphrx.columbiaAsia.patient.debug:id/btnAccept
       	
	}
	
	public static void logout()
	{  
		Dimension size = driver.manage().window().getSize();
       	int starty = (int) (size.height * 0.8);
       	int endy = (int) (size.height * 0.6);
       	int startx = (int)(size.width * 0.5);
        
        TouchA.tap((size.width), (int) (size.height * 0.31));
       	System.out.print("clicked on side test");
       	if(a==0){
       		a=1;
       		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Drawer_Opened']")).click();
        System.out.print("clicked on side drawer");
        try{
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Sign Out']")).click();
        }catch(NoSuchElementException e){
        	TouchA.swipe(startx, starty, startx, endy, 1000);
        	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Sign Out']")).click();
        }
        driver.findElement(By.id("continue_action")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void relaunchApp(){
		driver.closeApp();
		driver.launchApp();
		loginFlow.launchScreen.skipButton.click();
	}
	

}
