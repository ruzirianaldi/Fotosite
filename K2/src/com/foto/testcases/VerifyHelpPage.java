/**
 * 
 */
package com.foto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.foto.pages.HelpPage;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;

/**
 * @author Bhavesh Rathod
 *
 */
public class VerifyHelpPage extends ExtentReportUtility {
  
	WebDriver driver;
	@Test
	public void verify_help_page () throws Exception
	{
		String scrPath = System.getProperty("user.dir");
		
		 test = extent.createTest("VerifyHelpPage","This is VerifyHelpPage");
		 String str="";
		 driver = BrowserFactory.startBrowser("chrome", "http://be.mage.foto.com/");
		 HelpPage helppage =new HelpPage(driver);
		 helppage.verifyHelp_page();
		 
		 CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","Help.png");
		 
		 int x = driver.findElements(By.xpath("//*[@id='top']/body/div[3]/div/div[3]/div/div/div/div[1]/h1")).size();
		 System.out.println(">>>>>>>>>>>>>>>>>>>."+x);
			
		if(driver.findElements(By.xpath("//*[@id='top']/body/div[3]/div/div[3]/div/div/div/div[1]/h1")).size()>0)
		{
		 str = driver.findElement(By.xpath("//*[@id='top']/body/div[3]/div/div[3]/div/div/div/div[1]/h1")).getText();
		 System.out.println("The str value is: "+str);
	    }
		else
	    {
				 test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
		}
			  
		if(str.equals("Aide"))
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
