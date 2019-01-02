package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PersonalDetailsScreen {
	
	@AndroidFindBy(id="toolbar_title")
	public WebElement personalDetailsScreenHeader;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='First Name']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement firstName;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Middle Name (Optional)']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement middleName;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Last Name (Optional)']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement lastName;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Date of Birth']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement dob;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Gender']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement gender;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Female']")
	public WebElement genderFemale;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Male']")
	public WebElement genderMale;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Indeterminate']")
	public WebElement genderIndeterminate;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Mobile Number']/android.widget.FrameLayout/android.widget.EditText")
	public WebElement mobileNumber;
	
    @AndroidFindBy(id="btn_proceed")
	public WebElement nextButton;
	
    @AndroidFindBy(xpath="//android.view.View[@index=3]")
	public WebElement testDay;
    
    @AndroidFindBy(id="amdp_ok")
	public WebElement okButtonOnCal;
    
    @AndroidFindBy(className="android.widget.ImageButton")
	public WebElement backButton;
    
    @AndroidFindBy(id="text1")
	public WebElement countryCode;
    
    //validation errors on personal details screen
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your first name.']")
   	public WebElement firstNameFieldBlankError;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Please select your Date of Birth.']")
   	public WebElement dobFieldBlankError;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Please select your gender.']")
   	public WebElement genderBlankError;
	
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your mobile number.']")
   	public WebElement mobileNoFieldBlankError;
    
    //number validation in name fields on personal details screen
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='First Name must not contain number(s).']")
   	public WebElement numberInFirstNameField;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Middle Name must not contain number(s).']")
   	public WebElement numberInMiddleNameField;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Last Name must not contain number(s).']")
   	public WebElement numberInLastNameField;
    
}
