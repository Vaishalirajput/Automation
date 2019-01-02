package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageScreen {

	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Appointments']")
	public WebElement appointmentTab; 
	
	@AndroidFindBy(id="design_bottom_sheet")
	public WebElement loginWindow;
	
	@AndroidFindBy(id="tv_title_login_proceed_as_guest")
	public WebElement loginWindowHeaderText;
	
	@AndroidFindBy(id="btn_bottom_sheet_cross")
	public WebElement loginWindowCrossButton;

	@AndroidFindBy(id="tv_body_text")
	public WebElement loginWindowBodyText;
	
	@AndroidFindBy(id="btn_action_start")
	public WebElement loginButton;
	
	@AndroidFindBy(id="btn_action_end")
	public WebElement signUpButton;
	
	//Appointment specific
	@AndroidFindBy(id="tv_book_appointment")
	public WebElement bookAppointmentLabel;
	
	@AndroidFindBy(id="ico_location")
	public WebElement locationIcon;
	
	@AndroidFindBy(id="location_name")
	public WebElement selectHospitalDropDownText;
	
	@AndroidFindBy(id="img_user")
	public WebElement selectHospitalDropDownArrow;
	
	@AndroidFindBy(id="rel_physcian_or_speciality")
	public WebElement doctorAndSpecialityField;
	
	@AndroidFindBy(id="phy_splty_name")
	public WebElement doctorAndSpecialityFieldPlaceHolderText;
	
	
	
	
	
	

}
