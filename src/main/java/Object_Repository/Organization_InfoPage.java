package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.webDriver_Utility;

public class Organization_InfoPage {

	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement organizationinfoHeader;
	
	@FindBy(xpath ="//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	public Organization_InfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationinfoHeader() {
		return organizationinfoHeader;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public String organizationHeader() {
		String OrgINfo=organizationinfoHeader.getText();
		return OrgINfo;
	}
	
	public void Organization_DeleteBtn(WebDriver driver) {
		deleteBtn.click();
		webDriver_Utility wu=new webDriver_Utility();
		wu.Alert_Accept(driver);
	}
}
