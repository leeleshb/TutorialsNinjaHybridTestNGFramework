package com.tutorialsninja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsletterYesRadioButton;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement registerAccountHeading;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstNameText(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastNameText(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailText(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneText(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPasswordText(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassworfText(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void clickOnNewsletterYesRadioButton() {
		newsletterYesRadioButton.click();
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String retrieveRegisterAccountHeadingText() {
		String registerAccountText = registerAccountHeading.getText();
		return registerAccountText;
	}
	
	public void clickOnRegisterOption() {
		registerOption.click();
	}
}
