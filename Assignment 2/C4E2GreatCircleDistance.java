/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 4 <br />
 * Exercise: 2 <br />
 * Description: Input two coordinates and find the great circle distance <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

 /*
The great circle distance is the distance between two points on the surface of a sphere. Let (x1, y1) and (x2, y2) 
be the geographical latitude and longitude of two points. The great circle distance between the two points can be 
computed using the following formula:

	d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))

Write a program that prompts the user to enter the latitude and longitude of two points on the earth in degrees and 
displays its great circle distance. The average earth radius is 6,371.01 km. Note that you need to convert the degrees 
into radians using the Math.toRadians method since the Java trigonometric methods use radians. The latitude and 
longitude degrees in the formula are for north and west. Use negative to indicate south and east degrees. Here is a sample run:

	Enter point 1 (latitude and longitude) in degrees: 39.55 -116.25
	Enter point 2 (latitude and longitude) in degrees: 41.5 87.37
	The distance between the two points is 10691.79183231593 km
  */

import java.util.Scanner; //Include Scanner library
import java.lang.Math;	  //Include Math library for toRadians, sin, cos, and arccos

public class C4E2GreatCircleDistance {

	public static final double RADIUS = 6371.01; //Radius of Earth, kept constant
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	// Scanner object 'input' created
		
		double lat1, long1;		//Variables to hold coordinates of Point 1
		double lat2, long2;
		int repeatInt = 1;
		double distance;
		
		//Program description
		System.out.println("This program allows you to enter the latitude and longitude in degrees for two coordinates on earth");
		System.out.println("It will then calculate the Great Circle Distance between the two");
		System.out.println("North and West coordinates are positive, South and East are negative");
		
		while(repeatInt == 1)
		{
			//Prompt user input
			System.out.print("\nEnter point 1 (latitude and longitude) in degrees: ");
			lat1 = input.nextDouble();
			long1 = input.nextDouble();
			System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
			lat2 = input.nextDouble();
			long2 = input.nextDouble();
			
			//Echo user input
			System.out.println("\nYour coordinates:");
			System.out.println("-----------------");
			System.out.println("Point 1 = ("+ lat1 +", "+ long1 +")");
			System.out.println("Point 2 = ("+ lat2 +", "+ long2 +")");
			
			//Calculation d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
			distance = RADIUS * Math.acos(Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) 
							  			+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
							  			* Math.cos(Math.toRadians(long1 - long2)));
			
			//Output
			System.out.println("The Great Circle Distance between Point 1 and Point 2 = "+ distance +" km\n");
			System.out.print("Want to go again (Enter 1 for yes or 0 for no): ");
			repeatInt = input.nextInt();
		}
		
	}
	
	
}
	
