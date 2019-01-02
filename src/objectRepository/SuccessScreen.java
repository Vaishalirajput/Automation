package objectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class SuccessScreen {

	@AndroidFindBy(id="tv_static_acc_ready")
	public WebElement headerText;
	
	@AndroidFindBy(id="tv_static_portal_id")
	public WebElement screenTextOne;
	
	@AndroidFindBy(id="tv_static_portal_desc")
	public WebElement screenTextTwo;
	
	@AndroidFindBy(id="tv_portal_id")
	public WebElement userId;
	
	@AndroidFindBy(id="btn_proceed")
	public WebElement nextButton;
	
	
}
