/**
 * 
 */
package com.foto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bhavesh Rathod
 * This pages contains all location which required for the ADD TO CART process
 *
 */
public class AddToCartVerification {
	
	//Declare instace variable
	
	WebDriver driver;

	//Declare constructor and pass webdriver object
	public AddToCartVerification(WebDriver driver)
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
	
	//After login user redirect on My Account page
	
	@FindBy(how=How.XPATH,using ="//*[@class='is-visible-small']")
	WebElement myCart;
	
	//To check empty cart text
	
	@FindBy(how=How.XPATH, using ="//*[@class='page-title']")
	WebElement empty_cart_msg;
	
	//To click on the Click here link
	@FindBy(how=How.XPATH, using ="//*[@class='cart-empty']/p[2]/a")
	WebElement click_here_text;
	
	//Hover mouse on first menu
	@FindBy(how=How.XPATH, using ="//*[@id='menu3']")
	WebElement hover_menu3;
	
	//Click on First Photo category
	@FindBy(how=How.XPATH, using =".//*[@id='ct-product-list-menu_cat_highlight']/div/div[1]/div/div")
	WebElement First_Photo_cat;
	
	//Click on Add to cart button
	@FindBy(how=How.XPATH, using="//*[@class='add-to-cart-buttons']")
	WebElement Add_to_Cart_btn;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div/h3")
	WebElement click_tr;

	//Click on File uploader
	@FindBy(how=How.XPATH, using="//*[@id='uploader']/div[1]/div[3]/div/div[1]/ul/li/div/span")
	WebElement uploadElement;
	
	
	public void Login()
	{
		myAccount.click();
		custMail.sendKeys("alen@mailinator.com");
		custPass.sendKeys("123456");
		loginBtn.click();
	}
	

	
	

}
