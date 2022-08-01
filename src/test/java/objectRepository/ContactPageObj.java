package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPageObj {
	
	WebDriver driver;
	
	public ContactPageObj(WebDriver driver)
	{
		this.driver = driver;
	}

	By forename = By.id("forename");
	
	By surname = By.xpath("//input[@id='surname']");
	
	By email = By.id("email");
	
	By telephone = By.cssSelector("#telephone");
	
	By message = By.id("message");
	
	By submitBtn = By.cssSelector(".btn-contact.btn.btn-primary");
	
	By forenameErr = By.id("forename-err");
	
	By emailErr = By.id("email-err");
	
	By messageErr = By.id("message-err");
	
	By messageSuccess = By.cssSelector(".alert.alert-success");
	
	By goBack = By.xpath("//a[@ng-click='goBack()']");
	
	public WebElement getForename()
	{
		return driver.findElement(forename);
	}
	
	public WebElement getSurname()
	{
		return driver.findElement(surname);
	}
	
	public WebElement getEmailId()
	{
		return driver.findElement(email);
	}
	
	public WebElement getTelephone()
	{
		return driver.findElement(telephone);
	}
	
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
	
	public WebElement getSubmitBtn()
	{
		return driver.findElement(submitBtn);
	}
	
	public WebElement getForenameErr()
	{
		return driver.findElement(forenameErr);
	}
	
	public WebElement getEmailErr()
	{
		return driver.findElement(emailErr);
	}
	
	public WebElement getMessageErr()
	{
		return driver.findElement(messageErr);
	}
	
	public WebElement getMessageSuccess()
	{
		return driver.findElement(messageSuccess);
	}
	
	public WebElement getGoBack()
	{
		return driver.findElement(goBack);
	}
}
