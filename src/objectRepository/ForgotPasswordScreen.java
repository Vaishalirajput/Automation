package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotPasswordScreen {
	
	@AndroidFindBy(id="toolbar_title")
	public WebElement passwordScreenHeader;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement forgotPasswordBackButton;
	
	

}
