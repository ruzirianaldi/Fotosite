package com.foto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.foto.pages.SearchPage;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;

/**
 * @author Bhavesh Rathod
 *
 */
public class VerifySearch extends ExtentReportUtility {

	WebDriver driver;
	String scrPath = System.getProperty("user.dir");
		
	@BeforeTest 
	public void initBrowser() 
	{
	    driver =BrowserFactory.startBrowser("firefox", "http://mage.foto.com/fr/"); 
	} 
	
	@Test(priority =1)
	public void verifySearch_invalidText () throws Exception {
	
	test = extent.createTest("verifySearch_invalidText","This is invalid search input");
	//driver =BrowserFactory.startBrowser("firefox", "http://mage.foto.com/fr/");            
	SearchPage search =new SearchPage(driver);
	search.search_with_InvalidText();
	
	CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","search1.png");
	String str = "";
	int count = driver.findElements(By.xpath("//*[@class='col-main']/p")).size();
	if(count > 0)
	{
		System.out.println(">>>>>>>>> "+count);
	}
	else
	{
		System.out.println("New search results are available");
	}
	
	str = driver.findElement(By.xpath("//*[@class='col-main']/p")).getText();
	
	if(str.contentEquals("Aucun résultat pour votre recherche."))
	{
		test.log(Status.PASS, MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
	}
	else
	{
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed due to message change in no result", ExtentColor.RED));
	}
}
	
	@Test(priority =2)
	public void verifySearch_validText() throws Exception 
	{
	
	test = extent.createTest("verifySearch_validText","This is valid search input");
	SearchPage search =new SearchPage(driver);
	search.search_with_validText();
	
	//Take screenshot 
	CommonFunctions.takeSnapShot(driver, scrPath + "\\Screenshots\\","Search2.png");
	
	int str;
	int count = driver.findElements(By.xpath("//*[@id='top']/body/div[3]/div/div[3]/div/div/div[2]/ul")).size();
	if(count > 0)
	{
		System.out.println(">>>>>>>>> "+count);
	}
	else
	{
		System.out.println("No search results are available");
	}
	
	str = driver.findElements(By.xpath("//*[@id='top']/body/div[3]/div/div[3]/div/div/div[2]/ul/li")).size();
	if(str > 0)
	{
		test.log(Status.PASS, MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
	}
	else
	{
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed due to no search result available", ExtentColor.RED));
	}
  }
}

