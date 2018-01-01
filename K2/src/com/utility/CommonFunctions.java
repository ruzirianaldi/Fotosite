package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath,String imgName) throws Exception{

	      //Convert web driver object to TakeScreenshot

	      TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	      //Call getScreenshotAs method to create image file

	      File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	          //Move image file to new destination

	     File DestFile=new File(fileWithPath+imgName);

	              //Copy file at destination

	    FileUtils.copyFile(SrcFile, DestFile);

	  }
	
	public static void pageScroll(WebDriver driver,int x,int y){
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")", "");
	}

}
