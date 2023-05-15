package Contacts_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass_Utility;
import GenericUtilities.Excel_Utility;
import GenericUtilities.Java_Utility;
import Object_Repository.ContactInfopage;
import Object_Repository.ContactLookUp;
import Object_Repository.CreateNewContact;
import Object_Repository.CreateNew_Organization;
import Object_Repository.Home_Page;
import Object_Repository.Organization_InfoPage;
import Object_Repository.Organization_LookUp;


@Listeners(GenericUtilities.ListnersImplimentation.class)
public class CreateNew_Contact_Test extends BaseClass_Utility {

	@Test(retryAnalyzer = GenericUtilities.IRetryAnalizer.class,priority = 1,groups="RegressionSuite")
	public void Tc_001_CreateConact() throws Throwable {
		Home_Page hp=new Home_Page(driver);
		hp.Contacts_Link();
		Reporter.log("Contacts link Clicked");
		
		ContactLookUp cl=new ContactLookUp(driver);
		cl.ContactLookup();
		
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		
		int random=ju.getRandomNumber();
		
		String LASTNAME=eu.getExcelFileData("Contacts",1,2)+random;
		
		
		CreateNewContact cnc=new CreateNewContact(driver);
		cnc.LastName(LASTNAME);
		
		ContactInfopage cip=new ContactInfopage(driver);
		String Actual=cip.ContactInfo_Header();
		
		Assert.assertTrue(Actual.contains(LASTNAME));
		
		
	}
	
	@Test(retryAnalyzer = GenericUtilities.IRetryAnalizer.class,groups = "RegressionSuite" )
	public void Tc_002_CreateContact_with_Organization() throws Throwable {
     	Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Organization_LookUp ol=new Organization_LookUp(driver);
		ol.Organization_LOOKUP();
		
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		int random=ju.getRandomNumber();
		
		String ORGNAME=eu.getExcelFileData("Contacts", 4, 2)+random;
		
		
		CreateNew_Organization cno=new CreateNew_Organization(driver);
		cno.OrganizationName(ORGNAME);
		
		Organization_InfoPage oi=new Organization_InfoPage(driver);
		String Actual=oi.organizationHeader();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
		
		
		Thread.sleep(3000);
		
		//Create Contact
		
		hp.Contacts_Link();
		
		ContactLookUp cl=new ContactLookUp(driver);
		cl.ContactLookup();
		
		String LASTNAME=eu.getExcelFileData("Contacts",4,3)+random;
		
		CreateNewContact cnc=new CreateNewContact(driver);
		cnc.LastName_OrganizationLookup(driver, LASTNAME,ORGNAME);
		
		
		ContactInfopage ci=new ContactInfopage(driver);
		String actual=ci.ContactInfo_Header();
		
     	Assert.assertTrue(actual.contains(LASTNAME));
		
		
		
	}
	
	
}
