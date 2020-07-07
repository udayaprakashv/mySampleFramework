package com.phptravels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.phptravels.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties configproperty;

	public TestBase() {

		//To read and load the config.properites file
		try {
			configproperty = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\u44052\\eclipse-workspace\\phptravels\\src\\main\\java\\com\\phptravels\\qa\\config\\config.properties");
			configproperty.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
// driver initialization or Pre requiestes 
	public static void initialization() {
		String browerName = configproperty.getProperty("browser");
		if (browerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}else {
			System.out.println("");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(configproperty.getProperty("url"));
	}
}
