package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement yourAccountHasBeenCreatedHeading;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveYourAccountHasBeenCreatedHeadingText() {
		String accountSuccessText = yourAccountHasBeenCreatedHeading.getText();
		return accountSuccessText;
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
}
