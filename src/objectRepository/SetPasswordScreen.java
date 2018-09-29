package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetPasswordScreen {

	@FindBy(xpath="//TextInputLayout[@text='Password']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement password;
	
	@FindBy(xpath="//TextInputLayout[@text='Confirm Password']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement confirmPassword;
	
	@FindBy(id="btn_proceed")
	public WebElement nextButton;
	
}
