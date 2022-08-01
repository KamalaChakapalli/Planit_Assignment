package objectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObj {
	
	WebDriver driver;
	
	public HomePageObj(WebDriver driver)
	{
		this.driver=driver;
	}

	By contact = By.cssSelector("#nav-contact a");
	
	By shoppingBtn = By.cssSelector(".btn.btn-success.btn-large");
	
	public WebElement contactLink()
	{
		return driver.findElement(contact);
	}
	
	public WebElement shoppingBtn()
	{
		return driver.findElement(shoppingBtn);
	}
}
