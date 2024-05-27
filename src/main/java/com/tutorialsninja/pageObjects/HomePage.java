package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	private WebElement searchButton;
	
	@FindBy(id="wishlist-total")
	private WebElement wishListOption;
	
	@FindBy(linkText="Shopping Cart")
	private WebElement shoppingCartOption;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccountOption() {
		myAccount.click();
	}
	
	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterTextIntoSearchBoxField(String validProductName) {
		searchBox.sendKeys(validProductName);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public void clickOnWishListOption() {
		wishListOption.click();
	}
	
	public void clickOnShoppingCartOption() {
		shoppingCartOption.click();
	}
	
}
