package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordScreen {
	
	@FindBy(id="toolbar_title")
	public WebElement passwordScreenHeader;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement forgotPasswordBackButton;
	
	

}
