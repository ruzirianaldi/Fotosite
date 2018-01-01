/**
 * 
 */
package com.foto.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bhavesh Rathod
 *
 */
public class Homepage_All_Menu_Links {
	
public WebDriver driver;
	
	public Homepage_All_Menu_Links(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(how=How.TAG_NAME,using ="a")
	List<WebElement> Links;
	
    public void verifyLinks() throws IOException
    {
    	System.out.println("driver=" + driver); 
    	
        System.out.println("Total links are "+Links.size());
		
		for(int i=0;i<Links.size();i++)
		{
			
			WebElement ele= Links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkStatus(url);
			
		}
	
    }
    
    public void verifyLinkStatus(String linkUrl) throws IOException
    {
    	try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) 
    	{
           
        }
     }     
  }
    	
  
	



