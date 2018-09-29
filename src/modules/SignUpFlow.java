package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.*;


public class SignUpFlow {
	public HomePageScreen homePage;
	public LaunchScreen launchScreen;
	public SignUpScreen signUpPage;
	public PersonalDetailsScreen personalDetailsPage;
	public EnterOTPScreen enterOTPPage;
	public SetPasswordScreen setPasswordPage;
	
	public SignUpFlow(WebDriver driver){
		
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		launchScreen = PageFactory.initElements(driver, LaunchScreen.class);
		signUpPage = PageFactory.initElements(driver, SignUpScreen.class);
		personalDetailsPage = PageFactory.initElements(driver, PersonalDetailsScreen.class);
		enterOTPPage = PageFactory.initElements(driver, EnterOTPScreen.class);
		setPasswordPage = PageFactory.initElements(driver, SetPasswordScreen.class);
	}
}
