package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageScreen {

	@FindBy(xpath="//android.widget.TextView[@text='My Appointments']")
	public WebElement appointmentTab; 
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/design_bottom_sheet")
	public WebElement loginWindow;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/tv_title_login_proceed_as_guest")
	public WebElement loginWindowHeaderText;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_bottom_sheet_cross")
	public WebElement loginWindowCrossButton;

	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/tv_body_text")
	public WebElement loginWindowBodyText;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_action_start")
	public WebElement loginButton;
	
	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/btn_action_end")
	public WebElement signUpButton;
}
