package com.cpi.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cpi.pages.LoginPage;
import com.cpi.pages.preconditionPostcondition;
import com.cpi.utility.utilities;

public class LoginCPI extends preconditionPostcondition{

	private String excelPath = "./ExcelRead/DataExcel.xlsx";
	private String excelSheetName = "LoginCredentials";
	private String LogonScreen = "//div[@class='ids-login-widget']/child::h1";
	private String LoginHomeScreen = "//span[@class='sapUxAPObjectPageHeaderIdentifierContainer']//ul//li/child::a";

	
	
	@Parameters({"URL","USERNAME", "PASSWORD"})
	@Test
	public void Login(String url, String username, String password)
	{
		utilities utl = new utilities();
		
		try {
			
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(5000);
		
		String Actual = driver.findElement(By.xpath(LogonScreen)).getText();
		
		System.out.println("LOgin Screen Text : "+Actual);
		
		Assert.assertEquals(Actual, "Log On");
		
		Assert.assertEquals(Actual, "Log On", "Validation failed in the Login Screen :");
		
		loginpage.LogintoCpi(username, password);
		
		utl.webdriver_wait(LoginHomeScreen, 30);
		
		
		String actual = driver.findElement(By.xpath(LoginHomeScreen)).getAttribute("innerHTML");
		
		System.out.println(actual);
		
		Assert.assertEquals(actual, "Discover (Integration)");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
