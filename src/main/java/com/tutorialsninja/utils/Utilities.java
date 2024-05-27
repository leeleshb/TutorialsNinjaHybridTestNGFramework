package com.tutorialsninja.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static int IMPLICITWAIT = 10;
	
	public static String generateEmailWithTimestamp() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "-").replace(":", "-");
		return "abc"+timeStamp+"@gmail.com";
		
	}
	
	public static String generateReportWithTimestamp() {
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_a");
		String formattedDate = dateFormat.format(now);
		return "eReport"+formattedDate+".html";
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		File sourceScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+("\\Screenshots\\"+testName+".png");
		
		try {
			FileHandler.copy(sourceScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
		
	}
}
