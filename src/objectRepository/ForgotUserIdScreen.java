package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotUserIdScreen {

	@AndroidFindBy(id="toolbar_title")
	public WebElement userIDScreenHeader;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement forgotUserIdBackButton;
	
}
