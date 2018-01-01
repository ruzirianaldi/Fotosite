/**
 * 
 */
package com.foto.linear;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author DELL
 *
 */
public class Registration_demo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String path = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", path +"//Browser//geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://mage.foto.com/fr/");
		
		WebElement myAccount =driver.findElement(By.xpath("//*[@class='customer-top-navigation']/ul/li[4]"));
		myAccount.click();
		
		WebElement Create_Acc_Btn =driver.findElement(By.xpath("//*[@class='buttons-set']/a"));
		Create_Acc_Btn.click();
		
		WebElement first_name_txt = driver.findElement(By.xpath("//*[@id='firstname']"));
		first_name_txt.sendKeys("John1");
		
		WebElement middle_name_txt =driver.findElement(By.xpath("//*[@id='middlename']"));
		middle_name_txt.sendKeys("smith1");
		
	    WebElement last_name_txt = driver.findElement(By.xpath("//*[@id='lastname']"));
	    last_name_txt.sendKeys("watson1");
	    
	    WebElement cust_registration_mail = driver.findElement(By.xpath("//*[@id='email_address']"));
	    cust_registration_mail.sendKeys("John1@mailinator.com");
	    
	    WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
	    password.sendKeys("123456");
	    
	    WebElement confirm_psd = driver.findElement(By.xpath("//*[@id='confirmation']"));
	    confirm_psd.sendKeys("123456");
		
	    
	     WebElement registration_btn = driver.findElement(By.xpath("//*[@class='buttons-set']/button"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registration_btn);
	    Thread.sleep(500);
	    registration_btn.click();

	}

}
