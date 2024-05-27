package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-original-title='Add to Cart']")
	private WebElement addToCartIcon;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;
	
	public MyWishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartIconOption() {
		addToCartIcon.click();
	}
	
	public boolean getDisplayStatusOfSuccessMessage() {
		boolean successMessageText = successMessage.isDisplayed();
		return successMessageText;
	}
}
