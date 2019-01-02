package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterMRNScreen {

	@AndroidFindBy(id="toolbar_title")
	public WebElement headerText;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement backButton;
		
	@AndroidFindBy(id="tv_static_mrn_hint")
	public WebElement screenText;
	
	@AndroidFindBy(id="spinner_location_mrn")
	public WebElement locationDropDown;
	
	@AndroidFindBy(id="btn_mrnNext")
	public WebElement nextButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter MRN.']")
    public WebElement MRNFieldBlankError;
	
	@AndroidFindBy(xpath="//TextInputLayout[@index=2]/android.widget.FrameLayout/android.widget.EditText")
    public WebElement enterMRNInputField;
	
}
