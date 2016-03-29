package Main;

import View.View;

public class Main {

	public static void main(String[] args){ 
		//View v = new View();
		System.out.println(greet("Fucker"));
		
	}
	
    public static String greet(String yourName) {
    	String name = "Marwin";
       //return String.format("Hi %s, my name is %s", name, yourName);
        
        
        int month = 8;
        String monthString;
        switch (month/2) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
    
        return null;
    }
}
