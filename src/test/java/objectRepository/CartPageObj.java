package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPageObj {
	
WebDriver driver;
	
	public CartPageObj(WebDriver driver)
	{
		this.driver = driver;
	}

	By items = By.cssSelector(".cart-item.ng-scope");
	
	By itemsName = By.cssSelector(".cart-item.ng-scope td:nth-child(1)");
	
	By itemsPrice = By.cssSelector(".cart-item.ng-scope td:nth-child(2)");
	
	By itemsQuantity = By.cssSelector(".cart-item.ng-scope td:nth-child(3) input");
	
	By itemsSubtotal = By.cssSelector(".cart-item.ng-scope td:nth-child(4)");
	
	By total = By.cssSelector(".total.ng-binding");
	
	public List<WebElement> getItems()
	{
		return driver.findElements(items);
	}
	
	public List<WebElement> getItemsName()
	{
		return driver.findElements(itemsName);
	}
	
	public List<WebElement> getItemsPrice()
	{
		return driver.findElements(itemsPrice);
	}
	
	public List<WebElement> getItemsQuantity()
	{
		return driver.findElements(itemsQuantity);
	}
	
	public List<WebElement> getItemsSubTotal()
	{
		return driver.findElements(itemsSubtotal);
	}
	
	public WebElement getItemsTotal()
	{
		return driver.findElement(total);
	}
}
