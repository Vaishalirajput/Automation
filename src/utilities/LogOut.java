package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import basicConfig.LaunchApp;

public class LogOut {
	
	public static void logout()
	{   		
		WebDriver driver = (WebDriver)LaunchApp.getDriver();
		Dimension size = driver.manage().window().getSize();
       	size = driver.manage().window().getSize();
       	int starty = (int) (size.height * 0.8);
       	int endy = (int) (size.height * 0.6);
       	int startx = (int)(size.width * 0.19);
       	
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Drawer_Opened']")).click();
        TouchA.swipe(startx, starty, startx, endy, 1000);
        
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Sign Out']")).click();
        driver.findElement(By.id("com.mphrx.columbiaAsia.patient.debug:id/continue_action")).click();
	}

}
