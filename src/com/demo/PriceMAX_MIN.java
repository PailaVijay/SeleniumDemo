package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceMAX_MIN {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement>priceList=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
	    double largest=0;
	    double smalest=0;
	    for(WebElement e:priceList)
	    {
	    	double price=Double.parseDouble(e.getText().replace("$", ""));
	    	if(largest<price)
	    	{
	    		largest=price;
	    	}
	        
	    	
	    }
	    System.out.println(largest);
	    String addToCartMinXpath= "//div[normalize-space()='$"+largest+"']//following-sibling::button[text()='Add to cart']";
	    driver.findElement(By.xpath(addToCartMinXpath)).click();

	}

}
