package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProductsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private SoftAssert softAssert;
	private Actions action;
	private Select select;
	private JavascriptExecutor js;
	private ExtentSparkReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;
	
	@BeforeTest
	private void launchBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		softAssert = new SoftAssert();
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		htmlReporter = new ExtentSparkReporter("test-output\\extentReport3.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest(" Forms Page Report");
		
		System.out.println("Step - Navigate to Entrata.com");
		driver.get("https://www.entrata.com/");
	}
	
	@Test
	public void propertyOperationsSuite() {
		test.log(Status.INFO, "validating on property operations function");
		System.out.println("Step - navigate to property operations suite");
		WebElement propertyoperationsBtn = driver.findElement(By.xpath("//a[@href='/suites/property-operations']"));
		js.executeScript("arguments[0].scrollIntoView(true)" ,propertyoperationsBtn);
		action.clickAndHold(propertyoperationsBtn).perform();
		propertyoperationsBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("property"));
		test.pass("navigated to property operations page");
		
		WebElement demoBtn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(demoBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h1[text()='Property Operations']")));
		demoBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		driver.navigate().back();
		
		
		WebElement exploreEli = driver.findElement(By.xpath("//h2[text()='Do more with  ELI Essentials']"));
		wait.until(ExpectedConditions.visibilityOf(exploreEli));
		js.executeScript("arguments[0].scrollIntoView(true)" ,exploreEli);
		driver.findElement(By.xpath("//div[text()='Explore Eli']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		driver.navigate().back();
		
		WebElement demo2Btn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(demo2Btn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h2[text()='Efficiency that drives results']")));
		demo2Btn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		
		driver.navigate().back();
		test.info("All functionalitiy of property operations is working");
		driver.navigate().back();
	}
	
	@Test
	public void aiAndAutomationSuite() {
		test.log(Status.INFO, "validating on ai and automation function");
		System.out.println("Step - navigate to ai and automation suite");
		WebElement aiAndAutomationBtn = driver.findElement(By.xpath("//a[@href='/suites/ai-and-automation']"));
		wait.until(ExpectedConditions.visibilityOf(aiAndAutomationBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,aiAndAutomationBtn);
		action.clickAndHold(aiAndAutomationBtn).perform();
		aiAndAutomationBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		test.pass("navigated to ai and automation page");
		
		WebElement demoBtn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(demoBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h1[text()='AI & Automation']")));
		demoBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		
		test.info("All ai and automation funtionalitiy is working");
		driver.navigate().back();
		
		
		WebElement exploreEli = driver.findElement(By.xpath("//h2[text()='Structured  for success']"));
		wait.until(ExpectedConditions.visibilityOf(exploreEli));
		js.executeScript("arguments[0].scrollIntoView(true)" ,exploreEli);
		driver.findElement(By.xpath("//div[text()='Explore ELI']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		driver.navigate().back();
		
		WebElement demo2Btn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(demo2Btn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h2[text()='Efficiency that drives results']")));
		demo2Btn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		driver.navigate().back();
		
		driver.navigate().back();
	}
	
	@Test
	public void residentExperienceSuite() {
		test.log(Status.INFO, "validating on resident experience function");
		System.out.println("Step - navigate to resident experience suite");
		WebElement residentExperienceBtn = driver.findElement(By.xpath("//a[@href='/suites/resident-experience']"));
		wait.until(ExpectedConditions.visibilityOf(residentExperienceBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,residentExperienceBtn);
		action.clickAndHold(residentExperienceBtn).perform();
		residentExperienceBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("resident"));
		test.pass("navigated to resident experience page");
		
		WebElement demoBtn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(demoBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h1[text()='Resident Experience']")));
		demoBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		
		test.info("All the functionalitiy of resident experience is working");
		driver.navigate().back();
		
		
		WebElement exploreEli = driver.findElement(By.xpath("//h2[text()='Do more with  ELI Essentials']"));
		wait.until(ExpectedConditions.visibilityOf(exploreEli));
		js.executeScript("arguments[0].scrollIntoView(true)" ,exploreEli);
		driver.findElement(By.xpath("//div[text()='Explore ELI']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		driver.navigate().back();
		
		WebElement demo2Btn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(demo2Btn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h2[text()='Efficiency that drives results']")));
		demo2Btn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		test.fail("video is not playing");
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		driver.navigate().back();
		
		driver.navigate().back();
	}
	
	@Test
	public void analyticsSuite() {
		test.log(Status.INFO, "validating on analytics function");
		System.out.println("Step - navigate to analytics suite");
		WebElement analyticsBtn = driver.findElement(By.xpath("//a[@href='/suites/analytics']"));
		wait.until(ExpectedConditions.visibilityOf(analyticsBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,analyticsBtn);
		action.clickAndHold(analyticsBtn).perform();
		analyticsBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("analytics"));
		test.pass("navigated to analytics page");
		
		WebElement demoBtn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(demoBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h1[text()='Analytics']")));
		demoBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		
		driver.navigate().back();
		
		
		WebElement exploreEli = driver.findElement(By.xpath("//h2[text()='A step ahead with predictive analytics']"));
		wait.until(ExpectedConditions.visibilityOf(exploreEli));
		js.executeScript("arguments[0].scrollIntoView(true)" ,exploreEli);
		driver.findElement(By.xpath("//div[text()='Explore Eli']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		driver.navigate().back();
		
		WebElement demo2Btn = driver.findElement(By.xpath("(//div[text()='Book a demo'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(demo2Btn));
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h2[text()='Efficiency that drives results']")));
		demo2Btn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("demo"));
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("demoRequest")));
		select.selectByIndex(1);
		driver.navigate().back();
		
		test.info("All the functionalitiy of analytics is working");
		driver.navigate().back();
	}

	@AfterTest
	private void teardown() {
		driver.quit();
		extent.flush();
		softAssert.assertAll();
		System.out.println("Step - browser closed");
	}	
}
