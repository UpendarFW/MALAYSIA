package Practice_Only;

import GenericUtilities.Excel_Utility;

public class WriteData_Excel {

	public static void main(String[] args) throws Throwable {
		
	
		Excel_Utility eu=new Excel_Utility();
		eu.writeDataintoExcel("Contacts",10, 0,"Om Namah Shivaya");
	}
}
