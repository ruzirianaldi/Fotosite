/**
 * 
 */
package com.foto.linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author DELL
 *
 */
public class Search_demo {

	public static void main(String args[])
	{
		String path = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", path +"//Browser//geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://mage.foto.com/fr/");
		
		//Click on search menu
		
		WebElement search = driver.findElement(By.xpath(""));
		
	}
}
