package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;


public class TestUtil extends TestBase{

	public static long implicit_wait=30;
	public static long pageLoad=20;
	
	
	public static String TestDATA_SHEET_PATH="/Users/diksha/eclipse-workspace/FreeCRMTest/src/main/java/com/qa/testdata/FreeCrmTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
	    FileInputStream file;
	    try {
	        file = new FileInputStream(TestDATA_SHEET_PATH);
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException("Excel file not found at path: " + TestDATA_SHEET_PATH, e);
	    }

	    try {
	        book = WorkbookFactory.create(file);
	    } catch (IOException e) {
	        throw new RuntimeException("Failed to create workbook: " + e.getMessage(), e);
	    }

	    sheet = book.getSheet(sheetName);
	    if (sheet == null) {
	        throw new RuntimeException("sheet '" + sheetName + "' not found in Excel file.");
	    }

	    int rows = sheet.getLastRowNum();
	    int cols = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        for (int k = 0; k < cols; k++) {
	            data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	        }
	    }

	    return data;
	}
	
	
}
