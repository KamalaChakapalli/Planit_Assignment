package automationScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Setup {
	
	WebDriver driver;
	
	public Properties prop;
	
	static ExtentReports extent;
	
	ExtentSparkReporter reporter;
	
	ExtentTest test;
	
	public void getPropDetails() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\details.properties");
		
		prop.load(fis);
	}
	
	@BeforeSuite
	public void setReports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\report.html";
		
		reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Kamala");
		
	}
	
	@BeforeTest
	public WebDriver setUp() throws IOException
	{
		getPropDetails();
			
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		String url = prop.getProperty("url");
		
		driver.get(url);
		
		browserManage();
		
		return driver;
	}
	
	
	public void browserManage()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void getReports(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());
			
			test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			
			String screenshotPath = getScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
		}
		
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\reports\\"+screenshotName+".png";
		
		FileUtils.copyFile(src, new File(destination));
		
		return destination;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@AfterSuite
	public void extentFlush()
	{
		extent.flush();
	}
}
