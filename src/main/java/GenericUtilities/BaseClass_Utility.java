package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Utility {

	public WebDriver driver;
	
	public File_Utility fu=new File_Utility();
	public Excel_Utility eu=new Excel_Utility();
	public Java_Utility ju=new Java_Utility();
	public webDriver_Utility wu=new webDriver_Utility();
	
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun =true,groups ={"Regression","Smoke"})
	public void bs() {
		System.out.println("====Database Connection Sucessful====");
	}
	
	@BeforeTest(alwaysRun =true,groups ={"Regression","Smoke"})
      public void bt() {
		System.out.println("===This is for Parallel Execution===");
	}
	
	@BeforeClass(alwaysRun =true,groups ={"Regression","Smoke"})
	public void Launch_Browser() throws Throwable {
		//Launch the Browser and Enter The Url
		String BROWSER=fu.getPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println(BROWSER+" Browser Launched Sucessfully");
	}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+" Browser Launched Sucessfully");
		}
		
		else if(BROWSER.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+" Browser Launched Sucessfully");
			
		}
		
		sDriver=driver;
		
		String URL=fu.getPropertyFile("url");
		wu.Implicitly_Wait(driver);
		driver.get(URL);
		
		}
	
	@BeforeMethod (alwaysRun =true,groups ={"Regression","Smoke"})
	public void LoginTo_Application() throws Throwable {
		Login_Page lp=new Login_Page(driver);
		lp.Login();
		System.out.println("===Login Sucessful===");
	}
	
	@AfterMethod(alwaysRun =true,groups ={"Regression","Smoke"})
	public void Logout_Application() {
		Home_Page hp=new Home_Page(driver);
		hp.SignOut(driver);
		
		System.out.println("Logout Sucessful===");
	}
	
	@AfterClass(alwaysRun =true,groups ={"Regression","Smoke"})
	public void ac() {
		driver.quit();
		System.out.println("===Driver closed Sucessfully===");
	}

	@AfterTest(alwaysRun =true,groups ={"Regression","Smoke"})
	public void at() {
		System.out.println("===After Test===");
	}
	@AfterSuite(alwaysRun =true,groups ={"Regression","Smoke"})
	public void as() {
		System.out.println("DB Connection Closed===");
	}
}
