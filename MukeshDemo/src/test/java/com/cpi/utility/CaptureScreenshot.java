package com.cpi.utility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	
	public static void capturescreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File("./ScreenShot/Loginn.png"));
		} catch (IOException e) {
			System.out.println("Unable to take screeenshot" +e.getMessage());
		}
	}

}
