package com.phptravels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.LoginPage;
import com.phptravels.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase {
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	String expectedMyAccountPageTitle = "My account - My Store";
	String expectedTextMessageFromMyAccount = "MY ACCOUNT";

	public MyAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// Creating Object of initialization from TestBase for pre-requisties
		initialization();
		// Creating Object of LoginPage class
		loginPage = new LoginPage();
		myAccountPage = loginPage.loginIn(configproperty.getProperty("username"),
				configproperty.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyMyaccountPageTitleTest() {
		String actualMyAccountPageTitle = myAccountPage.validateLoginPageTitle();
		Assert.assertEquals(actualMyAccountPageTitle, expectedMyAccountPageTitle, "MyAccount Page Title is Verified");
	}

	@Test(priority = 2)
	public void checkMyAccountpagetextTest() {
		String actualTextMessageFromMyAccount = myAccountPage.validateMyAccountText();
		Assert.assertEquals(actualTextMessageFromMyAccount, expectedTextMessageFromMyAccount,
				"MyAccount text message Verified");
	}
	
	

	

	@Test(priority = 3)
	public void selectSummerDressTest() {
		myAccountPage.selectSummerDresses();
		System.out.println("SummerDress selected");
	}

	@AfterMethod
	public void tearDownbrowser() {
		driver.quit();
	}

}
