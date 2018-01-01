/**
 * 
 */
package com.foto.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.foto.pages.Homepage_All_Menu_Links;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;

/**
 * @author DELL
 *
 */
public class Verify_All_Active_Links_Homepage extends ExtentReportUtility {

	WebDriver driver;
	@Test
	public void Verify_Active_Link() throws Exception
	{
		String scrPath = System.getProperty("user.dir");
		
		test = extent.createTest("Verify_All_Active_Links_Homepage","This is Verify_All_Active_Links_Homepage");
		String str="";
		driver =BrowserFactory.startBrowser("chrome", "http://be.mage.foto.com/");
		Homepage_All_Menu_Links Links =new Homepage_All_Menu_Links(driver);
		Links.verifyLinks();
		
		CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","reg.png");
		
		int x = driver.findElements(By.xpath("//*[@id='header']/div/div[1]/h1/a")).size();
		  System.out.println(">>>>>>>>>>>>>>>>>>>."+x);
		
		if(driver.findElements(By.xpath("//*[@id='header']/div/div[1]/h1/a")).size()>0)
		{
		   str = driver.findElement(By.xpath("//*[@id='header']/div/div[1]/h1/a")).getAttribute("title");
	       System.out.println("The str value is: "+str);
		}
		else
		{
			  test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
		}
		if(str.equals("Foto.com"))
		{
			 test.log(Status.PASS, MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
		}
		else
		{
			 test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
		}
		driver.quit();
   }
}
