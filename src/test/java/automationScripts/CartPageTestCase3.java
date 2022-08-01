package automationScripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.CartPageObj;
import objectRepository.HomePageObj;
import objectRepository.ShopPageObj;

public class CartPageTestCase3 extends Setup{
	
	HomePageObj homePageObj;
	
	ShopPageObj shopPageObj;
	
	CartPageObj cartPageObj;
	
	List<WebElement> products;
	
	List<WebElement> items;
	
	HashMap<String,String> items_price = new HashMap<String,String>();
	
	int count = 0;
	
	double total = 0;
	
	double expected_subTotal = 0;
	
	@BeforeClass
	public void objectCreate()
	{
		homePageObj = new HomePageObj(driver);
		
		shopPageObj = new ShopPageObj(driver);
		
		cartPageObj = new CartPageObj(driver);
	}
	
	@Test
	public void shoppingCart() throws InterruptedException
	{
		test = extent.createTest("shoppingCart");
		
		homePageObj.shoppingBtn().click();
		
	    products = shopPageObj.getProducts();
	    
	    for(int i=0;i<products.size();i++)
	    {
	    	if(shopPageObj.getProductTitle().get(i).getText().equalsIgnoreCase("Stuffed Frog"))
	    	{
	    		items_price.put(shopPageObj.getProductTitle().get(i).getText(),shopPageObj.getProductsPrice().get(i).getText());
	    		while(count < 2)
	    		{
	    			shopPageObj.getBuyBtn().get(i).click();
	    			count++;
	    		}
	    		
	    	}
	    	
	    	if(shopPageObj.getProductTitle().get(i).getText().equalsIgnoreCase("Fluffy Bunny"))
	    	{
	    		items_price.put(shopPageObj.getProductTitle().get(i).getText(),shopPageObj.getProductsPrice().get(i).getText());
	    		count = 0;
	    		while(count < 5)
	    		{
	    			shopPageObj.getBuyBtn().get(i).click();
	    			count++;
	    		}
	    		
	    	}
	    	
	    	if(shopPageObj.getProductTitle().get(i).getText().equalsIgnoreCase("Valentine Bear"))
	    	{
	    		items_price.put(shopPageObj.getProductTitle().get(i).getText(),shopPageObj.getProductsPrice().get(i).getText());
	    		count = 0;
	    		while(count < 3)
	    		{
	    			shopPageObj.getBuyBtn().get(i).click();
	    			count++;
	    		}
	    		
	    	}
	    	
	    }
	    
	    shopPageObj.getCartLink().click();
	    
	    items = cartPageObj.getItems();
	    
	    for(int i=0;i<items.size();i++)
	    {
	    	
	    	expected_subTotal = Double.parseDouble(cartPageObj.getItemsPrice().get(i).getText().split("\\$")[1]) * Integer.parseInt(cartPageObj.getItemsQuantity().get(i).getAttribute("value"));
	    	
	    	Assert.assertTrue(cartPageObj.getItemsSubTotal().get(i).getText().split("\\$")[1].equals(Double.toString(expected_subTotal)));
	    	
	    	for(Map.Entry<String,String> map : items_price.entrySet() )
	    	{
	    		if(map.getKey().equals(cartPageObj.getItemsName().get(i).getText()))
	    		{
	    			Assert.assertTrue(cartPageObj.getItemsPrice().get(i).getText().equals(map.getValue()));
	    		}
	    		
	    	}
	    	
	    	total = total + Double.parseDouble(cartPageObj.getItemsSubTotal().get(i).getText().split("\\$")[1]);
	    	
	    }
	    
	    Assert.assertEquals(Double.parseDouble(cartPageObj.getItemsTotal().getText().split(":")[1].trim()), total);
    	
    	System.out.println("All Passed");
    	 
	  }

}
