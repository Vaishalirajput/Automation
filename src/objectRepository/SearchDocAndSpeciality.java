package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchDocAndSpeciality {
	
    @FindBy(id="btn_back")
	public WebElement backButton;
    
    @FindBy(id="et_search")
	public WebElement searchDocInputField;
    
    @FindBy(xpath="//android.widget.TextView[@text='SEJAL SURESH SHAH']")
	public WebElement doctor;

}
