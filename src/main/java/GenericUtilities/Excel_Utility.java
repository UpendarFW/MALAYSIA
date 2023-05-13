package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class Excel_Utility {

	
	public String getExcelFileData(String SHEETNAME,int Rownumber,int Cellnumber) throws Throwable {
		
		FileInputStream fis=new FileInputStream(IConstant_Utility.ExcelFileLocation);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		Row r=sh.getRow(Rownumber);
		Cell c=r.getCell(Cellnumber);
		
		String value=c.getStringCellValue();
		
		return value;
	}
	
	public void writeDataintoExcel(String SHEETNAME,int rowNum,int cellNum,String cellValue) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.ExcelFileLocation);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		Row r=sh.createRow(rowNum);
		Cell c=r.createCell(cellNum);
		c.setCellValue(cellValue);
		
		FileOutputStream fos=new FileOutputStream(IConstant_Utility.ExcelFileLocation);
		book.write(fos);
		
		System.out.println(cellValue+"--->"+"Added Sucessfully");
		
		book.close();
	}
	
	public Object[][] readMultipleData(String SHEETNAME) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.ExcelFileLocation);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
	}
}
