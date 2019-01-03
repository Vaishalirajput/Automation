package tests.Login;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basicConfig.Consts;
import basicConfig.LaunchApp;
import io.appium.java_client.android.AndroidDriver;
import modules.LoginFlow;
import utilities.Utility;

public class LogInTestScripts {
	public static  AndroidDriver driver = null; 
	LoginFlow loginFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	
	private String screenText[] = new String[40];
	
    @BeforeSuite
	public void LogInTestScripts(){
    	driver = LaunchApp.getDriver();
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		loginFlow = new LoginFlow(driver);
		loginFlow.launchScreen.skipButton.click();
	}
    
    @Test
    public void loginUsingValidCredentials(){
    	Utility.login();
    }

}
