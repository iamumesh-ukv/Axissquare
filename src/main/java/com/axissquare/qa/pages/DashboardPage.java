package com.axissquare.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	DashboardPage dashboardpPage;

	@FindBy(xpath="//ul[@class='login-register-nav dropdown d-flex align-items-center']//li[@class='register-link']//a[@href='#'][normalize-space()='Register']")
	WebElement clickOnRegisterButton;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegisterPage navigateToRegisterPage() {
		clickOnRegisterButton.click();
		return new RegisterPage(driver);
	}
	//Actions
	
}
