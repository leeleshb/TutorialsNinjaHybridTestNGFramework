package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText="iMac")
	private WebElement displayedProduct;
	
	@FindBy(id="button-cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageText;
	
	@FindBy(linkText="shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath="//div[@class='button-group']/button[2]")
	private WebElement addToWishListButton;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDisplayedProduct() {
		displayedProduct.click();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public boolean getDisplayStatusOfSuccessMessage() {
		boolean displayStatus = successMessageText.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnShoppingCartLink() {
		shoppingCartLink.click();
	}
	
	public void clickOnAddToWishListButton() {
		addToWishListButton.click();
	}
}
