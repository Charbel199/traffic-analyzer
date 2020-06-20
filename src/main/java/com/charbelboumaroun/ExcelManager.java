package com.charbelboumaroun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	public static void AddToExcel(double time,String Date,int minutes) {
		try {
		String excelFilepath = "TrafficAnalysis.xlsx";
		FileInputStream fis = new FileInputStream(new File(excelFilepath));
		
        XSSFWorkbook wb = new XSSFWorkbook(fis) ;
        int sheetindex=0;
        switch(Date) {
        case "Mon":sheetindex=0;break;
        case "Tue":sheetindex=1;break;
        case "Wed":sheetindex=2;break;
        case "Thu":sheetindex=3;break;
        case "Fri":sheetindex=4;break;
        case "Sat":sheetindex=5;break;
        case "Sun":sheetindex=6;break;
        }
        
        Sheet sheet = wb.getSheetAt(sheetindex);
        
        
        int lastRow = sheet.getLastRowNum();
        int currentRow = lastRow+1;
        sheet.createRow(currentRow).createCell(0).setCellValue(time);
        sheet.getRow(currentRow).createCell(1).setCellValue(minutes);
        
        
        
        FileOutputStream fos= new FileOutputStream(excelFilepath);
        wb.write(fos);
        wb.close();
        fos.close();
        fis.close();
        
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) throws Exception {
//		String excelFilepath = "C:\\Users\\Intel\\eclipse-workspace\\GoogleMapsProj\\TrafficAnalysis.xlsx";
//		FileInputStream fis = new FileInputStream(new File(excelFilepath));
//        XSSFWorkbook wb = new XSSFWorkbook(fis) ;
//        XSSFSheet sheet = wb.getSheetAt(2);
//        sheet.createRow(0).createCell(0).setCellValue(1);
//        sheet.getRow(0).createCell(0).setCellValue((double)1.75/24);
//        sheet.createRow(1).createCell(0).setCellValue((double)15.5/24);
//        sheet.createRow(2).createCell(0).setCellValue((double)15/24);
//        FileOutputStream fos= new FileOutputStream(excelFilepath);
//        wb.write(fos);
//        wb.close();
//        fos.close();
//        fis.close();
//	}
	
	
	
}