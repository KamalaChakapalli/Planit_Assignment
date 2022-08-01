package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPageObj {
	
	WebDriver driver;
	
	public ShopPageObj(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By products = By.cssSelector(".product.ng-scope");
	
	By buyBtns = By.cssSelector(".btn.btn-success");
	
	By productsTitle = By.cssSelector(".product-title.ng-binding");
	
	By cartLink = By.cssSelector("#nav-cart");
	
	By productsPrice = By.cssSelector(".product-price.ng-binding");
	
	public List<WebElement> getProducts()
	{
		return driver.findElements(products);
	}
	
	public List<WebElement> getBuyBtn()
	{
		return driver.findElements(buyBtns);
	}
	
	public List<WebElement> getProductTitle()
	{
		return driver.findElements(productsTitle);
	}

	public WebElement getCartLink()
	{
		return driver.findElement(cartLink);
	}
	
	public List<WebElement> getProductsPrice()
	{
		return driver.findElements(productsPrice);
	}
}
