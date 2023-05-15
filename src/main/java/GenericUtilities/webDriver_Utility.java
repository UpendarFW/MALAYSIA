 package GenericUtilities;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriver_Utility {

	
	public void Maximize_Window(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void Minimize_Window(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void Relocate_Window(WebDriver driver,int x_dimension,int y_dimension) {
		driver.manage().window().setPosition(new Point(x_dimension,y_dimension));
	}
	
	public void Resize_Window(WebDriver driver,int Width,int Height) {
		driver.manage().window().setSize(new Dimension(Width,Height));
	}
	
	public void Implicitly_Wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void Explicit_Wait(WebDriver driver,String element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	
	public void window_Handle(WebDriver driver,String PAGETITLE) {
		Set<String> win=driver.getWindowHandles();
		Iterator<String>itr=win.iterator();
		
		while(itr.hasNext()) {
			String child=itr.next();
			driver.switchTo().window(child);
			String title=driver.getTitle();
			if(title.contains(PAGETITLE)) {
				break;
			}
			}
	}
	
	public void handleDropdown_byVISIBLETEXT(WebElement element,String VisibleText) {
		Select s=new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	
	public void handleDropDown_byINDEX(WebElement element,int INDEX) {
	Select s=new Select(element);
	s.selectByIndex(INDEX);
	}
	
	public void handleDropDown_byVALUE(WebElement element,String VALUE) {
		Select s=new Select(element);
		s.selectByValue(VALUE);
	}
	
	public void ScrollDownPage_Robot() throws Throwable {
		Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
	    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void mouse_MoveToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouse_MovetoElementClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void mouse_DragandDrop(WebDriver driver,WebElement SOURCE,WebElement TARGET) {
		Actions act=new Actions(driver);
		act.dragAndDrop(SOURCE,TARGET).perform();;
	}
	
	public void mouse_DragandDropBy(WebDriver driver,WebElement SOURCE,int X_Axis,int Y_Axis) {
		Actions act=new Actions(driver);
		act.dragAndDropBy(SOURCE,X_Axis,Y_Axis).perform();;
	}
	
	public void mouse_MovetoElemnt_RightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().build().perform();
	}
	
	public void mouse_PageRightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void mouse_ElementRightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void mouse_MovetoElement_RightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().build().perform();
	}
	
	public void mouse_DoubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void mouse_DoubleClickElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void mouse_movetoElement_DoubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().build().perform();
	}
	
	
	public void Alert_Accept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void Alert_Dismiss(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	public String Alert_GetText(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		String text=alt.getText();
		return text;
	}
	
	public void switchFrame_byINDEXNumber(WebDriver driver,int INDEXNumber) {
		driver.switchTo().frame(INDEXNumber);
	}
	
	public void switchFrame_byNameORId(WebDriver driver,String NAMEorID) {
		driver.switchTo().frame(NAMEorID);
	}
	
	public void switchFrame_WebElement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchframe_PARENTFRAME(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchFrame_MainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	public String takeScreenShot(WebDriver driver,String ScreenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+ScreenshotName+".png");
		
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();
	}
	
}
