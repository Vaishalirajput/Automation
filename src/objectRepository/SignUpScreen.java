package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpScreen {

	@FindBy(id="toolbar_title")
	public WebElement signUPScreenHeader;
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement signUpBackButton;
	
	@FindBy(id="tv_not_visited")
	public WebElement caNotVisited;
	
}
