package com.foto.linear;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Help_demo {
	
	public static void main(String args[]) throws InterruptedException
	{
		String path = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", path +"//Browser//geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://mage.foto.com/fr/");
		
		//Click on Help menu
		
		WebElement help_menu =driver.findElement(By.xpath("//*[@class='customer-top-navigation']/ul/li[5]"));
		help_menu.click();
		
		//Scroll down the page
		
		/*Actions action = new Actions(driver);
	    action.sendKeys(Keys.PAGE_DOWN);
	    Thread.sleep(2000);
	    action.click(driver.findElement(By.xpath("//*[@id='caret_down_category_23']"))).perform();*/
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollTo(0, 1000)");
	    Thread.sleep(2000);
	    
	    WebElement contact_lbl = driver.findElement(By.xpath("//*[@class='section'][position()=6]"));
	    contact_lbl.click();
	    
	    WebElement address_lbl = driver.findElement(By.xpath("//*[@id='faq_category_23']"));
	    address_lbl.click();
	    
		/*//Click on Contact label text
		 WebElement contact_lbl = driver.findElement(By.xpath("//*[@id='caret_down_category_23']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contact_lbl);
		 //Thread.sleep(2000);
		// contact_lbl.click();
*/	}


}