package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.webDriver_Utility;

public class ContactLookUp {

	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ContactLookup;
	
	@FindBy(name="search_text")
	private WebElement searchfor_Txtfield;
	
	@FindBy(id="bas_searchfield")
	private WebElement select_dropdown;
	
	@FindBy(xpath = "//option[@value='lastname']")
	private WebElement Lastname_Value;
	
	@FindBy(name="submit")
	private WebElement SearchNow_Btn;
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement NoContact;
	
	public ContactLookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getContactLookup() {
		return ContactLookup;
	}


	public WebElement getSearchfor_Txtfield() {
		return searchfor_Txtfield;
	}


	public WebElement getSelect_dropdown() {
		return select_dropdown;
	}


	public WebElement getLastname_Value() {
		return Lastname_Value;
	}


	public WebElement getSearchNow_Btn() {
		return SearchNow_Btn;
	}


	public WebElement getNoContact() {
		return NoContact;
	}


	public void ContactLookup() {
		ContactLookup.click();
	}
	
	public void DeleteContact_search(String LASTNAME) {
		searchfor_Txtfield.sendKeys(LASTNAME);
		webDriver_Utility wu=new webDriver_Utility();
		
		wu.handleDropDown_byVALUE(select_dropdown,"lastname");
		SearchNow_Btn.click();
	}
	
	public String DeleteContact_Verify() {
		String DeleteInfo=NoContact.getText();
		return DeleteInfo;
	}
	
	
}
