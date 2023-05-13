package Practice_Only;

import GenericUtilities.File_Utility;

public class Properties_Print {

	public static void main(String[] args) throws Throwable {
		
		File_Utility pf=new File_Utility();
		String BROWSER=pf.getPropertyFile("browser");
		
		System.out.println(BROWSER);
		
String USERNAME=pf.getPropertyFile("username");
		
		System.out.println(USERNAME);
		
String PASSWORD=pf.getPropertyFile("password");
		
		System.out.println(PASSWORD);
		
	}
}
