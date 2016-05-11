/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 9 <br />
 * Exercise: 5 <br />
 * Description: Gregorian Calendar <br />
 * Due: 3/14/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

/*
(Use the GregorianCalendar class) Java API has the GregorianCalendar class
in the java.util package, which you can use to obtain the year, month, and day of a
date. The no-arg constructor constructs an instance for the current date, and the methods
get(GregorianCalendar.YEAR), get(GregorianCalendar.MONTH),
and get(GregorianCalendar.DAY_OF_MONTH) return the year, month, and day.
Write a program to perform two tasks:
	* Display the current year, month, and day.
	* The GregorianCalendar class has the setTimeInMillis(long), which
can be used to set a specified elapsed time since January 1, 1970. Set the value
to 1234567898765L and display the year, month, and day.
 */

import java.util.GregorianCalendar;
public class C9E5GregorianCalender {

	public static void main(String[] args) {
		
		//Data members
		String[] months = {"January", "February", "March", "April", "May", "June", "July",
						   "August", "September", "October", "November", "December"};
		final long TIME = 1234567898765L;					//Time elapsed in milliseconds since Jan 1, 1970
		GregorianCalendar date = new GregorianCalendar();	//Initialize to current date
		
		//Program Description
		System.out.println("The follwing program shows you the current date");
		System.out.println("Then it shows the date after an elapsed time of "+
						   "\n1234567898765 milliseconds starting at Jan 1, 1970\n");
		
		//Display current date
		System.out.println("Current Date:");
		System.out.println("-------------");
		System.out.println("Month: " + months[date.get(GregorianCalendar.MONTH)]);
		System.out.println("Day: " + date.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println("Year: " + date.get(GregorianCalendar.YEAR));
		
		//Set time to 1234567898765 milliseconds past Jan 1, 1970
		date.setTimeInMillis(TIME);
		
		//Display new date from elapsed time
		System.out.println("\nDate 1234567898765 milliseconds after 1/1/1970:");
		System.out.println("-----------------------------------------------");
		System.out.println("Month: " + months[date.get(GregorianCalendar.MONTH)]);
		System.out.println("Day: " + date.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println("Year: " + date.get(GregorianCalendar.YEAR));
		

	}

}
