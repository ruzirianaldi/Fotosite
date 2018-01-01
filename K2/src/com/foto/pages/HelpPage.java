/**
 * 
 */
package com.foto.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bhavesh Rathod
 *
 */
public class HelpPage {
	
	public WebDriver driver;
	
	public HelpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//*[@class='customer-top-navigation']/ul/li[5]")
	WebElement help_menu;
	
	@FindBy(how=How.XPATH, using = "//*[@class='section'][position()=6]")
	WebElement contact_lbl;
	
	@FindBy(how=How.XPATH, using = "//*[@id='faq_category_23']")
	WebElement address_lbl;

	
	public void verifyHelp_page() throws InterruptedException
	{
		help_menu.click();
		page_scroll();
		contact_lbl.click();
		address_lbl.click();
	}
	
	public void page_scroll() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollTo(0, 1000)");
	    Thread.sleep(2000);
	}
}
