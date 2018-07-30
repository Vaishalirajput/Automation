package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.*;


public class LoginFlowPage {
	public HomePageScreen homePage;
	public LoginScreen loginPage;
	public LaunchScreen launchScreen;
	public LoginFlowPage(WebDriver driver){
		launchScreen = PageFactory.initElements(driver, LaunchScreen.class);
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		loginPage = PageFactory.initElements(driver, LoginScreen.class);				
	}

}
