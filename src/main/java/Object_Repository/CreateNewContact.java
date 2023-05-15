package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.webDriver_Utility;

public class CreateNewContact {

	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgnizationlookUp;
	
	@FindBy(name="search_text")
	private WebElement orgsearch;
	
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement org_searchnowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastName() {
		return lastName;
	}
	
	public void LastName(String LASTNAME) {
		lastName.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void LastName_OrganizationLookup(WebDriver driver,String LASTNAME,String ORGANIZATIONNAME) {
		lastName.sendKeys(LASTNAME);
		orgnizationlookUp.click();
		
		webDriver_Utility wu=new webDriver_Utility();
		wu.window_Handle(driver,"Accounts&action");
		
		
		orgsearch.sendKeys(ORGANIZATIONNAME);
		
		org_searchnowBtn.click();
		
		driver.findElement(By.xpath("//a[text()='"+ORGANIZATIONNAME+"']")).click();
		
		wu.window_Handle(driver,"Contacts&action");
		
		saveBtn.click();		
		
		
		
		
		
		
	}
}
