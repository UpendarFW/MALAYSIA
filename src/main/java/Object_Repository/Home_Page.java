package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.webDriver_Utility;

public class Home_Page {

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organization;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacts;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrganization() {
		return organization;
	}
	public WebElement getContacts() {
		return contacts;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}

    public WebElement getSignoutLink() {
		return signoutLink;
	}


    public void Organization_Link() {
    	organization.click();
    }


    public void Contacts_Link() {
    	contacts.click();
    }


	public void SignOut(WebDriver driver) {
		webDriver_Utility wu=new webDriver_Utility();
		
		wu.mouse_MoveToElement(driver, adminImg);
		signoutLink.click();
	}
	
	
}
