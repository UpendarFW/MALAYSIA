package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.webDriver_Utility;

public class ContactInfopage {

	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeader;
	
	@FindBy(xpath ="//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	public ContactInfopage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getContactHeader() {
		return ContactHeader;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public String ContactInfo_Header() {
		String ContactInfoText=ContactHeader.getText();
		return ContactInfoText;
	}
	
	public void Contact_DeleteBtn(WebDriver driver) {
		deleteBtn.click();
		webDriver_Utility wu=new webDriver_Utility();
		wu.Alert_Accept(driver);
	}
}
