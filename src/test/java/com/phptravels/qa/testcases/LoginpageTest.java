package com.phptravels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.LoginPage;

public class LoginpageTest extends TestBase {
	// Class level variable and will use through-out my progremme
	LoginPage loginPage;
	String expectedLoginPageTitle = "My account - My Store";

	// This is constructor of LoginpageTest calss and use this Super() ; form
	// TestBase class for properties
	public LoginpageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// Creating Object of initialization from TestBase for pre-requisties
		initialization();
		// Creating Object of LoginPage class
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPage() {
		loginPage.loginIn(configproperty.getProperty("username"), configproperty.getProperty("password"));
		String actualLoginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "Verified loginPage title");

	}

	@AfterMethod
	public void tearDownbrowser() {
		driver.quit();
	}
}
