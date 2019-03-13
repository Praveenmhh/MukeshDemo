package com.cpi.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.cpi.pages.preconditionPostcondition;

public class ExcelReadData extends preconditionPostcondition{
	public String[][] getDataFromExcel(String excelPath, String sheetName, WebDriver driver){ 
		String[][] dataFromExcel=null;
		File file;
		FileInputStream fis=null;
		try{
			file=new File(excelPath);
			fis=new FileInputStream(file);
		}catch(Exception e){
			//System.out.println(e);
			driver.quit();
			System.exit(0);
		}
		Workbook wrkBook=null;
		try {
			wrkBook = WorkbookFactory.create(fis);
		}catch(Exception e) {
			//System.out.println(e);
		}
		Sheet sheet = wrkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		dataFromExcel=new String[rowCount+1][colCount];
                                                                                                                                                                                                                                                                                                         		for(int i=0;i<rowCount+1;i++){
			for(int j=0;j<colCount;j++){
				try {
					dataFromExcel[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				catch(Exception e) {
					//System.out.println(dataFromExcel[i][j]+"\nRow value: "+i+"\nColumn value: "+j+"\n"+rowCount+"\n"+colCount+"\n"+"Problem parsing excel sheet");
					e.printStackTrace();
				}
			}
		}
		return dataFromExcel;
	}
}
