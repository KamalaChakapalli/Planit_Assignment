package automationScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.ContactPageObj;
import objectRepository.HomePageObj;

public class ContactPageTestCase1 extends Setup{
	
		
	@Test
	public void contactFill() throws IOException
	{
				
		test = extent.createTest("contactFill");
		
		HomePageObj homePageObj = new HomePageObj(driver);
		
		homePageObj.contactLink().click();
		
		ContactPageObj contactPageObj = new ContactPageObj(driver);
		
		contactPageObj.getSubmitBtn().click();
		
		String expected_forename_err = "Forename is required";
		
		String actual_forename_err = contactPageObj.getForenameErr().getText();
		
		Assert.assertEquals(actual_forename_err, expected_forename_err);
		
		String expected_email_err = "Email is required";
		
		String actual_email_err = contactPageObj.getEmailErr().getText();
		
		Assert.assertEquals(actual_email_err, expected_email_err);
		
		String expected_message_err = "Message is required";
		
		String actual_message_err = contactPageObj.getMessageErr().getText();
		
		Assert.assertEquals(actual_message_err, expected_message_err);
		
		contactPageObj.getForename().sendKeys("Kamala");
		
		contactPageObj.getEmailId().sendKeys("kamala@planit.net.au");
		
		contactPageObj.getMessage().sendKeys("Planit is a good testing company");
		
		Assert.assertEquals(contactPageObj.getForename().getAttribute("class"),"ng-dirty ng-valid ng-valid-required");
		
		Assert.assertTrue(contactPageObj.getEmailId().getAttribute("class").contains("ng-valid-email"));
		
		Assert.assertTrue(contactPageObj.getMessage().getAttribute("class").contains("ng-valid-required"));
	
	}

}
