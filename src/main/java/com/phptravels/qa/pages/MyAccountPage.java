package com.phptravels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.phptravels.qa.base.TestBase;

public class MyAccountPage extends TestBase {

	
	
	@FindBy(xpath = "//h1[contains(text(),'My account')]")
	WebElement myAccountHeader;
	
	
	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	WebElement dresses;

	@FindBy(xpath = "//a[@title='Summer Dresses']")
	WebElement SummerDresses;

	@FindBy(id = "selectProductSort")
	WebElement selectProductSort;

	@FindBy(xpath = "(//span[@class='available-now'])[1]")
	WebElement inStock;

	@FindBy(xpath = "(//a[@title='Add to cart'])[1]")
	WebElement addToCart;

	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[1]")
	WebElement Proceedtocheckout;

	public MyAccountPage() {
		PageFactory.initElements(driver, MyAccountPage.this);
	}

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public void selectSummerDresses() {
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(dresses).build().perform();
		SummerDresses.click();
		


	}
	public String validateMyAccountText() {
		String myAccountText =myAccountHeader.getText();
		return myAccountText;
		
	}

}
