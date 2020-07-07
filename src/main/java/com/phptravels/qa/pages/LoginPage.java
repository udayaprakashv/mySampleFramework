package com.phptravels.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Define PageFactory or OR
	@FindBy(xpath = "//a[@class='login']")
	WebElement loginIn;

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	// initilazation page Object
	public LoginPage() {
		PageFactory.initElements(driver, LoginPage.this);
	}

	// Actions:
	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public MyAccountPage loginIn(String un, String pw) {
		
		loginIn.click();
		username.sendKeys(un);
		password.sendKeys(pw);
		signInButton.click();
		return new MyAccountPage();

	}

}