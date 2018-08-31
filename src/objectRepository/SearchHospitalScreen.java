package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHospitalScreen {

	@FindBy(id="btn_back")
	public WebElement backButton;
	
	@FindBy(id="et_search")
	public WebElement searchHospitalInputField;
	
	//to be fixed
	@FindBy(xpath="//android.widget.TextView[@text='Whitefield']")
	public WebElement location;
	

	
}
