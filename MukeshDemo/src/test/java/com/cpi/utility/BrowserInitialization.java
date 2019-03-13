package com.cpi.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInitialization {

	public String chromeDriverProperty = "webdriver.chrome.driver";
	public String chromeDriverpath = "./chromedriver.exe";
	
	public static WebDriver launchBrowser(WebDriver driver, String Url)
	{
		System.setProperty("chromeDriverProperty", "chromeDriverpath");
		driver = new ChromeDriver();
		driver.navigate().to(Url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
