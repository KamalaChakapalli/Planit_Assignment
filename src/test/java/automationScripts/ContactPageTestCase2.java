package automationScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.ContactPageObj;
import objectRepository.HomePageObj;

public class ContactPageTestCase2 extends Setup{
	
	HomePageObj homePageObj;
	ContactPageObj contactPageObj;
	
	WebDriverWait wait;
	
	@BeforeClass
	public void objectCreate()
	{
		homePageObj = new HomePageObj(driver);
		
		contactPageObj = new ContactPageObj(driver);
	}

	@Test(invocationCount=5)
	public void contactMandatoryFill() throws IOException
	{
			
		test = extent.createTest("contactMandatoryFill"); 
		
		homePageObj.contactLink().click();
		
		contactPageObj.getForename().sendKeys("Kamala");
		
		contactPageObj.getEmailId().sendKeys("kamala@planit.net.au");
		
		contactPageObj.getMessage().sendKeys("Planit is a good testing company");
		
		contactPageObj.getSubmitBtn().click();
		
		String expected_message = "we appreciate your feedback";
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));		
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
		
		Assert.assertTrue(message.getText().contains(expected_message));
	
		contactPageObj.getGoBack().click();
		
	}
	
	

}
