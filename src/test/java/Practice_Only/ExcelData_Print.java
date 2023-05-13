package Practice_Only;

import GenericUtilities.Excel_Utility;

public class ExcelData_Print {

	public static void main(String[] args) throws Throwable {
		
		Excel_Utility eu=new Excel_Utility();
		String print= eu.getExcelFileData("Organizations",1,2);
		String print1= eu.getExcelFileData("Organizations",1,1);
		System.out.println(print+"-----"+print1);
	}
}
