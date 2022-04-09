package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class EMI_Calculator {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--headless");
		WebDriver driver= new ChromeDriver(opt);
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		
		String venDiagram= "//*[name()='g' and @class='highcharts-series-group']";
		String  TotalInterestXpath= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip                             highcharts-color-1']//*[name()='text']";
		String PrincipalIntrestXpath= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip                                                     highcharts-color-0']//*[name()='text']";
		
		WebElement diagram=driver.findElement(By.xpath(venDiagram));
		
		
          act.moveToElement(diagram).perform();
		
		
		
	
		String totalInterest=driver.findElement(By.xpath(TotalInterestXpath)).getText();
		System.out.println(totalInterest);
		String principalInterest=driver.findElement(By.xpath(PrincipalIntrestXpath)).getText();
		System.out.println(principalInterest);
		
		

		String xpathVerticalBar= "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String xpathToolTip= "//*[local-name()='svg']//*[name()='g'and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		
		
		List<WebElement> barLists=driver.findElements(By.xpath(xpathVerticalBar));
		System.out.println("Total Bar Number :"+barLists.size());
		// move to every element
		
		
		
		for(WebElement list:barLists)
		{
			act.moveToElement(list).perform();
			Thread.sleep(500);
			String text=driver.findElement(By.xpath(xpathToolTip)).getText();
			System.out.println(text);
		}
		
	}

}
