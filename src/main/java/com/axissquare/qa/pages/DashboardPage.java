package com.axissquare.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	DashboardPage dashboardpPage;

	@FindBy(xpath = "//ul[@class='login-register-nav dropdown d-flex align-items-center']//li[@class='register-link']//a[@href='#'][normalize-space()='Register']")
	WebElement registerOption;

	@FindBy(xpath = "//ul[@class='login-register-nav dropdown d-flex align-items-center']//li[@class='login-link']//a[@href='#'][normalize-space()='Login']")
	WebElement loginOption;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegisterPage navigateToRegisterPage() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	// Actions

	public LoginPage navigateToLoginPage() {
		loginOption.click();
		return new LoginPage(driver);
	}
}
