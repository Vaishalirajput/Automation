package basicConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import basicConfig.SystemLocations;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {
	
	private static LaunchApp instance;
	private  AndroidDriver driver = null;
	private  SystemLocations sysLoc = new SystemLocations();
	private  DesiredCapabilities capabilities = new DesiredCapabilities();
	private  Properties prop= new Properties();
	
	//public static void main(String[] args){
	private AndroidDriver launchApp(){
		prop = sysLoc.getConfigLocation();
		File appDir = new File("apks");
	    File app = new File(appDir, prop.getProperty("app"));
		capabilities.setCapability("adbPort", 5039);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME	,prop.getProperty("platform"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("autoGrantPermissions", true);
				
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			System.out.print("driver cannot be initialized");
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public static AndroidDriver getDriver() {
		if (instance == null) {
			synchronized (LaunchApp.class.getName()) {
				if (instance == null) {
					//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
					//service.start();  test
					instance = new LaunchApp();
					instance.launchApp();
				}
			}
		}
		
		return instance.driver;
		
	}
	
	/*
	//capabilities.setCapability("noReset", true);
	public static void setcaps(String key, Boolean value) throws MalformedURLException{
		instance.capabilities.setCapability("noReset", true);
		instance.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),instance.capabilities);
	}*/



}
