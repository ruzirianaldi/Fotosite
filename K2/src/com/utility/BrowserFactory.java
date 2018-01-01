/**
 * 
 */
package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author DELL
 *
 */
public class BrowserFactory {

	static	WebDriver driver;
	static String path = System.getProperty("user.dir");
	public static WebDriver startBrowser(String browserName,String URL)
	{
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", path +"//Browser//geckodriver.exe");
			driver =new FirefoxDriver();
		}
	    else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path +"//Browser//chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
		}
		
	    else if(browserName.equalsIgnoreCase("ie"))
	    {
	    	System.setProperty("webdriver.ie.driver", path +"//Browser//geckodriver.exe");
	    }
		
	    else
	    {
	    	System.out.println("User enter wrong browser type");
	    }
		
		driver.get(URL);
		return driver;
    }
}
