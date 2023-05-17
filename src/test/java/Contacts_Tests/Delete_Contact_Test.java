package Contacts_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass_Utility;
import GenericUtilities.Excel_Utility;
import GenericUtilities.Java_Utility;
import Object_Repository.ContactInfopage;
import Object_Repository.ContactLookUp;
import Object_Repository.CreateNewContact;
import Object_Repository.Home_Page;

@Listeners(GenericUtilities.ListnersImplimentation.class)
public class Delete_Contact_Test extends BaseClass_Utility{

	@Test(retryAnalyzer =GenericUtilities.IRetryAnalizer.class,priority = 1,groups = "Smokesuite")
	public void delete_Contact() throws Throwable {
		Home_Page hp=new Home_Page(driver);
		hp.Contacts_Link();
		
		ContactLookUp cl=new ContactLookUp(driver);
		cl.ContactLookup();
		
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		int random=ju.getRandomNumber();
		
		String LASTNAME=eu.getExcelFileData("Contacts",1,2)+random;
		
		CreateNewContact cnc=new CreateNewContact(driver);
		cnc.LastName(LASTNAME);
		
		ContactInfopage ci=new ContactInfopage(driver);
		String Actual=ci.ContactInfo_Header();
		
		Assert.assertTrue(Actual.contains(LASTNAME));
		
		ci.Contact_DeleteBtn(driver);
		
		cl.DeleteContact_search(LASTNAME);
		
	String actual=	cl.DeleteContact_Verify();
		Assert.assertTrue(actual.contains("No Contact Found !"));
		
		System.out.println("Contact Deleted Sucessfully");
		
	}
}
