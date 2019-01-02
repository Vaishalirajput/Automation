package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpScreen {

	@AndroidFindBy(id="toolbar_title")
	public WebElement signUPScreenHeader;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement signUpBackButton;
	
	@AndroidFindBy(id="tv_not_visited")
	public WebElement caNotVisited;
	
	@AndroidFindBy(id="tv_visited")
	public WebElement caAlreadyVisited;
	
	@AndroidFindBy(id="tv_hav_mrn")
	public WebElement patientHasMRN;	

	@AndroidFindBy(id="tv_hav_no_mrn")
	public WebElement patientHasNoMRN;	
	
}
