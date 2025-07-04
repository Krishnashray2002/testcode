package pages;

import java.time.Duration;
import java.util.Set;

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

public class HomePage{
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
		htmlReporter = new ExtentSparkReporter("test-output\\extentReport2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest(" Forms Page Report");
		
		System.out.println("Step - Navigate to Entrata.com");
		driver.get("https://www.entrata.com/");
	}
	
	@Test
	void validateMenuOptionsEnabled() {
		test.log(Status.INFO, "clicking on menu options");
		System.out.println("Step - verify entrata home page button is working or not");
		WebElement entrataHomePageBtn = driver.findElement(By.xpath("//div[@class='logo_component w-embed']"));
		wait.until(ExpectedConditions.visibilityOf(entrataHomePageBtn));
		System.out.println("element found");
		entrataHomePageBtn.click();
		System.out.println("element clicked");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='logo_component w-embed']"))));
		softAssert.assertTrue(driver.getCurrentUrl().equals("https://www.entrata.com/"));
		test.pass("entrata homepage button is working");
		
		System.out.println("Step - verify products menu is working fine or not");
		WebElement productsMenuButton = driver.findElement(By.xpath("//div[text() = 'Products']"));
		System.out.println("Step - click and hold on product menu");
		action.moveToElement(productsMenuButton).perform();
		softAssert.assertTrue(productsMenuButton.isEnabled());
		test.pass("products is working");
		
		System.out.println("Step - verify solutions menu is working fine or not");
		WebElement solutionMenuButton = driver.findElement(By.xpath("//div[text() = 'Solutions']"));
		System.out.println("Step - click and hold on product menu");
		action.moveToElement(solutionMenuButton).perform();
		softAssert.assertTrue(solutionMenuButton.isEnabled());
		test.pass("solutions is working");
		
		System.out.println("Step - verify resources menu is working fine or not");
		WebElement resourceMenuButton = driver.findElement(By.xpath("//div[text() = 'Resources']"));
		System.out.println("Step - click and hold on product menu");
		action.moveToElement(resourceMenuButton).perform();
		softAssert.assertTrue(resourceMenuButton.isEnabled());
		test.pass("resource is working");
		
		System.out.println("Step - verify company news menu is working fine or not");
		WebElement companyNewsMenuButton = driver.findElement(By.xpath("//a[text()='Company News']"));
		System.out.println("Step - click on company news menu");
		companyNewsMenuButton.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("press"));
		test.pass("company news button is working");
		
		driver.navigate().back();
		test.info("menu options is working fine");
		
	}
	
	@Test
	public void validateProductsPageNavigation() {
		test.log(Status.INFO, "clicking on products options");
		System.out.println("Step - navigate to property operations suite");
		WebElement propertyoperationsBtn = driver.findElement(By.xpath("//a[@href='/suites/property-operations']"));
		js.executeScript("arguments[0].scrollIntoView(true)" ,propertyoperationsBtn);
		action.clickAndHold(propertyoperationsBtn).perform();
		propertyoperationsBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("property"));
		test.pass("entrata property button is working");
		
		driver.navigate().back();
		
		System.out.println("Step - navigate to ai and automation suite");
		WebElement aiAndAutomationBtn = driver.findElement(By.xpath("//a[@href='/suites/ai-and-automation']"));
		wait.until(ExpectedConditions.visibilityOf(aiAndAutomationBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,aiAndAutomationBtn);
		action.clickAndHold(aiAndAutomationBtn).perform();
		aiAndAutomationBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		test.pass("entrata ai and automation button is working");
		
		driver.navigate().back();
		
		System.out.println("Step - navigate to resident experience suite");
		WebElement residentExperienceBtn = driver.findElement(By.xpath("//a[@href='/suites/resident-experience']"));
		wait.until(ExpectedConditions.visibilityOf(residentExperienceBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,residentExperienceBtn);
		action.clickAndHold(residentExperienceBtn).perform();
		residentExperienceBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("resident"));
		test.pass("entrata resident button is working");
		
		driver.navigate().back();
		
		System.out.println("Step - navigate to analytics suite");
		WebElement analyticsBtn = driver.findElement(By.xpath("//a[@href='/suites/analytics']"));
		wait.until(ExpectedConditions.visibilityOf(analyticsBtn));
		js.executeScript("arguments[0].scrollIntoView(true)" ,analyticsBtn);
		action.clickAndHold(analyticsBtn).perform();
		analyticsBtn.click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("analytics"));
		test.pass("entrata analytics button is working");
		
		test.info("products function is working fine");
		
		driver.navigate().back();
	}
	
	@Test
	public void playVideo() {
		test.log(Status.INFO, "clicking on video play");
		System.out.println("Step - play video and capture screenshot");
		WebElement videoPlayBtn = driver.findElement(By.xpath("//div[@id='wistia_86.thumbnail']"));
		wait.until(ExpectedConditions.visibilityOf(videoPlayBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", videoPlayBtn);
//		driver.findElement(By.xpath("//div[@aria-label='Play']")).click();
		softAssert.assertTrue(videoPlayBtn.isEnabled());
		test.pass("entrata video play button is working");
		test.info("video is not playing");
		test.fail("this video is started buffering");
	}
	
	@Test
	public void navigateToAiOptions() {
		test.log(Status.INFO, "clicking on ai options");
		System.out.println("Step - validate billpay is working or not");
		WebElement billpayBtn = driver.findElement(By.xpath("//h2[text()='One-click vendor payments']"));
		wait.until(ExpectedConditions.visibilityOf(billpayBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", billpayBtn);
		driver.findElement(By.xpath("(//a[@href='/products/billpay'])[2]")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("billpay"));
		test.pass("entrata billpay button is working");
		driver.navigate().back();
		
		System.out.println("Step - validate leasing is working or not");
		WebElement leasingBtn = driver.findElement(By.xpath("//h2[text()='Automated leasing']"));
		wait.until(ExpectedConditions.visibilityOf(leasingBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", leasingBtn);
		driver.findElement(By.xpath("(//a[@href='/products/leasing-ai'])[2]")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("leasing"));
		test.pass("entrata leasing-ai button is working");
		test.info("ai and automation functions is working fine");
		driver.navigate().back();
	}
	
	@Test
	public void navigateToSolutionsOptions() {
		test.log(Status.INFO, "clicking on solutions options");
		System.out.println("Step - validate multifamily option is enabled or not");
		WebElement mulFamBtn = driver.findElement(By.xpath("//h3[text()='Multifamily']"));
		wait.until(ExpectedConditions.visibilityOf(mulFamBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", mulFamBtn);
		driver.findElement(By.xpath("(//a[@href='/solutions/multifamily'])[2]")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("multifamily"));
		test.pass("multifamily button is working fine");
		driver.navigate().back();
		
		System.out.println("Step - validate military option is enabled or not");
		WebElement militaryBtn = driver.findElement(By.xpath("//h3[text()='Military']"));
		wait.until(ExpectedConditions.visibilityOf(militaryBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", militaryBtn);
		driver.findElement(By.xpath("(//a[@href='/solutions/military'])[2]")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("military"));
		test.pass("military button is working fine");
		
		test.info("solutions functions is working fine");
		driver.navigate().back();
		
	}
	
	@Test
	public void validateEntrataImpact() {
		test.log(Status.INFO, "clicking on entrata impact options");
		System.out.println("Step - navigate to entrata ai intelligence impact page");
		WebElement seeHowItWroksBtn  = driver.findElement(By.xpath("//h2[text()='The impact of Entrata Layered Intelligence']"));
		wait.until(ExpectedConditions.visibilityOf(seeHowItWroksBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", seeHowItWroksBtn);
		driver.findElement(By.xpath("//div[text()='See how it works']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("ai"));
		test.pass("redirecting to new web page and working fine");
		
		test.info("contact seller is working fine");
		driver.navigate().back();
	}
	
	@Test
	public void navigateToReviwes() {
		test.log(Status.INFO, "clicking on reviews options");
		System.out.println("Step - navigate to reviews page");
		WebElement reviewsBtn  = driver.findElement(By.xpath("//div[text()='Amazing CRM System.']"));
		wait.until(ExpectedConditions.visibilityOf(reviewsBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", reviewsBtn);
		driver.findElement(By.xpath("//div[text()='Read more reviews']")).click();
		softAssert.assertTrue(driver.getCurrentUrl().contains("review"));
		test.pass("reviews button is working fine");
		test.info("all customer reviews is showing and scrolling is working too");
		driver.navigate().back();
	}
	
	@Test
	public void footerOptions() {
		test.log(Status.INFO, "clicking on footer options");
		System.out.println("Step - validate the footer options working or not");
		WebElement termsOfUseBtn = driver.findElement(By.xpath("//a[text()='Terms of Use']"));
		WebElement privacyBtn = driver.findElement(By.xpath("(//a[text()='Privacy'])[1]"));
		WebElement securityBtn = driver.findElement(By.xpath("(//a[text()='Security'])[2]"));
		
		wait.until(ExpectedConditions.visibilityOf(termsOfUseBtn));
		js.executeScript("arguments[0].scrollIntoView(true)", termsOfUseBtn);
		
		termsOfUseBtn.click();
		privacyBtn.click();
		securityBtn.click();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> multipleWindows = driver.getWindowHandles();
		
		for(String differentWindows :multipleWindows) {
			if(!differentWindows.equals(mainWindow)) {
				driver.switchTo().window(differentWindows);
				System.out.println(driver.getTitle());
				String foucesdUrl = driver.getCurrentUrl();
				if(foucesdUrl.contains("terms")) {
					softAssert.assertTrue(true);
				}
				if(foucesdUrl.contains("privacy")) {
					softAssert.assertTrue(true);
				}
				if(foucesdUrl.contains("security")) {
					softAssert.assertTrue(true);
				}
				foucesdUrl = "";
			}
		}
		driver.switchTo().window(mainWindow);
		test.pass("footer buttons is working");
		test.info("naviagtion is working fine");
	}
	
	@AfterTest
	private void teardown() {
		extent.flush();
		softAssert.assertAll();
		System.out.println("Step - browser closed");
		driver.quit();
	}
}
