package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClassTest;
import com.tutorialsninja.pageObjects.AccountPage;
import com.tutorialsninja.pageObjects.AccountSuccessPage;
import com.tutorialsninja.pageObjects.HomePage;
import com.tutorialsninja.pageObjects.LoginPage;
import com.tutorialsninja.pageObjects.NewsletterPage;
import com.tutorialsninja.pageObjects.RegisterPage;
import com.tutorialsninja.utils.Utilities;

public class RegisterTest extends BaseClassTest{
	
	public WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		readConfigDataPropertiesFile();
		readTestDataPropertiesFile();
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountOption();
		registerPage = homePage.clickOnRegisterOption();
	}
	
	@Test(priority = 1)
	public void verifyRegisterAccountWithOnlyMandatoryFields() {
		
		registerPage.enterFirstNameText(dataProp.getProperty("firstName"));
		registerPage.enterLastNameText(dataProp.getProperty("lastname"));
		registerPage.enterEmailText(Utilities.generateEmailWithTimestamp());
		registerPage.enterTelephoneText(dataProp.getProperty("telephone"));
		registerPage.enterPasswordText(dataProp.getProperty("password"));
		registerPage.enterConfirmPassworfText(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnPrivacyPolicyCheckbox();
		AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();
		String actualText = accountSuccessPage.retrieveYourAccountHasBeenCreatedHeadingText();
		String expectedText = dataProp.getProperty("accountSuccessHeading");
		Assert.assertEquals(actualText, expectedText);
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountpage = new AccountPage(driver);
		boolean actualText1 = accountpage.getDisplayStatusOfEditYourAccountInformation();
		Assert.assertTrue(actualText1);
	}
	
	@Test(priority = 2)
	public void verifyRegisterAccountWithAllFileds() {
		
		registerPage.enterFirstNameText(dataProp.getProperty("firstName"));
		registerPage.enterLastNameText(dataProp.getProperty("lastname"));
		registerPage.enterEmailText(Utilities.generateEmailWithTimestamp());
		registerPage.enterTelephoneText(dataProp.getProperty("telephone"));
		registerPage.enterPasswordText(dataProp.getProperty("password"));
		registerPage.enterConfirmPassworfText(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnNewsletterYesRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		accountSuccessPage = registerPage.clickOnContinueButton();
		String actualText = accountSuccessPage.retrieveYourAccountHasBeenCreatedHeadingText();
		String expectedText = dataProp.getProperty("accountSuccessHeading");
		Assert.assertEquals(actualText, expectedText);
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountpage = new AccountPage(driver);
		boolean actualText1 = accountpage.getDisplayStatusOfEditYourAccountInformation();
		Assert.assertTrue(actualText1);
	}
	
	@Test(priority = 3)
	public void verifyRegisterAccountWithYesOptionIsSelectedForNewsletterFiled() {
		
		registerPage.enterFirstNameText(dataProp.getProperty("firstName"));
		registerPage.enterLastNameText(dataProp.getProperty("lastname"));
		registerPage.enterEmailText(Utilities.generateEmailWithTimestamp());
		registerPage.enterTelephoneText(dataProp.getProperty("telephone"));
		registerPage.enterPasswordText(dataProp.getProperty("password"));
		registerPage.enterConfirmPassworfText(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnNewsletterYesRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		accountSuccessPage = registerPage.clickOnContinueButton();
		String actualText = accountSuccessPage.retrieveYourAccountHasBeenCreatedHeadingText();
		String expectedText = dataProp.getProperty("accountSuccessHeading");
		Assert.assertEquals(actualText, expectedText);
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountpage = new AccountPage(driver);
		boolean actualText1 = accountpage.getDisplayStatusOfEditYourAccountInformation();
		Assert.assertTrue(actualText1);
		accountpage.clickOnSubScribeUnsubscribeToNewsletter();
		NewsletterPage newsletterPage = new NewsletterPage(driver);
		boolean radioButtonStatus = newsletterPage.checkedStatusofSubscribeRadioButton();
		Assert.assertTrue(radioButtonStatus);
	}
	
	@Test(priority = 4)
	public void verifyDifferentWaysOfNavigatingToRegisterAccountPage() {
		
		String actualText = registerPage.retrieveRegisterAccountHeadingText();
		Assert.assertTrue(actualText.contains(dataProp.getProperty("registerAccountHeading")));
		homePage.clickOnMyAccountOption();
		loginPage = homePage.clickOnLoginOption();
		loginPage.clickOnContinueButton();
		String actualText1 = registerPage.retrieveRegisterAccountHeadingText();
		Assert.assertTrue(actualText1.contains(dataProp.getProperty("registerAccountHeading")));
		homePage.clickOnMyAccountOption();
		loginPage = homePage.clickOnLoginOption();
		registerPage.clickOnRegisterOption();
		String actualText2 = registerPage.retrieveRegisterAccountHeadingText();
		Assert.assertTrue(actualText2.contains(dataProp.getProperty("registerAccountHeading")));
	}
}
