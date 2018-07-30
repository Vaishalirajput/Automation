package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.HomePageScreen;
import objectRepository.LoginScreen;

public class LoginFlowPage {
	public HomePageScreen homePage;
	public LoginScreen loginPage;
	public LoginFlowPage(WebDriver driver){
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		loginPage = PageFactory.initElements(driver, LoginScreen.class);				
	}

}
