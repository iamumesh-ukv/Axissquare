package com.axissquare.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.axissquare.qa.baseclass.BaseClass;
import com.axissquare.qa.pages.DashboardPage;
import com.axissquare.qa.pages.LoginPage;

public class LoginTest extends BaseClass{
	WebDriver driver;
	LoginPage loginpage;
	DashboardPage dashboardPage;

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		DashboardPage dashboardPage = new DashboardPage(driver);
		loginpage = dashboardPage.navigateToLoginPage();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	@Test
	public void verifyLoginWithValidCredentials()
	{
		
	}

}
