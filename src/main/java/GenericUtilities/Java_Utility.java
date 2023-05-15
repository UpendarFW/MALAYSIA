package GenericUtilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {

	public int getRandomNumber() {
		Random ran=new Random();
		int r=ran.nextInt(1000);
		return r;
	}
	
	public String getDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	public String getDatein_Format() {
		Date d=new Date();
		String dateArr[]=d.toString().split(" ");
		String date=dateArr[2];
		String month=dateArr[1];
		String year=dateArr[5];
		String time=dateArr[3].replace(":","-");
		String day=dateArr[0];
		
		String result=date+" "+month+" "+year+" "+" "+time+" "+day;
		
		return result;
				
		
	}
}
