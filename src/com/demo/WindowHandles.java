package com.demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://ekartlogistics.com/");
		// //div[contains(@class,'cont')]//h1
		driver.findElement(By.xpath("//a[text()='Automation']")).click();
		
		Set<String> windowId=driver.getWindowHandles();
		Iterator<String> it= windowId.iterator();
		String parentId= it.next();
		String childId= it.next();
		System.out.println("parent window Id : "+parentId);
		System.out.println("Child window Id : "+childId);
		
		driver.switchTo().window(parentId);
		System.out.println("parent Window Title : "+driver.getTitle());
		driver.switchTo().window(childId);
		System.out.println("child window title : "+ driver.getTitle());
		
		
		

	}

}
