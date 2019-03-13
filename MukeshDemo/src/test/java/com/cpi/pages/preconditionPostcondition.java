package com.cpi.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import com.cpi.utility.BrowserInitialization;
import com.cpi.utility.CaptureScreenshot;
import com.cpi.utility.ExcelReadData;
import com.cpi.utility.ReadPropertyFile;

public class preconditionPostcondition {

	public WebDriver driver;
	public ExcelReadData Excel;
	public ReadPropertyFile or;
	@BeforeSuite
	public void Excelsetup()
	{
		 Excel = new ExcelReadData();
		 or = new ReadPropertyFile();
	}
	
	@BeforeClass
	public void StartApplication() throws IOException
	{
		driver = BrowserInitialization.launchBrowser(driver, or.getpropvalue("URL"));
	}
	
	@AfterMethod
	public void Takescreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		CaptureScreenshot.capturescreenshot(driver);
		System.out.println("ScreenShot");
		}
	}
	
	@AfterClass
	public void EndApplication()
	{
		BrowserInitialization.QuitBrowser(driver);
	}
	
}
