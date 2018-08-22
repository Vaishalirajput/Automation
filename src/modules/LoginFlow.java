package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.*;


public class LoginFlow {
	public HomePageScreen homePage;
	public LoginScreen loginPage;
	public LaunchScreen launchScreen;
	public ForgotUserIdScreen forgotUserIDPage;
	public ForgotPasswordScreen forgotPasswordPage;
	public SignUpScreen signUpScreenPage;

	public LoginFlow(WebDriver driver){
		launchScreen = PageFactory.initElements(driver, LaunchScreen.class);
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		loginPage = PageFactory.initElements(driver, LoginScreen.class);	
		forgotUserIDPage = PageFactory.initElements(driver, ForgotUserIdScreen.class);
		forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordScreen.class);
		signUpScreenPage = PageFactory.initElements(driver, SignUpScreen.class);



	}

}
