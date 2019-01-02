package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterOTPScreen {

	@AndroidFindBy(id="toolbar_title")
	public WebElement headerText;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement backButton;
	
	@AndroidFindBy(id="tv_enter_code")
	public WebElement screenText;	
	
	@AndroidFindBy(id="et_manual_otp_patient")
	public WebElement otpInputField;
	
	@AndroidFindBy(id="tv_auto_verification_failed")
	public WebElement otpAutoVerificationFailureText;

	@AndroidFindBy(id="tv_otp_verify_text_patient")
	public WebElement otpAutoVerificationText;
	
	@AndroidFindBy(id="btn_proceed")
	public WebElement nextButton;
	
	@AndroidFindBy(id="edit_number")
	public WebElement pencilIcon;
		
	@AndroidFindBy(id="btn_resend_otp")
	public WebElement resendButton;
	
	
}
