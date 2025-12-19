package com.axissquare.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.axissquare.qa.baseclass.BaseClass;
import com.axissquare.qa.pages.DashboardPage;
import com.axissquare.qa.pages.RegisterPage;

public class RegisterTest extends BaseClass {

	WebDriver driver;
	RegisterPage registerPage;
	DashboardPage dashboardPage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		DashboardPage dashboardPage = new DashboardPage(driver);
		registerPage = dashboardPage.navigateToRegisterPage();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		// registerPage
		// =registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
		// Assert.assertEquals(registerPage.retrieveAccountSuccessPageHeading().contains(dataProp.getProperty("accountSuccessfullyCreatedHeading")),"Congratulations!
		// your account has been successfull");
	}
}