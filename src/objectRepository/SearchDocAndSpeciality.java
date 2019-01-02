package objectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchDocAndSpeciality {
	
    @AndroidFindBy(id="btn_back")
	public WebElement backButton;
    
    @AndroidFindBy(id="et_search")
	public WebElement searchDocInputField;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='SEJAL SURESH SHAH']")
	public WebElement doctor;

}
