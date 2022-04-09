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


public class FindBrokenLinks {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://flipkart.com");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for(WebElement link:links)
		{
			String urlName=link.getText();
			String url=link.getAttribute("href");
			try {
				getBrokenLink(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
	public static void getBrokenLink(String urlLink) throws IOException
	{
		
		try {
			URL u= new URL(urlLink);
			
			HttpURLConnection httpConn=  (HttpURLConnection)u.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			
			if(httpConn.getResponseCode()>=400)
			{
				System.out.println(urlLink +"-->"+ httpConn.getResponseMessage()+" : link is broken");
			}
			else
			{
				System.out.println(urlLink +"-->"+ httpConn.getResponseMessage());
			
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
