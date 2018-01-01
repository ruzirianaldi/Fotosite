/**
 * 
 */
package com.foto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bhavesh Rathod
 *
 */
public class SearchPage {
	
public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 	
    @FindBy(how=How.XPATH, using = "//*[@class='customer-top-navigation']/ul/li[2]")
    WebElement search_menu;
    
    @FindBy(how=How.XPATH, using = "//*[@id='search']")
    WebElement search_txt;
    
    @FindBy(how=How.XPATH, using ="//*[@id='search_mini_form']/div[1]/button")
    WebElement Search_icon;
	
	
    public void search_with_InvalidText() throws InterruptedException
    {
    	//Click on search menu
    	
    	search_menu.click();
    	
    	//Enter search text
    	
    	search_menu.sendKeys("EXPANSION");
    	
    	Thread.sleep(1000);
    	
    	//Click on search icon
    	
    	Search_icon.click();
    	
    }
    
    public void search_with_validText() throws InterruptedException
    {
       
    	
    	
    	//Click on search menu
    	
    	search_menu.click();
    	
    	//Clear previous search text
    	
    	if(search_menu.isEnabled()) 
    	{
    	    System.out.println("Enabled");
    	    search_menu.sendKeys("Test Automation");
    	   // search_menu.submit();
    	}
    	
        //search_menu.clear();
    	
        //Enter search text
    	//search_menu.sendKeys("A");
    	  Thread.sleep(1000);
    	
    	//Click on search icon
    	Search_icon.click();

    }
}
