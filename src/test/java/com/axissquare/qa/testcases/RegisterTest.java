package com.axissquare.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
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
	SoftAssert softAssert;
	//softAssert softAssert = new SoftAssert();

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		dashboardPage = new DashboardPage(driver);
		registerPage = dashboardPage.navigateToRegisterPage();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		registerPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), dataProp.getProperty("userName"), dataProp.getProperty("userEmail"),
				dataProp.getProperty("userPhone"), dataProp.getProperty("userPassword"),
				dataProp.getProperty("userReTypePassword"), "Buyer");

	}

	public void verifyRegisteringAccountWithExistingEmailAddress() {

		registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				dataProp.getProperty("userName"), dataProp.getProperty("existingEmail"),
				dataProp.getProperty("userPhone"), dataProp.getProperty("userPassword"),
				dataProp.getProperty("userReTypePassword"), "Buyer");

		Assert.assertTrue(driver.getPageSource().contains("already exists"),
				"Existing email validation message not displayed");
	}

	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		registerPage.registerWithMandatoryFields(
                "", "", "", "", "", "", "", ""
        );
		
        softAssert.assertEquals(
                registerPage.retrieveFirstNameWarning(),
                "The first name field is empty."
        );

        softAssert.assertEquals(
                registerPage.retrieveLastNameWarning(),
                "The last name field is empty."
        );

        softAssert.assertEquals(
                registerPage.retrieveUserNameWarning(),
                "The username field is empty."
        );

        softAssert.assertEquals(
                registerPage.retrieveEmailWarning(),
                "The email field is empty."
        );

        softAssert.assertEquals(
                registerPage.retrievePhoneNumberWarning(),
                "Please enter your number"
        );

        softAssert.assertEquals(
                registerPage.retrievePasswordWarning(),
                "One of the password field is empty!"
        );

        softAssert.assertEquals(
                registerPage.retrieveTermsAndConditionsWarning(),
                "You need to agree with terms & conditions."
        );

        softAssert.assertAll();
    }
}
