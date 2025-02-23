package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformation;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement newsletter;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayStatusOfEditYourAccountInformation() {
		boolean displayStatus = editYourAccountInformation.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnSubScribeUnsubscribeToNewsletter(){
		newsletter.click();
	}
}
