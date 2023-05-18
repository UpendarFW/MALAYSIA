package Practice_Only;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {

	@Test
	public void readdata() {
		
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
		
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);
		
		String URL=System.getProperty("url");
		System.out.println(URL);
		
	}
}
