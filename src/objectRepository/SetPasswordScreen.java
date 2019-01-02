package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SetPasswordScreen {

	@AndroidFindBy(id="toolbar_title")
	public WebElement headerText;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Password']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement password;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Confirm Password']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement confirmPassword;
	
	@AndroidFindBy(id="btn_proceed")
	public WebElement nextButton;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password And Confirm Password should be same.']")
	public WebElement passwordMismatchError;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your password.']")
	public WebElement passwordFieldBlankError;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your password.']")
	public WebElement confirmPasswordFieldBlankError;
	
	@AndroidFindBy(id="chk_box_1")
	public WebElement checkBox;
	
}
