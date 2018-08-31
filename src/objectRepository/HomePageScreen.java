package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageScreen {

	@FindBy(xpath="//android.widget.TextView[@text='My Appointments']")
	public WebElement appointmentTab; 
	
	@FindBy(id="design_bottom_sheet")
	public WebElement loginWindow;
	
	@FindBy(id="tv_title_login_proceed_as_guest")
	public WebElement loginWindowHeaderText;
	
	@FindBy(id="btn_bottom_sheet_cross")
	public WebElement loginWindowCrossButton;

	@FindBy(id="tv_body_text")
	public WebElement loginWindowBodyText;
	
	@FindBy(id="btn_action_start")
	public WebElement loginButton;
	
	@FindBy(id="btn_action_end")
	public WebElement signUpButton;
	
	//Appointment specific
	@FindBy(id="tv_book_appointment")
	public WebElement bookAppointmentLabel;
	
	@FindBy(id="ico_location")
	public WebElement locationIcon;
	
	@FindBy(id="location_name")
	public WebElement selectHospitalDropDownText;
	
	@FindBy(id="img_user")
	public WebElement selectHospitalDropDownArrow;
	
	@FindBy(id="rel_physcian_or_speciality")
	public WebElement doctorAndSpecialityField;
	
	@FindBy(id="phy_splty_name")
	public WebElement doctorAndSpecialityFieldPlaceHolderText;
	
	
	
	
	
	

}
