package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.File_Utility;

public class Login_Page {

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void Login() throws Throwable {
		File_Utility fu=new File_Utility();
		String USERNAME=fu.getPropertyFile("username");
		String PASSWORD=fu.getPropertyFile("password");
		
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
}
