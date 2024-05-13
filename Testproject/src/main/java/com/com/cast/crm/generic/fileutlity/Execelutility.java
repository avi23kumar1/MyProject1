package com.com.cast.crm.generic.fileutlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Execelutility {
public String getdataexecel(String sheetname, int rownum, int cellnum) throws Throwable
{
	FileInputStream fys=new FileInputStream("./testdata/Book2.xlsx");
	
	Workbook wb = WorkbookFactory.create(fys);

	 String k3 = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();

	wb.close();
	return k3;
		 
}
public int getrowcount(String sheetname) throws Throwable
{
FileInputStream fys=new FileInputStream("./testdata/Book2.xlsx");
	
	Workbook wb = WorkbookFactory.create(fys);
	int k8 = wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return k8;
	}
public void setdatainexecel(String sheetname, int rownum, int cellnum ,int data ) throws Throwable
{
FileInputStream fys=new FileInputStream("./testdata/Book2.xlsx");
	
	Workbook wb = WorkbookFactory.create(fys);
	wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	FileOutputStream ksm=new FileOutputStream("C:\\Users\\HP\\Desktop\\new1\\Book2.xlsx");
	wb.write(ksm);
	wb.close();
	
	
}







}
