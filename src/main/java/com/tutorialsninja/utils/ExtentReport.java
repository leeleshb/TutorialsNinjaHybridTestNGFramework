package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReport() throws Exception {
		
	ExtentReports extentReport = new ExtentReports();
	File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\eReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setDocumentTitle("TN Automation Report");
	sparkReporter.config().setReportName("Tutorials Ninja Test Automation Result");
	sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	extentReport.attachReporter(sparkReporter);
	
	File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
	FileInputStream fis = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(fis);
	
	extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
	extentReport.setSystemInfo("Email", prop.getProperty("validEmail"));
	extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));
	extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
	extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
	extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
	return extentReport;
	
	}
}
