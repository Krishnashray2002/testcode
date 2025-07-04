package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ControlActions {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static JavascriptExecutor js;
	private static Alert alert;
	private static Select select;

	public static void start() {
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.entrata.com/");
	}

	protected static WebDriver loadUrl(String str) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(str);
		
		return driver;
	}

	protected static WebDriver loadAutomationByKrishna() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com/index.html");
		return driver;
	}
	
	protected static WebDriver loadHireCorecto() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://staging.app.hirecorrecto.com/login");
		return driver;
	}
	
	protected static WebDriverWait addWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
	protected static Alert switchToAlert() {
		alert = driver.switchTo().alert();
		return alert;
	}
	
	protected static Select handleSelectDropDown(WebElement dropDownElement) {
		select = new Select(dropDownElement);
		return select;
	}
	
	public JavascriptExecutor useJs() {
	    return (JavascriptExecutor) driver;
	}
	
	protected static void closeDriverSession() {
		driver.quit();
	}
}
