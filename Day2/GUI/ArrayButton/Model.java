package application;

import java.util.Calendar;
import java.util.Scanner;

public class Model {
	Scanner scan = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	String monthCode;
	int currentMonth = cal.get(Calendar.MONTH);
	
	
	
	public void setMonthCode(int currentMonth) {
		switch (currentMonth) {
		case 0:monthCode = "January";break;
		case 1:monthCode = "February";break;
		case 2:monthCode = "March";break;
		case 3:monthCode = "April";break;
		case 4:monthCode = "May";break;
		case 5:monthCode = "June";break;
		case 6:monthCode = "July";break;
		case 7:monthCode = "August";break;
		case 8:monthCode = "September";break;
		case 9:monthCode = "October";break;
		case 10:monthCode = "November";break;
		case 11:monthCode = "December";break;
		default:monthCode = "Invalid Month";break;
		}
	}
	
	public String getScheduleDate(){
		String year = Integer.toString(Calendar.YEAR) + "년";
		String month = Integer.toString(Calendar.MONTH) + "월";
		String day = Integer.toString(Calendar.DATE) + "일";
		
		return year + month + day;
	}	
	
}
