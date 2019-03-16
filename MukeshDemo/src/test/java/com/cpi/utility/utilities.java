package com.cpi.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.cpi.pages.preconditionPostcondition;

public class utilities extends preconditionPostcondition{
	
	
	public void webdriver_wait(String xpath_wait, int time_out) {
		try {
			@SuppressWarnings("deprecation")
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(time_out, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_wait)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_wait)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_wait)));
		} catch (Exception e) {
		}	
	}
	
}
