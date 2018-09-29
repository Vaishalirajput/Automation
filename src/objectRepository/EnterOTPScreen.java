package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterOTPScreen {

	@FindBy(id="toolbar_title")
	public WebElement headerText;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement backButton;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement screenText;	
	
	@FindBy(id="et_manual_otp_patient")
	public WebElement otpInputField;
	
	@FindBy(id="tv_auto_verification_failed")
	public WebElement otpAutoVerificationFailureText;

	@FindBy(id="tv_otp_verify_text_patient")
	public WebElement otpAutoVerificationText;
	
	@FindBy(id="btn_proceed")
	public WebElement nextButton;
	
	
	
	
}
