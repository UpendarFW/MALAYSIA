package Practice_Only;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import GenericUtilities.BaseClass_Utility;


 @Listeners(GenericUtilities.ListnersImplimentation.class)
public class TestNG extends BaseClass_Utility {

	
	 @Test(groups = "Regression",retryAnalyzer = GenericUtilities.IRetryAnalizer.class)
	 
	 public void TC_001_Login(){
		
			
	 }
	 
	 @Test(groups = "Regression",retryAnalyzer = GenericUtilities.IRetryAnalizer.class)
	 
	 public void TC_002_Login1(){
	
		
	 
	 
			
	 }
	 
	
	
	
	
}
