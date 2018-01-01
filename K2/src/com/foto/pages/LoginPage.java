/**
 * 
 */
package com.foto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.CommonFunctions;

import extentReports.ExtentReportUtility;

/**
 * @author Bhavesh Rathod
 *
 */
public class LoginPage extends ExtentReportUtility { 
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locate Element for login page
	
	@FindBy(how=How.XPATH,using = "//*[@class='customer-top-navigation']/ul/li[4]")
	WebElement myAccount;
	
	@FindBy(how=How.XPATH,using = "//*[@id='email']")
	WebElement custMail;
	
	@FindBy(how=How.XPATH, using ="//*[@id='pass']")
	WebElement custPass;
	
	@FindBy(how=How.XPATH, using ="//*[@id='send2']")
	WebElement loginBtn;
	
	@FindBy(how=How.XPATH, using ="//*[@id='advice-required-entry-email']")
	WebElement emptyEmailVal;
	
	@FindBy(how=How.XPATH, using ="//*[@id='advice-required-entry-pass']")
	WebElement emptyPwdVal;
	
	@FindBy(how=How.XPATH, using ="//*[@id='advice-validate-email-email']")
	WebElement invalidEmailId;
	
	@FindBy(how=How.XPATH, using ="//*[@id='advice-validate-password-pass']")
	WebElement minPwdVal;
	
	@FindBy(how=How.XPATH, using ="//*[@class='switch-lang']")
	WebElement lngSwitch;
	
	@FindBy(how=How.LINK_TEXT, using ="EN")
	WebElement engSelect;
	//Creating method
	
	public void login_foto_site()
	{
		myAccount.click();
		lngSwitch.click();
		engSelect.click();
		loginBtn.click();
		//verifying empty email field validation
		String emptyEmail = emptyEmailVal.getText();
		if(emptyEmail.equals("This is a required field.")){
			custMail.sendKeys("peter@yopmail");
		}else{
			System.out.println("Empty email validation message changed.");
			test.log(Status.FAIL, MarkupHelper.createLabel("Empty email validation message changed. So case considered as Fail", ExtentColor.RED));
		}
		//verifying empty password field validation
		String emptyPwd = emptyPwdVal.getText();
		if(emptyPwd.equals("This is a required field.")){
			custPass.sendKeys("123");
		}else{
			System.out.println("Empty Password validation message changed.");
			test.log(Status.FAIL, MarkupHelper.createLabel("Empty Password validation message changed. So case considered as Fail", ExtentColor.RED));
		}
		//verifying invalid email address validation
		CommonFunctions.pageScroll(driver,0,100);
		loginBtn.click();
		String invalidEmail = invalidEmailId.getText();
		if(invalidEmail.equals("Please enter a valid email address. For example johndoe@domain.com.")){
			custMail.clear();
			custMail.sendKeys("peter@yopmail.com");
			
		}else{
			System.out.println("Invalid email validation message changed.");
			test.log(Status.FAIL, MarkupHelper.createLabel("Invalid email validation message changed. So case considered as Fail", ExtentColor.RED));
		}
		//verifying minimum required characters for password field validation validation
		loginBtn.click();
		String minPwd = minPwdVal.getText();
		if(minPwd.equals("Please enter 6 or more characters without leading or trailing spaces.")){
			custPass.clear();
			custPass.sendKeys("12345678");
		}else{
			System.out.println("Minimum Pasword characters required validation message changed.");
			test.log(Status.FAIL, MarkupHelper.createLabel("Minimum Pasword characters required validation message changed. So case considered as Fail", ExtentColor.RED));
		}
		loginBtn.click();
	}

}
