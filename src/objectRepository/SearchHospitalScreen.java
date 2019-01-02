package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchHospitalScreen {

	@AndroidFindBy(id="btn_back")
	public WebElement backButton;
	
	@AndroidFindBy(id="et_search")
	public WebElement searchHospitalInputField;
	
	//to be fixed
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Whitefield']")
	public WebElement location;
	

	
}
