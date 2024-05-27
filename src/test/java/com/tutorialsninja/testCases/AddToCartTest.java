package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClassTest;
import com.tutorialsninja.pageObjects.HomePage;
import com.tutorialsninja.pageObjects.LoginPage;
import com.tutorialsninja.pageObjects.MyWishListPage;
import com.tutorialsninja.pageObjects.SearchPage;
import com.tutorialsninja.pageObjects.ShoppingCartPage;

public class AddToCartTest extends BaseClassTest{

	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		readConfigDataPropertiesFile();
		readTestDataPropertiesFile();
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		
		homePage = new HomePage(driver);
		homePage.enterTextIntoSearchBoxField(dataProp.getProperty("validProductName"));
		searchPage = homePage.clickOnSearchButton();
	}
	
	@Test(priority = 10)
	public void verifyAddingProductToCartFromProductDisplayPage() {
		
		searchPage.clickOnDisplayedProduct();
		searchPage.clickOnAddToCartButton();
		boolean successWarning = searchPage.getDisplayStatusOfSuccessMessage();
		Assert.assertTrue(successWarning);
		searchPage.clickOnShoppingCartLink();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		boolean productDisplayStatus = shoppingCartPage.getDisplayStatusOfDisplayedProduct();
		Assert.assertTrue(productDisplayStatus);
	}
	
	@Test(priority = 11)
	public void verifyAddingTheProductFromWishlist() {
		
		homePage.clickOnMyAccountOption();
		loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddressField(prop.getProperty("validEmail"));
		loginPage.enterPasswordField(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		homePage.enterTextIntoSearchBoxField(dataProp.getProperty("vvalidProductName"));
		searchPage = homePage.clickOnSearchButton();
		searchPage.clickOnAddToWishListButton();
		homePage.clickOnWishListOption();
		MyWishListPage myWishListPage = new MyWishListPage(driver);
		myWishListPage.clickOnAddToCartIconOption();
		boolean successWarning = myWishListPage.getDisplayStatusOfSuccessMessage();
		Assert.assertTrue(successWarning);
		homePage.clickOnShoppingCartOption();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		boolean productDisplayStatus = shoppingCartPage.getDisplayStatusOfDisplayedProduct();
		Assert.assertTrue(productDisplayStatus);	
	}
	
}