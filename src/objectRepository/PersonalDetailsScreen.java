package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsScreen {
	
	@FindBy(id="toolbar_title")
	public WebElement personalDetailsScreenHeader;
	
	@FindBy(xpath="//TextInputLayout[@text='First Name']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement firstName;
	
	@FindBy(xpath="//TextInputLayout[@text='Middle Name (Optional)']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement middleName;
	
	@FindBy(xpath="//TextInputLayout[@text='Last Name (Optional)']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement lastName;
	
	@FindBy(xpath="//TextInputLayout[@text='Date of Birth']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement dob;
	
	@FindBy(xpath="//TextInputLayout[@text='Gender']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement gender;
	
	@FindBy(xpath="//android.widget.TextView[@text='Female']")
	public WebElement genderFemale;
	
	@FindBy(xpath="//android.widget.TextView[@text='Male']")
	public WebElement genderMale;
	
	@FindBy(xpath="//android.widget.TextView[@text='Indeterminate']")
	public WebElement genderIndeterminate;
	
	@FindBy(xpath="//TextInputLayout[@text='Mobile Number']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement mobileNumber;
	
    @FindBy(id="btn_proceed")
	public WebElement nextButton;
	
    @FindBy(xpath="//android.view.View[@index=14]")
	public WebElement test;
	
}
