package com.cpi.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
	private WebElement ele;
	
	
	@Parameters({"URL","USERNAME", "PASSWORD"})
	@Test
	public void Login(String url, String username, String password)
	{
		utilities utl = new utilities();
		
		try {
			/*//utl.webdriver_wait(LogonScreen, 30);
			//ele = driver.findElement(By.xpath(LogonScreen));
			System.out.println("log on screen : " +ele.getText());
			if(ele.getText().contentEquals("Log On"))
				
			{
				System.out.println("login page is displayed");
			}
			else {
				System.out.println("login page is not displayed");
			}*/
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		/*String[][] excelData =	Excel.getDataFromExcel(excelPath,excelSheetName, driver);*/
		Thread.sleep(5000);
		loginpage.LogintoCpi(username, password);
		/*loginpage.LogintoCpi(or.getpropvalue("UserName"),or.getpropvalue("PassWord"));*/
		utl.webdriver_wait(LoginHomeScreen, 30);
		ele = driver.findElement(By.xpath(LoginHomeScreen));
		if(ele.getText().equals("Discover (Integration)"))
		{
			System.out.println("home screen is displayed");
		}
		else {
			System.out.println("home screenis not displayed");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
