package com.axissquare.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;
	RegisterPage registerPage;

	// Objects
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement enterFirstName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement enterLastName;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement enterUserName;
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement enterEmailAddress;
	@FindBy(xpath = "//input[@placeholder='Phone']")
	WebElement enterPhoneNumber;
	@FindBy(xpath = "//input[@name='register_pass']")
	WebElement enterPassword;
	@FindBy(xpath = "//input[@name='register_pass_retype']")
	WebElement retypePassword;
	@FindBy(xpath = "//div[contains(text(),'Select your account type')]")
	WebElement selectAccountTypeDropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu inner show']//li")
	List<WebElement> selectAccountList;
	@FindBy(xpath = "//label[@class='control control--checkbox']")
	WebElement checkTermsAndConditions;
	@FindBy(xpath = "//button[@id='houzez-register-btn']")
	WebElement clickOnRegisterButton;
	// validation locators
	@FindBy(xpath = "//div[@role='alert']")
	WebElement firstNameWarning;
	@FindBy(xpath = "//div[contains(text(),'The last name field is empty.')]")
	WebElement lastNameWarning;
	@FindBy(xpath = "//div[contains(text(), 'The username field is empty.')]")
	WebElement userNameWarning;
	@FindBy(xpath = "//div[contains(text(),'The email field is empty.')]")
	WebElement emailWarning;
	@FindBy(xpath = "//div[contains(text(), 'Please enter your number')]")
	WebElement phoneNumberWarning;
	@FindBy(xpath = "//div[contains(text(), 'One of the password field is empty!')]")
	WebElement passwordWarning;
	@FindBy(xpath = "//div[contains(text(), 'Passwords do not match')]")
	WebElement passwordNotMatchingWarning;
	@FindBy(xpath = "//div[contains(text(), 'You need to agree with terms & conditions.')]")
	WebElement termsAndConditionsWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	/*
	 * public void enterFirstName(String firstNameText) {
	 * enterFirstName.sendKeys(firstNameText); }
	 * 
	 * public void enterLastName(String lastNameText) {
	 * enterLastName.sendKeys(lastNameText); }
	 * 
	 * public void enterEmailAddress(String emailAddressText) {
	 * enterEmailAddress.sendKeys(emailAddressText); }
	 * 
	 * public void enterPhoneNumber(String phoneNumber) {
	 * enterPhoneNumber.sendKeys(phoneNumber); }
	 * 
	 * public void enterPassword(String passwordText) {
	 * enterPassword.sendKeys(passwordText); }
	 * 
	 * public void reEnterPassword(String retypePasswordText) {
	 * retypePassword.sendKeys(retypePasswordText); }
	 * 
	 * public void selectAccountType(WebElement accountType) { for (WebElement
	 * account : selectAccountList) { if
	 * (account.getText().equals(selectAccountList)) { account.click(); } } }
	 * 
	 * public RegisterPage selectTermsAndConditions() {
	 * checkTermsAndConditions.click(); return new RegisterPage(driver); }
	 * 
	 * public RegisterPage ClickOnRegisterButton() { clickOnRegisterButton.click();
	 * return new RegisterPage(driver); }
	 */

	// Generic reusable method (ONLY ONCE)
	public String getWarningText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed() ? element.getText().trim() : "";
		} catch (Exception e) {
			System.out.println("Warning not displayed: " + element);
			return "";
		}
	}

	// First Name warning
	public String retrieveFirstNameWarning() {
		return getWarningText(firstNameWarning);
	}

	// Last Name warning
	public String retrieveLastNameWarning() {
		return getWarningText(lastNameWarning);
	}

	// User name warning
	public String retrieveUserNameWarning() {
		return getWarningText(userNameWarning);
	}

	// Email warning
	public String retrieveEmailWarning() {
		return getWarningText(emailWarning);
	}

	// Phone number warning
	public String retrievePhoneNumberWarning() {
		return getWarningText(phoneNumberWarning);
	}

	// Password empty warning
	public String retrievePasswordWarning() {
		return getWarningText(passwordWarning);
	}

	// Password mismatch warning
	public String retrievePasswordNotMatchingWarning() {
		return getWarningText(passwordNotMatchingWarning);
	}

	// Terms & Conditions warning
	public String retrieveTermsAndConditionsWarning() {
		return getWarningText(termsAndConditionsWarning);
	}

	public void selectAccountType(String accountList) {
		for (WebElement account : selectAccountList) {
			if (account.getText().equalsIgnoreCase(accountList)) {
				account.click();
				break;
			}
		}
	}

	public RegisterPage registerWithMandatoryFields(String firstNameText, String lastNameText, String userNameText,
			String emailText, String userPhoneText, String userPasswordText, String userReTypePasswordText,
			String accountTypeText) {

		enterFirstName.sendKeys(firstNameText);
		enterLastName.sendKeys(lastNameText);
		enterUserName.sendKeys(userNameText);
		enterEmailAddress.sendKeys(emailText);
		enterPhoneNumber.sendKeys(userPhoneText);
		enterPassword.sendKeys(userPasswordText);
		retypePassword.sendKeys(userReTypePasswordText);
		selectAccountTypeDropdown.click();
		selectAccountType(accountTypeText);
		checkTermsAndConditions.click();
		clickOnRegisterButton.click();

		return new RegisterPage(driver);
	}
}
