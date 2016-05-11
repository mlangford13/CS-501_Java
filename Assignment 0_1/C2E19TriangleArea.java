/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 2 <br />
 * Exercise: 19 <br />
 * Description: Triangle Area from 3 coordinates from user input <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

import java.util.Scanner; //Import Scanner class

public class C2E19TriangleArea
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in); // Scanner object 'input' created
		
		double [] x = new double [3]; 		//Arrays to hold the x-coordinates of 3 points
		double [] y = new double [3];		//Arrays to hold the y-coordinates of 3 points
		double [] side = new double [3];	//Holds length between each point of the triangle
		double sideAverage = 0.0;			//Intermediate variable to calculate area
		double area = 0.0;
		
		//Program Description and Instructions for User
		System.out.println("The following program allows you to enter 3 coordinates and find the area of the triangle created");
		System.out.println("Coordinates can be positive or negative and decimals or integers and are seperated by a space");
		System.out.println("Press the 'Enter' key once both x and y values are given.\n");
		
		//Taking in x and y Values from User
		for(int i = 0; i < x.length; i++)
		{
			System.out.print("Enter x"+(i+1)+" and y"+(i+1)+": ");
			x[i] = input.nextDouble();
			y[i] = input.nextDouble();
		}
		
		//Calculating Length between each Coordinate 
		//Echoing User Input of Coordinate Values
		for (int i = 0; i < x.length; i++)
		{
			System.out.println("Coordinate "+(i+1)+": ("+x[i]+", "+y[i]+")"); //Echo user input for coordinate values
			
			//Calculating Side Lengths
			if((i + 1) == x.length) // For (Point 3 - Point 1)
			{
				side[i] = Math.pow((x[i] - x[0]), 2) + Math.pow((y[i] - y[0]), 2);
			}
			else // For (Point 2 - Point 1) and (Point 3 - Point 2)
			{
				side[i] = Math.pow((x[i+1] - x[i]), 2) + Math.pow((y[i+1] - y[i]), 2); 
			}
			side[i] = Math.pow(side[i], 0.5); // Final Side Length
			
			sideAverage += side[i]; //Summing the sides
		}
		
		//Divide by 2 to get Final Value for sideAverage
		sideAverage /= 2;
		
		//Set area to sideAverage for calculating part under square root sign in area equation
		area = sideAverage;
		
		//Length display and Area calculation
		for (int i = 0; i < x.length; i++)
		{
			System.out.println("Length of Side"+(i+1)+": "+side[i]); //Display Length of each side
			area *= (sideAverage - side[i]); //Calculating part under square root sign one side length at a time.
		}
		
		//Taking square root; Final Answer for Area
		area = Math.pow(area, 0.5);
		
		//Displaying Area Calculation
		System.out.println("\nThe Area of the Triangle is: "+area);
		
	}

}

