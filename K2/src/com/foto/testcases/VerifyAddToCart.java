/**
 * 
 */
package com.foto.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.utility.BrowserFactory;

/**
 * @author Bhavesh Rathod
 *
 */
public class VerifyAddToCart {
	//Declaration variable

	WebDriver driver;
	
	@BeforeSuite
	public void initBrowser()
	{
		driver =BrowserFactory.startBrowser("chrome", "http://mage.foto.com/fr/");
	}
	
	@Test
	public void verify_Add_To_Cart()
	
	{
		
	}
}
