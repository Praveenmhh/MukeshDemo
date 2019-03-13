package com.cpi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath = "//input[@id='j_username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='j_password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Log On']")
	WebElement login;
	
	public void LogintoCpi(String username, String password)
	{
		try {
			Username.sendKeys(username);
			Password.sendKeys(password);
			login.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
