package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen {
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/icon_client")
	public WebElement caLOGO;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/et_username")
	public WebElement userIdLabel;
	
	@FindBy(xpath="//TextInputLayout[@contains('resource-id','com.mphrx.columbiaAsia.patient.debug:id/et_username')]/android.widget.FrameLayout/android.widget.EditText")
	public WebElement userIdField;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/et_pass")
	public WebElement passwordLabel;
	
	@FindBy(xpath="//TextInputLayout[@contains('resource-id','com.mphrx.columbiaAsia.patient.debug:id/et_pass')]/android.widget.FrameLayout/android.widget.EditText")
	public WebElement passwordField;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_forgot_id")
	public WebElement forgotUsetIdLink;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_forget_password")
	public WebElement forgotPasswordLink;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_sign_up_footer")
	public WebElement signUpButton;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_footer_next")
	public WebElement logInButton;
}
