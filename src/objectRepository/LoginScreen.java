package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen {
	
	@AndroidFindBy(id="icon_client")
	public WebElement caLOGO;
	
	@AndroidFindBy(id="et_username")
	public WebElement userIdLabel;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index=1]/TextInputLayout/android.widget.FrameLayout/android.widget.EditText")
	public WebElement userIdField;
	
	@AndroidFindBy(id="et_pass")
	public WebElement passwordLabel;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Password']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement passwordField;
	
	@AndroidFindBy(id="btn_forgot_id")
	public WebElement forgotUsetIdLink;
	
	@AndroidFindBy(id="btn_forget_password")
	public WebElement forgotPasswordLink;
	
	@AndroidFindBy(id="btn_sign_up_footer")
	public WebElement signUpButton;
	
	@AndroidFindBy(id="btn_footer_next")
	public WebElement logInButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your User ID.']")
	public WebElement userIdBlankErrorMessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your password.']")
	public WebElement passwordBlankErrorMessage;
}
