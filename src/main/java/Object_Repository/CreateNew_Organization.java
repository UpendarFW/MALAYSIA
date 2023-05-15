package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew_Organization {

	
	@FindBy(xpath = "//input[@class='detailedViewTextBox']")
	private WebElement organizationame;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNew_Organization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationame() {
		return organizationame;
	}
	
	public void OrganizationName(String ORGNAME) {
		organizationame.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	
	
}
