package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_LookUp {

	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organizationlookup;
	
	public Organization_LookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationlookup() {
		return organizationlookup;
	}
	
	public void Organization_LOOKUP() {
		organizationlookup.click();
	}
}
