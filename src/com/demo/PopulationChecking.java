package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopulationChecking {
	
    static WebDriver driver;
    
    static String xpath_Current_population = "//div[@class='maincounter-number']/span[@class='rts-counter']";
	static String xpath_today_population= "//div[text()='Today']//parent::div//span[@class='rts-counter']";
	static String xpath_this_year= "//div[text()='This year']//parent::div//span[@class='rts-counter']";
	static String xpath_today_thisYear= "//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
	
	public static  void printPopulationData(String locator)
	{
		
		int count=1;
		
		
		while(count<=20) {
			System.out.println(count +"sec");
			if(count==20) break;
			
			
			List<WebElement> population=driver.findElements(By.xpath(locator));
			
			for(WebElement po:population)
			{
				System.out.println(po.getText());
			
	        }
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			}
		
	}
	
	
	public static void main(String[] args) {

		
				 

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		printPopulationData(xpath_Current_population);
		
		printPopulationData(xpath_today_population);

		
		

	}
}
