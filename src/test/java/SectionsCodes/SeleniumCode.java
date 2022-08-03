package SectionsCodes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v85.tethering.model.Accepted;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.cucumberexpressions.Argument;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCode {
	
	static WebDriver driver;
	
	public void lauch(WebElement URL) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("URL");
		driver.manage().window().maximize();
		}
	
	
	public void Explicity() {
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	   }
	
	
	public void ScreenShot() throws Exception {
		TakesScreenshot shot = (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File target = new File("png");
		FileUtils.copyFile(source, target);
		}
	
	public  void Javas(WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//ScrollDown
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].scrollIntoView();");
		}
	
	public void Action(WebElement source,WebElement target) {
		Actions A = new Actions(driver);
		A.dragAndDrop(source,target);
		A.moveToElement(target);
		A.doubleClick();
		A.contextClick();
		}
    
	public void Window() {
		String PW = driver.getWindowHandle();
		Set<String> CW = driver.getWindowHandles();
		
		for (String c : CW) {
			if(c.equals(PW)) {
				driver.switchTo().window(c);
			}}}
		
    public void Alerts() {
		Alert a = (Alert)driver;
		a.accept();
		a.sendKeys("");
		a.dismiss();
		a.getText();
		
	    driver.switchTo().alert();
	    }
    
    public void Selects() {
		Select s =new Select(null);
		s.selectByIndex(0);
		s.selectByValue(null);
		s.selectByVisibleText(null);
		s.deselectAll();
		s.deselectByIndex(0);
		s.deselectByValue(null);
		s.deselectByVisibleText(null);
		}
    
    private void robots() throws Exception {
		Robot r = new Robot();
		r.keyPress(0);
		r.keyRelease(0);
		
		driver.quit();
		System.out.println("task Complited");

	}
	
}
