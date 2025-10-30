package com.axissquare.qa.pages;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	RegisterPage registerPage;
	
	//Objects
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement enterFirstName;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement enterLastName;
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement enterUserName;
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement enterEmailAddress;
	@FindBy(xpath="//input[@placeholder='Phone']")
	WebElement enterPhoneNumber;
	@FindBy(xpath="//input[@name='register_pass']")
	WebElement enterPassword;
	@FindBy(xpath="//input[@placeholder='Retype Password']")
	WebElement retypePassword;
	@FindBy(xpath="//ul[@role='presentation']//li")
	List<WebElement>selectAccountType;
	@FindBy(xpath="//label[@class='control control--checkbox']")
	WebElement checkTermsAndConditions;
	@FindBy(xpath="//button[@id='houzez-register-btn']")
	WebElement clickOnRegisterButton;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//Actions
	

}
