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
import com.foto.pages.LoginPage;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;

public class ValidLogin extends ExtentReportUtility
{
	WebDriver driver;
	
  @Test
  public void verifyValidLogin() throws Exception 
  {
	  /*BrowserFactory browser =new BrowserFactory();
	  driver= browser.startBrowser("firefox", "http://mage.foto.com/fr/");
	  LoginPage Login_page= PageFactory.initElements(driver, LoginPage.class);
	  Login_page.login_foto_site();*/
	  
	  String scrPath = System.getProperty("user.dir");
	  test = extent.createTest("verifyValidLogin","This is Login");
	  String str="";
	  
	  driver =  BrowserFactory.startBrowser("chrome", "http://mage.foto.com/en/");
	  LoginPage Login_page= new LoginPage(driver);
	  Login_page.login_foto_site();
	  
	  
	  CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","Login.png");
	  Thread.sleep(5000);
	  
	  int x = driver.findElements(By.xpath("//*[@class='page-title']")).size();
	  System.out.println(">>>>>>>>>>>>>>>>>>>."+x);
	  
	  if(driver.findElements(By.xpath("//*[@class='page-title']")).size()>0){
		  str = driver.findElement(By.xpath("//*[@class='page-title']")).getText();
		  System.out.println("The str value is: "+str);
	  }else{
		    
			test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed due to element not found", ExtentColor.RED));
	  }
	  if(str.equals("Mon tableau de bord")){
		 
		  test.log(Status.PASS, MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
	  }else{
		   
		  test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed", ExtentColor.RED));
	  }
	  driver.quit();
  }

}
