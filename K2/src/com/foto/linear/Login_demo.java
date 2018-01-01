package com.foto.linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        
		String path = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", path +"//Browser//geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://mage.foto.com/fr/");
		
		WebElement myAccount =driver.findElement(By.xpath("//*[@class='customer-top-navigation']/ul/li[4]"));
		myAccount.click();

		Thread.sleep(500);
		WebElement custMail =driver.findElement(By.xpath("//*[@id='email']"));
		custMail.sendKeys("alex@mailinator.com");
		
		WebElement custPass =driver.findElement(By.xpath("//*[@id='pass']"));
		custPass.sendKeys("auction@123");
		
		WebElement loginBtn =driver.findElement(By.xpath("//*[@id='send2']"));
		loginBtn.click();
	}

}
