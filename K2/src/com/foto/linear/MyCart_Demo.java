package com.foto.linear;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MyCart_Demo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		String path = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", path +"//Browser//chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://mage.foto.com/fr/");
		
		WebElement myAccount =driver.findElement(By.xpath("//*[@class='customer-top-navigation']/ul/li[4]"));
		myAccount.click();

		Thread.sleep(500);
		WebElement custMail =driver.findElement(By.xpath("//*[@id='email']"));
		custMail.sendKeys("alen@mailinator.com");
		
		WebElement custPass =driver.findElement(By.xpath("//*[@id='pass']"));
		custPass.sendKeys("123456");
		
		WebElement loginBtn =driver.findElement(By.xpath("//*[@id='send2']"));
		loginBtn.click();

		System.out.println("Successfully Login system");
		
		//Click on My Cart
		
		WebElement mycart = driver.findElement(By.xpath("//*[@class='is-visible-small']"));
		mycart.click();
		System.out.println("Redirect on My Cart page");
		
		WebElement Product_empty_Text = driver.findElement(By.xpath("//*[@class='page-title']"));
		String str =Product_empty_Text.getText();
		
		System.out.println(str);
		
		if(str.equalsIgnoreCase("Le panier est vide"))
		{
			System.out.println("Your cart is empty");
			WebElement clickhere = driver.findElement(By.xpath("//*[@class='cart-empty']/p[2]/a"));
			clickhere.click();
			System.out.println("User redirect on Homepage");
		}
		
		//Hover mouser on category list
	    //Click on menu action
		
		WebElement hover_menu3 = driver.findElement(By.xpath("//*[@id='menu3']"));
		//hover_menu3.click();
		Actions action = new Actions(driver);
		action.moveToElement(hover_menu3).build().perform();
		Thread.sleep(1000);
		WebElement photoprint_cat = driver.findElement(By.xpath(".//*[@id='ct-product-list-menu_cat_highlight']/div/div[1]/div/div"));
		photoprint_cat.click();
		
		Thread.sleep(1000);
		
		//Click on Add to cart button
		
		WebElement Add_to_Cart_btn = driver.findElement(By.xpath("//*[@class='add-to-cart-buttons']"));
		Add_to_Cart_btn.click();
		
		
		/*---------------------*/
		WebElement click_tr = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div/h3"));
        click_tr.click();
        
        Thread.sleep(5000);
        WebElement uploadElement = driver.findElement(By.xpath("//*[@id='uploader']/div[1]/div[3]/div/div[1]/ul/li/div/span"));

        // enter the file path onto the file-selection input field
        //uploadElement.sendKeys("C:\\Users\\computer\\Desktop\\sample1_l.jpg");
        //C:\Users\computer\Documents\performance-appraisal-53-638.jpg
        uploadElement.click();
        
        StringSelection sel = new StringSelection("F:\\ff2\\Fotosite\\ImageSelection\\Help.png");
        
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" +sel);
        
     // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);
             
         // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        
       // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        
         // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        
       // Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(3000);
              
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
