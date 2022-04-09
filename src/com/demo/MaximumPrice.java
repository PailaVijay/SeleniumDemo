package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class MaximumPrice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement>priceList=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		// for maximum price
	    double maxPrice=priceList.stream()
			.mapToDouble(e-> Double.parseDouble(e.getText().trim().replace("$", "")))
		         .max().getAsDouble();
		
	    System.out.println(maxPrice);
	    
	    System.out.println("--------------------");
	    
	    String addToCartMaxXpath= "//div[normalize-space()='$"+maxPrice+"']//following-sibling::button[text()='Add to cart']";
	    driver.findElement(By.xpath(addToCartMaxXpath)).click();
	    
	    // minimum price
	    double minPrice=priceList.stream()
				.mapToDouble(e-> Double.parseDouble(e.getText().trim().replace("$", "")))
			         .min().getAsDouble();
			
		    System.out.println(minPrice);
		    String addToCartMinXpath= "//div[normalize-space()='$"+minPrice+"']//following-sibling::button[text()='Add to cart']";
		    driver.findElement(By.xpath(addToCartMinXpath)).click();
	}

}
