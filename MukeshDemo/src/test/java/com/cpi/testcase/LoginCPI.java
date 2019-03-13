package com.cpi.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cpi.pages.LoginPage;
import com.cpi.pages.preconditionPostcondition;

public class LoginCPI extends preconditionPostcondition{

	private String excelPath = "./ExcelRead/DataExcel.xlsx";
	private String excelSheetName = "LoginCredentials";
	
	@Test
	public void Login()
	{
		try {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		String[][] excelData =	Excel.getDataFromExcel(excelPath,excelSheetName, driver);
		Thread.sleep(5000);
		loginpage.LogintoCpi(excelData[0][0],excelData[1][0]);
		/*loginpage.LogintoCpi(or.getpropvalue("UserName"),or.getpropvalue("PassWord"));*/
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
