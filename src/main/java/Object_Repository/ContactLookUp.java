package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUp {

	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ContactLookup;
	
	public ContactLookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactLookup() {
		return ContactLookup;
	}

	public void ContactLookup() {
		ContactLookup.click();
	}
	
	
}
