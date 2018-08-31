package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotUserIdScreen {

	@FindBy(id="toolbar_title")
	public WebElement userIDScreenHeader;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement forgotUserIdBackButton;
	
}
