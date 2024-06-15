package Utilities;
 
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtilities {

	public static FileInputStream fIn;

	public static XSSFWorkbook outBook;

	public static XSSFSheet outSheet;

	public static XSSFRow outRow;

	public static XSSFCell outCell;

	public static void createExcelFile() throws IOException

	{

		String file = System.getProperty("user.dir") + "\\excel\\excelOutputFile.xlsx";

		FileOutputStream fOut = new FileOutputStream(file);

		XSSFWorkbook excelBook = new XSSFWorkbook();

		XSSFSheet sheet1 = excelBook.createSheet("upcomingBikes");

		XSSFSheet sheet2 = excelBook.createSheet("usedCars");

		XSSFSheet sheet3 = excelBook.createSheet("errorMsg");

		XSSFRow sheet1HeadRow = sheet1.createRow(0);

		XSSFRow sheet2HeadRow = sheet2.createRow(0);

		XSSFRow sheet3HeadRow = sheet3.createRow(0);


		XSSFCell bikeNumCell = sheet1HeadRow.createCell(0);

		bikeNumCell.setCellValue("No.");

		XSSFCell bikeNameCell = sheet1HeadRow.createCell(1);

		bikeNameCell.setCellValue("Bike Name");

		XSSFCell bikePriceCell = sheet1HeadRow.createCell(2);

		bikePriceCell.setCellValue("Expected Price");

		XSSFCell bikeLaunchCell = sheet1HeadRow.createCell(3);

		bikeLaunchCell.setCellValue("Expected Launch Date");

		XSSFCell carNumCell = sheet1HeadRow.createCell(0);

		bikeNumCell.setCellValue("No.");

		XSSFCell carNameCell = sheet2HeadRow.createCell(1);

		carNameCell.setCellValue("Car Name");

		XSSFCell carPriceCell = sheet2HeadRow.createCell(2);

		carPriceCell.setCellValue("Car Price");

		XSSFCell errorMsgCell = sheet3HeadRow.createCell(0);

		errorMsgCell.setCellValue("Error Msg");


		excelBook.write(fOut);

		excelBook.close();

		fOut.close();

	}

	public static void updateExcel(String data, String sheetName, int rowNum, int colNum) throws IOException

	{

		String file = System.getProperty("user.dir") + "\\excel\\excelOutputFile.xlsx";

		fIn = new FileInputStream(file);

		outBook = new XSSFWorkbook(fIn);

		outSheet = outBook.getSheet(sheetName);

		outRow = outSheet.getRow(rowNum);

		if(outRow == null)

		{

			outRow = outSheet.createRow(rowNum);

		}

		outCell = outRow.createCell(colNum);

		outCell.setCellValue(data);

		FileOutputStream excelOut = new FileOutputStream(file);

		outBook.write(excelOut);

		outBook.close();

		fIn.close();

		excelOut.close();

	}

}