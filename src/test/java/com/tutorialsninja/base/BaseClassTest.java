package com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import com.tutorialsninja.utils.Utilities;

public class BaseClassTest {

	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public void readConfigDataPropertiesFile() throws Exception {
		
		File configFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		FileInputStream fis = new FileInputStream(configFile);
		prop = new Properties();
		prop.load(fis);
	}
	
	public void readTestDataPropertiesFile() throws Exception {
		
		File testdataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.properties");
		FileInputStream fis = new FileInputStream(testdataFile);
		dataProp = new Properties();
		dataProp.load(fis);
	}
	
	
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) throws Exception {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICITWAIT));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
}
