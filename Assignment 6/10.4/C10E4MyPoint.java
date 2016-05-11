/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 10 <br />
 * Exercise: 4 <br />
 * Description: Create class MyPoint to hold x and y coordinates <br />
 * Due: 4/11/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

/*
 10.4
The MyPoint class) Design a class named MyPoint to represent a point with
x- and y-coordinates. The class contains:
 	* The data fields x and y that represent the coordinates with getter
	methods.
 	* A no-arg constructor that creates a point (0, 0).
 	* A constructor that constructs a point with specified coordinates.
 	* A method named distance that returns the distance from this point to a
	specified point of the MyPoint type.
 	* A method named distance that returns the distance from this point to
	another point with specified x- and y-coordinates.
 */

import java.util.Scanner;
public class C10E4MyPoint {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declaring data types
		double x, y;					//Parameters of MyPoint object
		int repeat = 1;					//To allow user to continue testing
		MyPoint point1;					//MyPoint objects to test
		MyPoint point2 = new MyPoint();	//Default constructor
		
		//Program description
		System.out.println("The following program allows you to create MyPoint objects");
		System.out.println("and find the distance between them.");
		
		while(repeat != 0)
		{
			//Prompt user input
			System.out.println("\nPoint1:");
			System.out.println("-------");
			System.out.print("Enter x: ");
			x = input.nextDouble();
			System.out.print("Enter y: ");
			y = input.nextDouble();
			
			//Two parameter constructor
			point1 = new MyPoint(x,y);
			
			//Prompt user input
			System.out.println("\nPoint2:");
			System.out.println("-------");
			System.out.print("Enter x: ");
			x = input.nextDouble();
			System.out.print("Enter y: ");
			y = input.nextDouble();
			
			//Using set methods
			point2.setX(x);
			point2.setY(y);
			
			//Echoing user input:
			System.out.print("\n\nPoint1: ");
			point1.print();
			System.out.print("\nPoint2: ");
			point2.print();
			
			//Display results
			System.out.println("\nDistance between points:");
			System.out.println(" - 'distance(MyPoint point)' = \t\t"+point1.distance(point2));
			System.out.println(" - 'distance(double x, double y)' = \t"+point1.distance(point2.getX(), point2.getY()));
			
			//Check if user wants to go again
			System.out.print("\nEnter 0 to exit; any other integer to go again: ");
			repeat = input.nextInt();
		}
	
	}

}
