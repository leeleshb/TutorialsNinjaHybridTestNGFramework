package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClassTest;
import com.tutorialsninja.pageObjects.AccountPage;
import com.tutorialsninja.pageObjects.HomePage;
import com.tutorialsninja.pageObjects.LoginPage;
import com.tutorialsninja.utils.Utilities;

public class LoginTest extends BaseClassTest{
	
	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		readConfigDataPropertiesFile();
		readTestDataPropertiesFile();
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountOption();
		loginPage = homePage.clickOnLoginOption();
	}
	
	@Test(priority = 5)
	public void verifyLoginWithValidCredentials() {
		
		accountPage = loginPage.navigateToAccountPage(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation());
		
	}
	
	@Test(priority = 6)
	public void verifyLoginWithInvalidCredentials() {
	
		accountPage = loginPage.navigateToAccountPage(Utilities.generateEmailWithTimestamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessage(), dataProp.getProperty("expectedWarning"));
	}
	
	@Test(priority = 7)
	public void verifyloginWithInvalidEmailAndValidPassword() {

		accountPage = loginPage.navigateToAccountPage(Utilities.generateEmailWithTimestamp(), prop.getProperty("validPassword"));
		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessage(), dataProp.getProperty("expectedWarning"));
	}
	
	@Test(priority = 8)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		accountPage = loginPage.navigateToAccountPage(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessage(), dataProp.getProperty("expectedWarning"));
	}
	
	@Test(priority = 9)
	public void verifyloginWithoutCredentials() {
		
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessage(), dataProp.getProperty("expectedWarning"));
	}
}	
