package com.cpi.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cpi.pages.preconditionPostcondition;

public class ReadPropertyFile extends preconditionPostcondition{

	WebElement element;
	public String getpropvalue(String key) throws IOException{

		String element = null;
		try {
			FileInputStream fis = new FileInputStream("./property/ObjectRepository.properties");
			Properties pro = new Properties();
			pro.load(fis);
			element=pro.getProperty(key);	

		} catch (Exception e) {
			System.out.println("Unable to find property value for "+key);
			System.out.println("Error : "+e.getMessage());
			System.exit(0);
		}

		return element;
	}

}
