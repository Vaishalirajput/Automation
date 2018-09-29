package tests.appointment;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basicConfig.Consts;
import basicConfig.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import modules.AppointmentFlow;
import tests.Login.LogInTestBaseClass;
import utilities.*;


public class appointmentTestBaseClass {
	public static  AndroidDriver driver = null; 
	AppointmentFlow appointmentFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
	@Test
	public void lauchAppforLogin() throws InterruptedException{
    	driver = LaunchApp.getDriver();    	
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		appointmentFlow = new AppointmentFlow(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//appointmentFlow.launchScreen.getSkipButton().click();
		Utility.login();
		
		Thread.sleep(10000);
		
		Utility.logout();
	}
	
	@Test
	public void relaunchApp(){
		System.out.println("my name is vaishali");
	}
	/*	
	@Test
	public void relaunchApp(){
		Utility.relaunchApp();
	}
	
	@Test(groups = { "sanity" })
	public void testone(){
		System.out.print("this is sanity test");
	}
	
	@Test(groups = { "regression" })
	public void testtwo(){
		System.out.print("this is regression test");
	}*/
	
	
}
