package basicConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import basicConfig.SystemLocations;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {
	
	private static LaunchApp instance;
	private  AndroidDriver driver = null;
	private  SystemLocations sysLoc = new SystemLocations();
	private  DesiredCapabilities capabilities = new DesiredCapabilities();
	private  Properties prop= new Properties();
	
	//public static void main(String[] args){
	private AndroidDriver launchApp(){
		prop = sysLoc.getConfigLocation();
		capabilities.setCapability("adbPort", 5039);
		capabilities.setCapability("platformName"	,prop.getProperty("platform"));
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
		capabilities.setCapability("app", prop.getProperty("app"));
		capabilities.setCapability("autoGrantPermissions", true);
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			System.out.print("driver cannot be initialized");
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static AndroidDriver getDriver() {
		if (instance == null) {
			synchronized (LaunchApp.class.getName()) {
				if (instance == null) {
					instance = new LaunchApp();
					instance.launchApp();
				}
			}
		}
		return instance.driver;
	}

}
