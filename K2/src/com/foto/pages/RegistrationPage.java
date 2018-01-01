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
public class RegistrationPage {
	
	public WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using = "//*[@class='customer-top-navigation']/ul/li[4]")
	WebElement myAccount;
	
	@FindBy(how=How.XPATH, using ="//*[@class='buttons-set']/a")
	WebElement Create_Acc_Btn;
	
	@FindBy(how=How.XPATH, using ="//*[@id='firstname']")
	WebElement first_name_txt;
	
	@FindBy(how =How.XPATH, using ="//*[@id='middlename']")
	WebElement middle_name_txt;
	
	@FindBy(how=How.XPATH, using ="//*[@id='lastname']")
	WebElement last_name_txt;
	
	@FindBy(how =How.XPATH, using ="//*[@id='email_address']")
	WebElement cust_registration_mail;
	
	@FindBy(how =How.XPATH, using ="//*[@id='password']")
	WebElement password;
	
	@FindBy(how =How.XPATH, using ="//*[@id='confirmation']")
	WebElement confirm_psd;
	
	@FindBy(how =How.XPATH, using = "//*[@class='buttons-set']/button")
	WebElement registration_btn;
	
	public void registration_form() throws InterruptedException
	 {
		Thread.sleep(1000);
		myAccount.click();
		Create_Acc_Btn.click();
		first_name_txt.sendKeys("abc1");
		middle_name_txt.sendKeys("abc2");
		last_name_txt.sendKeys("abc3");
		cust_registration_mail.sendKeys("abc@gmail.com");
		password.sendKeys("123456");
		confirm_psd.sendKeys("123456");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registration_btn);
		registration_btn.click();
	}
}
