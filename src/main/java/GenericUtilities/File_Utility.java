package GenericUtilities;

import java.io.FileInputStream;

import java.util.Properties;

public class File_Utility {

	
	public String getPropertyFile(String key) throws Throwable {
	
		FileInputStream fis=new FileInputStream(IConstant_Utility.ProperyfileUtility);
	    Properties p=new Properties();
	    p.load(fis);
	 String value=   p.getProperty(key);
	 
	 return value;
	}
}
