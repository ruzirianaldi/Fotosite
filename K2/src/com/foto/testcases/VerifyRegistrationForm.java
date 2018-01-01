/**
 * 
 */
package com.foto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.foto.pages.RegistrationPage;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;


/**
 * @author DELL
 *
 */
public class VerifyRegistrationForm extends ExtentReportUtility {
	
	WebDriver driver;
	
	
	@Test
	public void verifyRegistration() throws Exception
	{
		
		String scrPath = System.getProperty("user.dir");
		
		test = extent.createTest("verifyRegistration","This is Registration");
		String str="";
		driver = BrowserFactory.startBrowser("chrome", "http://mage.foto.com/fr/");
		RegistrationPage registration_page =new RegistrationPage(driver);
		registration_page.registration_form();
		CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","Registration.png");
		int x = driver.findElements(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div/div/div[1]/h1")).size();
		  System.out.println(">>>>>>>>>>>>>>>>>>>."+x);
		if(driver.findElements(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div/div/div[1]/h1")).size()>0){
			  str = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div/div/div[1]/h1")).getText();
			  System.out.println("The str value is: "+str);
		  }else
		  {
			     test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
		  }
		  if(str.equals("Créer un compte")){
			 
			    test.log(Status.PASS, MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
		  }else
		  {
			   test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
		  }
		
		  driver.quit();
		
	}
	
}
