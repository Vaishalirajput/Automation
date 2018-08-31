package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.HomePageScreen;
import objectRepository.LaunchScreen;
import objectRepository.LoginScreen;

public class AppointmentFlow {
	public HomePageScreen homePage;
	public LoginScreen loginPage;
	public LaunchScreen launchScreen;
	
	public AppointmentFlow(WebDriver driver){
		launchScreen = PageFactory.initElements(driver, LaunchScreen.class);
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		loginPage = PageFactory.initElements(driver, LoginScreen.class);
	}
}
