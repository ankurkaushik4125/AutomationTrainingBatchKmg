package Excelutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
public String xlfilepath;
public FileInputStream fis = null;
public FileOutputStream fos = null;
private XSSFWorkbook workbook = null;
private XSSFSheet sheet = null;
private XSSFRow row = null;
private XSSFCell cell = null;


public Xls_Reader(String xlfilepath) 
{
	this.xlfilepath = xlfilepath;
	try {
		fis = new FileInputStream(xlfilepath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		fis.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
// returns the row count in a sheet

//method to read total row count in sheet
	 public int getRowCount(String sheetName) 
	 {
		 sheet= workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum()+1;
		 return rowCount;
	 }
	// method to read  total coloum in sheet
		 public int getCellCount(String sheetName) 

		 {
			 sheet= workbook.getSheet(sheetName);
			 row = sheet.getRow(0);
			 int cellCount=row.getLastCellNum()+1;
			 return cellCount;
		 }


// returns the data from a cell
		 public String getCellData(String sheetName, int colNum, int rowNum)
		 {
		 	try {
		 		sheet = workbook.getSheet(sheetName);
		 		row = sheet.getRow(rowNum);
		 		cell = row.getCell(colNum);
		 		
		 		DataFormatter df = new DataFormatter();
		 String celldata = df.formatCellValue(cell).trim();
		 return celldata;

		 	 
		 	 }
		 	catch (Exception e)
		 	{
		 		e.printStackTrace();
		 		return "row " + rowNum +" Or Coloum " + colNum+ "Doesn't exit in excel ";
		 	}
		 	 	}



// returns true if data is set successfully else false

 public boolean setCellData(String sheetName, String colName, int rowNum, String value)
 {
      try
 {
		         int col_Num = -1;
		         sheet = workbook.getSheet(sheetName);

		         row = sheet.getRow(0);
		         for (int i = 0; i < row.getLastCellNum(); i++) {
		             if (row.getCell(i).getStringCellValue().trim().equals(colName))
		             {
		                 col_Num = i;
		             }
		         }

		         sheet.autoSizeColumn(col_Num);
		         row = sheet.getRow(rowNum - 1);
		         if(row==null)
		             row = sheet.createRow(rowNum - 1);

		         cell = row.getCell(col_Num);
		         if(cell == null)
		             cell = row.createCell(col_Num);

		         cell.setCellValue(value);
		        
		         fos = new FileOutputStream(xlfilepath);
		         workbook.write(fos);
		         fos.close();
		         
		     }
		     catch (Exception ex)
		     {
		         ex.printStackTrace();
		         return  false;
		     }
		     return true;
		 }

 public boolean setCellData(String sheetName, int colNumber, int rowNum, String value)
 {
     try
     {
         sheet = workbook.getSheet(sheetName);
         row = sheet.getRow(rowNum);
         if(row==null)
             row = sheet.createRow(rowNum);

         cell = row.getCell(colNumber);
         if(cell == null)
             cell = row.createCell(colNumber);

         cell.setCellValue(value);

         fos = new FileOutputStream(xlfilepath);
         workbook.write(fos);
         fos.close();
     }
     catch (Exception ex)
     {
         ex.printStackTrace();
         return  false;
     }
     return true;
 }

 public String getCellData(String sheetName, String colName, int rowNum)
 {
 	try {
 		int colNum=-1;
 		sheet = workbook.getSheet(sheetName);
 		row = sheet.getRow(0);
 		
 		for (int i=0; i<row.getLastCellNum();i++)
 		{
 			
 			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
 {
 				colNum = i;
 	}
 		}
 	row = sheet.getRow(rowNum);
 	cell = row.getCell(colNum);

 	

 	
 	DataFormatter df = new DataFormatter();
 	String celldata = df.formatCellValue(cell).trim();
 	return celldata;
 	


 	/*if (cell.getCellType() == CellType.STRING)
 		return cell.getStringCellValue();
 	
 else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
 	{
 String cellValue=String.valueOf(cell.getNumericCellValue());

    if (DateUtil.isCellDateFormatted(cell))
 {
 DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
 Date date = cell.getDateCellValue();
 cellValue = df.format(date);
 	
 }
 return cellValue;
 }
 	
  else if (cell.getCellType() ==CellType.BLANK)
  {
 	return cell.getRawValue();
  }       else
 	 
  	return String.valueOf(cell.getBooleanCellValue());
  
 		*/
 	}
 	catch (Exception e)
 	{
 		e.printStackTrace();
 		return "row " + rowNum +" Or Coloum " + colName+ "Doesn't exit in excel ";
 	}
 	
 	
 	
 	}

 


// returns true if sheet is created successfully else false
public boolean addSheet(String sheetname) {

	FileOutputStream fileOut;
	try {
		workbook.createSheet(sheetname);
		fileOut = new FileOutputStream(xlfilepath);
		workbook.write(fileOut);
		fileOut.close();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

// returns true if sheet is removed successfully else false if sheet does
// not exist
public boolean removeSheet(String sheetName) {
	int index = workbook.getSheetIndex(sheetName);
	if (index == -1)
		return false;

	FileOutputStream fileOut;
	try {
		workbook.removeSheetAt(index);
		fileOut = new FileOutputStream(xlfilepath);
		workbook.write(fileOut);
		fileOut.close();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

// returns true if column is created successfully
public boolean addColumn(String sheetName, String colName) {
	// System.out.println("**************addColumn*********************");

	try {
		fis = new FileInputStream(xlfilepath);
		workbook = new XSSFWorkbook(fis);
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		XSSFCellStyle style = workbook.createCellStyle();
		// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		sheet = workbook.getSheetAt(index);

		row = sheet.getRow(0);
		if (row == null)
			row = sheet.createRow(0);

		// cell = row.getCell();
		// if (cell == null)
		// System.out.println(row.getLastCellNum());
		if (row.getLastCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());

		cell.setCellValue(colName);
		cell.setCellStyle(style);

		fos = new FileOutputStream(xlfilepath);
		workbook.write(fos);
		fos.close();

	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}

	return true;

}

// removes a column and all the contents
public boolean removeColumn(String sheetName, int colNum) {
	try {
		if (!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(xlfilepath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		XSSFCreationHelper createHelper = workbook.getCreationHelper();
		// style.setFillPattern(XSSFCellStyle.NO_FILL);
		for (int i = 0; i < getRowCount(sheetName); i++) {
			row = sheet.getRow(i);
			if (row != null) {
				cell = row.getCell(colNum);
				if (cell != null) {
					cell.setCellStyle(style);
				
					row.removeCell(cell);
				}
			}
		}
		fos = new FileOutputStream(xlfilepath);
		workbook.write(fos);
		fos.close();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;

}

// find whether sheets exists
public boolean isSheetExist(String sheetName) {
	int index = workbook.getSheetIndex(sheetName);
	if (index == -1) {
		index = workbook.getSheetIndex(sheetName.toUpperCase());
		if (index == -1)
			return false;
		else
			return true;
	} else
		return true;
}

// returns number of columns in a sheet
public int getColumnCount(String sheetName) {
	// check if sheet exists
	if (!isSheetExist(sheetName))
		return -1;

	sheet = workbook.getSheet(sheetName);
	row = sheet.getRow(0);

	if (row == null)
		return -1;

	return row.getLastCellNum();

}
public int getCellRowNum(String sheetName, String colName, String cellValue) {

	for (int i = 2; i <= getRowCount(sheetName); i++) {
		if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
			return i;
		}
	}
	return -1;

}

}


