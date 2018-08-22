package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotUserIdScreen {

	@FindBy(id="com.mphrx.columbiaAsia.patient.debug:id/toolbar_title")
	public WebElement userIDScreenHeader;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement forgotUserIdBackButton;
	
}
