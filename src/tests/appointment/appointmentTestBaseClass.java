package tests.appointment;

import java.io.IOException;

import org.apache.log4j.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import modules.AppointmentFlow;

import tests.Login.LogInTestBaseClass;




public class appointmentTestBaseClass {
	public static  AndroidDriver driver = null; 
	static AppointmentFlow appointmentFlow;
	static Logger log = Logger.getLogger(LogInTestBaseClass.class.getName());
	/*
	@Test
	public void lauchAppforLogin() throws InterruptedException{
		try{
    	driver = LaunchApp.getDriver();    	
		PropertyConfigurator.configure(Consts.LOG_PROP_FILE_PATH);
		log.info("driver initialized successfully");
		appointmentFlow = new AppointmentFlow(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appointmentFlow.launchScreen.skipButton.click();
		appointmentFlow.homePage.appointmentTab.click();
		appointmentFlow.homePage.loginButton.click();
		appointmentFlow.loginPage.userIdField.sendKeys("test");
		appointmentFlow.loginPage.passwordField.sendKeys("test");
		appointmentFlow.loginPage.logInButton.click();
		
		}catch(java.lang.AssertionError e){
			Assert.fail();
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			Assert.fail();
		}
		//Utility.login();
		
		//Thread.sleep(10000);
		
		//Utility.logout();
	}
		
	@Test
	public void relaunchApp(){
		System.out.println("my name is vaishali");
		try{
			Assert.assertEquals("test", "vaishali");
		}
	catch(java.lang.AssertionError e)
	{
		System.out.println("indside catch");
	}
		System.out.println("came out of catch");
	}
	
	@Test
	public void relaunchtApp() throws InterruptedException{
		Thread.sleep(5000);
		
		System.out.println("my name is vaishali2");
	}
	
	
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
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		driver = LaunchApp.getDriver();
		appointmentFlow = new AppointmentFlow(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appointmentFlow.launchScreen.skipButton.click();
		appointmentFlow.homePage.appointmentTab.click();
		appointmentFlow.homePage.loginButton.click();
		appointmentFlow.loginPage.userIdField.sendKeys("test");
		appointmentFlow.loginPage.passwordField.sendKeys("test");
		appointmentFlow.loginPage.logInButton.click();
		
		ITesseract instance = new Tesseract();
		instance.setDatapath("tessdata");
		File res[] = new File[40];
		for(int i = 0; i< 40; i++){
			res[i]=driver.getScreenshotAs(OutputType.FILE);			
		}
		
		for(int i = 0; i< 40; i++){
			try {
	            String result = instance.doOCR(res[i]);
	            System.out.println(result);
	            System.out.println(i+"------------------------------");
	        } catch (TesseractException e) {
	            System.err.println(e.getMessage());
	        }
		}
		
		appointmentFlow.loginPage.logInButton.click();
		/*
		String filename = screenshot("C:/Users/Vaishali_Rajput/Desktop/Screenshots/");
		System.out.println("C:/Users/Vaishali_Rajput/Desktop/Screenshots/"+filename+".png");
        File imageFile = new File("C:/Users/Vaishali_Rajput/Desktop/Screenshots/"+filename+".png");
       // ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
       // instance.setDatapath("tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }*/
		
	/*	
    }
	
	public static String screenshot(String path_screenshot) throws IOException{
	    File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File(path_screenshot + filename +".png");
	    FileUtils test = FileUtils.getFileUtils();
	    test.copyFile(srcFile,targetFile);
	    return filename;
	}


	
	/*
public static void main(String[] args) throws IOException, InterruptedException {

	//String filename = screenshot("C:/Users/Vaishali_Rajput/Desktop/Screenshots/");
	//System.out.println("C:/Users/Vaishali_Rajput/Desktop/Screenshots/"+filename+".jpg");
    File imageFile = new File("C:/Users/Vaishali_Rajput/Desktop/Screenshots/437bdf83-d742-498f-b872-16c560deb32a.jpg");
    ITesseract instance = new Tesseract();  // JNA Interface Mapping
    // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
    instance.setDatapath("tessdata"); // path to tessdata directory

    try {
        String result = instance.doOCR(imageFile);
        System.out.println(result);
    } catch (TesseractException e) {
        System.err.println(e.getMessage());
    }
}*/
	public static void main(String[] args) throws IOException, InterruptedException {	
	AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	service.start();
	
	}
}
