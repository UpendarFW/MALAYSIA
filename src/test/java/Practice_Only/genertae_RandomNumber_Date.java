package Practice_Only;

import GenericUtilities.Java_Utility;

public class genertae_RandomNumber_Date {
public static void main(String[] args) {
	
	
	Java_Utility j=new Java_Utility();
	int random=j.getRandomNumber();
	
	System.out.println(random);
	
	String date=j.getDate();
	
	System.out.println(date);
	
	String date1=j.getDatein_Format();
	
	System.out.println("Formatted Date  :"+date1);
}
}
