/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 3 <br />
 * Exercise: 23 <br />
 * Description: Is a coordinate inside the Rectangle <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

 // Write a program that prompts the user to enter the center coordinates of a Rectangle as well as its width and height.
 // Ask the user to enter a point (x, y) and check whether the point is within the Rectangle they specified.

import java.util.Scanner; //Include Scanner library

public class C3E23InsideRectangle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Scanner object 'input' created
		
		double centerX, centerY, width, height; // Rectangle position and size variables
		double pointX, pointY;					// Coordinate variables
		int againRect = 1;						// Variable for repeating loop of entire function
		int againPoint = 1;						// Variable for repeating just the coordinate loop
		
		//Program description
		System.out.println("This program allows you to define a rectangles position and size, "
						 + "then enter a coordinate to see if they overlap.\n");
		
		//Repeat defining position and size of Rectangle
		while(againRect == 1)
		{
			againPoint = 1; // Reset so Point loop can run
					
			//Prompting user to enter coordinates for center of circle
			System.out.println("Define the Rectangle's Center.");
			System.out.print("Enter x coordinate: ");
			centerX = input.nextDouble();
			System.out.print("Enter y coordinate: ");
			centerY = input.nextDouble();
			
			//Prompting user to enter
			System.out.println("Define the Rectangle's Size. (Must be positive values)");
			System.out.print("Enter the width: ");
			width = input.nextDouble();
			System.out.print("Enter the height: ");
			height = input.nextDouble();
			
			//Validate that user entered POSITIVE values for dimensions
			if(width < 0 || height < 0)
			{
				System.out.println("Invaild input for width and/or height of Rectangle! Try again.\n");
				againPoint = 0;
			}
			
			//Repeat entering a point with same Rectangle
			while(againPoint == 1)
			{
				//Echoing the users input
				System.out.println("\nYour Rectangle:");
				System.out.println("---------------");
				System.out.println("Center: ("+centerX+", "+centerY+")");
				System.out.println("Width: "+width);
				System.out.println("Height: "+height);

				//Prompting user to enter a point to test if inside or outside of rectangle
				System.out.println("\nTest a point to see if it lies within the Rectangle.");
				System.out.print("Enter x value of point: ");
				pointX = input.nextDouble();
				System.out.print("Enter y value of point: ");
				pointY = input.nextDouble();
	
				//Testing if point is in rectangle
				if(pointX <= centerX + width/2 && // Right bound
				   pointX >= centerX - width/2 && // Left bound
				   pointY <= centerY + height/2 && // Top bound
				   pointY >= centerY - height/2)	  // Bottom bound
				{
					System.out.println("\nPoint ("+pointX+", "+pointY+") is inside the rectangle!!! ");
				}
				else
				{
					System.out.println("\nPoint ("+pointX+", "+pointY+") is NOT inside the rectangle! :( ");
				}
				
				//Ask user if they would like to repeat of exit
				System.out.println("\nEnter '0' to exit"
							   + "\nEnter '1' to test another point with the SAME rectangle"
							   + "\nEnter '2' to create another rectangle");
				againPoint = input.nextInt();
				if(againPoint == 0) {againRect = 0;} //Stop Rectangle loop if user enters '0'
			} //end Point loop
		}// end Rectangle loop
	}// end main()
}// end class
