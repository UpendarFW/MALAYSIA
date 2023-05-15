package Organization_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass_Utility;
import GenericUtilities.Excel_Utility;
import GenericUtilities.Java_Utility;
import Object_Repository.CreateNew_Organization;
import Object_Repository.Home_Page;
import Object_Repository.Organization_InfoPage;
import Object_Repository.Organization_LookUp;


@Listeners(GenericUtilities.ListnersImplimentation.class)
public class CreateNew_Organization_Tests extends BaseClass_Utility{

	
	@Test(retryAnalyzer = GenericUtilities.IRetryAnalizer.class,groups="RegressionSuite")
	public void Tc_003_CreateOrganization() throws Throwable {
		//Create Organization With valid data
		
		Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Organization_LookUp ol=new Organization_LookUp(driver);
		ol.Organization_LOOKUP();
		
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		int random=ju.getRandomNumber();
		
		String ORGNAME=eu.getExcelFileData("Organizations",1,2)+random;
		
		
		CreateNew_Organization cno=new CreateNew_Organization(driver);
		cno.OrganizationName(ORGNAME);
		
		Organization_InfoPage oi=new Organization_InfoPage(driver);
		String Actual=oi.organizationHeader();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
		
		Reporter.log("Organization Created Sucessfully");
	}
	
	@Test(retryAnalyzer = GenericUtilities.IRetryAnalizer.class,groups = "RegressionSuite")
	public void Tc_004_DeleteOrganization() throws Throwable {
		Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Organization_LookUp ol=new Organization_LookUp(driver);
		ol.Organization_LOOKUP();
		
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		int random=ju.getRandomNumber();
		
		String ORGNAME=eu.getExcelFileData("Organizations",1,2)+random;
		
		
		CreateNew_Organization cno=new CreateNew_Organization(driver);
		cno.OrganizationName(ORGNAME);
		
		Organization_InfoPage oi=new Organization_InfoPage(driver);
		String Actual=oi.organizationHeader();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
		
		Reporter.log("Organization Created Sucessfully");
		
		oi.Organization_DeleteBtn(driver);
		
		Reporter.log("Organization Deleted Sucessfully");
	}
	
}
