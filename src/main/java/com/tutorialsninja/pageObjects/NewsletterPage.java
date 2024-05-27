package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement subscribeRadioButton;
	
	public NewsletterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkedStatusofSubscribeRadioButton() {
		boolean checkedStatus = subscribeRadioButton.isSelected();
		return checkedStatus;
	}
}
