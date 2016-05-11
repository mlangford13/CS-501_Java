/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 2 <br />
 * Exercise: 15 <br />
 * Description: Distance between two points <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

import java.util.Scanner; //Import Scanner class

public class C2E15DistanceFormula 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in); // Scanner object 'input' created
		double [] x = new double [2];
		double [] y = new double [2];
		double distance = -1.0; //Distance can't be negative, so a '-1.0' output would signal an error
		
		//Program description and instructions for user
		System.out.println("The following program allows you to find the distance between two points (x1,y1) and (x2,y2)");
		System.out.println("Coordinates can be positive or negative and decimals or integers and are seperated by a space");
		System.out.println("Press the 'Enter' key once both x and y values are given.\n");
		
		//Loop to take in the x and y values for the two coordinates
		for(int i = 0; i < x.length; i++)
		{
			System.out.print("Enter x"+(i+1)+" and y"+(i+1)+": ");
			x[i] = input.nextDouble();
			y[i] = input.nextDouble();
		}
		//Sum of the squared differences
		distance = Math.pow((x[1] - x[0]), 2) + Math.pow((y[1] - y[0]), 2); 
		
		// Square root of the sum of squared differences ; Final Answer
		distance = Math.pow(distance, 0.5); 
		
		//Echoing user input
		System.out.println("\nCoordinate 1: ("+x[0]+", "+y[0]+")");
		System.out.println("Coordinate 2: ("+x[1]+", "+y[1]+")");
		
		//Displaying final answer
		System.out.println("\nThe distance between the two points is: "+distance);
		
	}

}
