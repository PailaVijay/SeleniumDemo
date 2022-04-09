package com.demo;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_BrokenLink{

	
	
	public static void main(String[] args) throws IOException  {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
	    List<WebElement> links=	driver.findElements(By.tagName("a"));
	    int brokenLinks=0;
	    for(WebElement l:links)
	    {
	    	String url=l.getAttribute("href");
	    	if(url==null||url.isEmpty())
	    	{
	    		System.out.println(url+"url is empty");
	    		continue;
	    	}
	    	
				URL link= new URL(url);
				try {
					HttpURLConnection httpConnection= (HttpURLConnection) link.openConnection();
					httpConnection.connect();
					if(httpConnection.getResponseCode()>=400)
					{
						System.out.println(url+ "--->"+httpConnection.getResponseMessage()+"link is broken");
						brokenLinks++;
					}
					else
					{
						System.out.println(url+ "--->"+httpConnection.getResponseMessage());

					}
				} catch (MalformedURLException e) {
					
					
				}
			
	    	
	    }
		System.out.println("number of brokenlink"+brokenLinks);

	    driver.close();
	   
        
	}
	
	
}
