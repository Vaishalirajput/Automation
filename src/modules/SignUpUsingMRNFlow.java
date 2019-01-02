package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import objectRepository.EnterMRNScreen;
import objectRepository.EnterOTPScreen;
import objectRepository.HomePageScreen;
import objectRepository.LaunchScreen;
import objectRepository.SetPasswordScreen;
import objectRepository.SignUpScreen;
import objectRepository.SuccessScreen;

public class SignUpUsingMRNFlow {

	public HomePageScreen homePage;
	public LaunchScreen launchScreen;
	public SignUpScreen signUpPage;
	//public PersonalDetailsScreen personalDetailsPage;
	public EnterOTPScreen enterOTPPage;
	public SetPasswordScreen setPasswordPage;
	public EnterMRNScreen enterMRNPage;
	public SuccessScreen successPage;
	
public SignUpUsingMRNFlow(WebDriver driver){
		
		homePage = PageFactory.initElements(driver, HomePageScreen.class);
		launchScreen = PageFactory.initElements(driver, LaunchScreen.class);
		signUpPage = PageFactory.initElements(driver, SignUpScreen.class);
		enterMRNPage = PageFactory.initElements(driver, EnterMRNScreen.class);
		//personalDetailsPage = PageFactory.initElements(driver, PersonalDetailsScreen.class);
		enterOTPPage = PageFactory.initElements(driver, EnterOTPScreen.class);
		setPasswordPage = PageFactory.initElements(driver, SetPasswordScreen.class);
		successPage = PageFactory.initElements(driver, SuccessScreen.class);
	}

}
