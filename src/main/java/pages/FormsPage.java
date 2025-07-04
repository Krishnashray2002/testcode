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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FormsPage {
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
		htmlReporter = new ExtentSparkReporter("test-output\\extentReport1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest(" Forms Page Report");
		
		System.out.println("Step - Navigate to Entrata.com");
		driver.get("https://www.entrata.com/");
	}
	
	@Test
	public void submitForm1() {
		test.log(Status.INFO, "Form1 on filling");
		System.out.println("Step - submit watch demo form");
		WebElement watchDemoPageBtn = driver.findElement(By.xpath("//a[text()='Watch demo']"));
		wait.until(ExpectedConditions.visibilityOf(watchDemoPageBtn));
		System.out.println("element found");
		watchDemoPageBtn.click();
		
		System.out.println("Step - validate url");
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertTrue(actualUrl.contains("demo"));
		test.pass("naviagted to form1");
		
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
		
		test.fail("button not clicked");
		test.info("form1 filled");
		
		driver.navigate().back();
		
	}
	
	@Test
	public void submitForm2() {
		test.log(Status.INFO, "Form2 filling");
		System.out.println("STEP - submit Start working differently today form");
		WebElement homePageFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='h2-form-content']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,homePageFormTitle);
		
		System.out.println("Step - validate url");
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertTrue(actualUrl.contains("demo"));
		test.pass("naviagted to form2");
		
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
		
		test.fail("button not clicked");
		test.info("form2 filled");
	}
	
	@Test
	public void submitForm3() {
		test.log(Status.INFO, "Form3 on filling");
		System.out.println("STEP - submit 3 Keys to Resident Satisfaction form");
		WebElement satisfactionFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='resource-card_heading' and text()= '3 Keys to Resident Satisfaction']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,satisfactionFormTitle);
		
		action.clickAndHold(satisfactionFormTitle).perform();
		test.pass("naviagted to form3");
		
		driver.findElement(By.xpath("(//div[text()='DOWNLOAD NOW'])[1]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("satisfaction"));
		
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
		
		test.fail("button not clicked");
		test.info("form3 filled");
		driver.navigate().back();
	}
	
	@Test
	public void submitForm4() {
		test.log(Status.INFO, "Form4 filling");
		System.out.println("STEP - submit Gen Z: The Rent Generation form");
		WebElement rentGenFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()= 'Gen Z: The Rent Generation']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,rentGenFormTitle);
		
		action.clickAndHold(driver.findElement(By.xpath("(//div[text()='WATCH NOW'])[1]"))).perform();
		
		driver.findElement(By.xpath("(//div[text()='WATCH NOW'])[1]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("generation"));
		test.pass("naviagted to form4");
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		test.fail("button not clicked");
		test.info("form4 filled");
		
		driver.navigate().back();
	}
	
	@Test
	public void submitForm5() {
		test.log(Status.INFO, "Form5 filling");
		System.out.println("STEP - submit Mitigating Risk in Multifamily form");
		WebElement mulFamilyFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()= 'Mitigating Risk in Multifamily']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,mulFamilyFormTitle);
		
		action.clickAndHold(driver.findElement(By.xpath("(//div[text()='WATCH NOW'])[2]"))).perform();
		
		driver.findElement(By.xpath("(//div[text()='WATCH NOW'])[2]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("multifamily"));
		test.pass("naviagted to form5");
		
		System.out.println("Step - enter firstname");
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		System.out.println("Step - enter lastname");
		driver.findElement(By.id("LastName")).sendKeys("Peterson");
		
		System.out.println("Step - enter E-mail");
		driver.findElement(By.id("Email")).sendKeys("johnPeterson@yahoo.com");
		
		System.out.println("Step - enter phone number");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");
		
		System.out.println("Step - enter company name");
		driver.findElement(By.id("Company")).sendKeys("xyz ltd.");
		
		System.out.println("Step - enter job title");
		driver.findElement(By.id("Title")).sendKeys("QA Tester");
		
		System.out.println("Step - click on dropdown");
		select = new Select(driver.findElement(By.id("Unit_Count__c")));
		select.selectByIndex(1);
		
		test.fail("button not clicked");
		test.info("form5 filled");
		
		driver.navigate().back();
	}
	
	@Test
	public void submitForm6() {
		test.log(Status.INFO, "Form6 filling");
		System.out.println("STEP - submit The Age of Autonomous Property Management form");
		WebElement propertyManagementFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()= 'The Age of Autonomous Property Management ']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,propertyManagementFormTitle);
		
		action.clickAndHold(propertyManagementFormTitle).perform();
		
		driver.findElement(By.xpath("(//div[text()='DOWNLOAD NOW'])[2]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("management"));
		test.pass("naviagted to form6");
		
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
		
		test.fail("button not clicked");
		test.info("form6 filled");
		
		driver.navigate().back();
	}
	

	@Test
	public void submitForm7() {
		test.log(Status.INFO, "Form7 filling");
		System.out.println("STEP - submit Driving NOI with AI: A Multifamily Survey form");
		WebElement drivingFormTitle= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'resource-card_heading' and text()= 'Driving NOI with AI: A Multifamily Survey']"))));
		js.executeScript("arguments[0].scrollIntoView(true)" ,drivingFormTitle);
		
		action.clickAndHold(driver.findElement(By.xpath("(//div[text()='DOWNLOAD NOW'])[3]"))).perform();
		
		driver.findElement(By.xpath("(//div[text()='DOWNLOAD NOW'])[3]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("driving"));
		test.pass("naviagted to form7");
		
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
		
		test.fail("button not clicked");
		test.info("form7 filled");
		
		driver.navigate().back();
	}

	@AfterTest
	private void teardown() {
		System.out.println("Step - browser closed");
		driver.quit();
		extent.flush();
		softAssert.assertAll();
	}
}
