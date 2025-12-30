package com.axissquare.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	LoginPage loginPage;

	// Objects
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//a[normalize-space()='Lost your password?']")
	WebElement forgotPasswordLink;
	@FindBy(xpath = "//label[normalize-space()='Remember me']")
	WebElement rememberMeCheckBox;
	@FindBy(xpath = "//button[@id='houzez-login-btn']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
//	public String retrieveUserNameWarning()
//	{
//		return 
//	}
//	

	public void enterUserName(String userNameText) {
		userNameField.sendKeys(userNameText);
	}

	public void enterPassowrd(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void selectRememberMeCheckBox() {
		rememberMeCheckBox.click();
	}

	public void clickOnLoginOption() {
		loginButton.click();
	}

	public LoginPage loginPage(String userNameText, String passwordText) {
		userNameField.sendKeys(userNameText);
		passwordField.sendKeys(passwordText);
		rememberMeCheckBox.click();
		loginButton.click();
		return new LoginPage(driver);
	}

}
