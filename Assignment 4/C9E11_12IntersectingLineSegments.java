/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 9 <br />
 * Exercise: 11 & 12 <br />
 * Description: Finding intersection point of two line segments <br />
 * Due: 3/14/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

/*
(Algebra: 2 * 2 linear equations) Design a class named LinearEquation for a
2 * 2 system of linear equations:
		ax + by = e			ed - bf			af - ec
		cx + dy = f		x = -------		y = -------
							ad - bc			ad - bc

For Line 1 with end points: (x1,y1) (x2,y2)
		(y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1

For Line 2 with end points: (x3,y3) (x4,y4)
		(y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
 */

import java.util.Scanner;
public class C9E11_12IntersectingLineSegments {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Data members
		double x1, x2, x3, x4, y1, y2, y3, y4;	//Coordinates of 2 line end points
		int repeat = 1;
		LinearEquation helper = new LinearEquation();
		
		//Program Description and Example run
		System.out.println("The following program allows you to enter the two endpoints for two intersecting line");
		System.out.println("and will return the x and y coordinates of where they intersect\n");
	
		System.out.println(helper.toString());
		
		System.out.println("EXAMPLE:");
		helper.print();
		
		//Loop for user input of coordinates
		while(repeat != 0)
		{
			//Prompt user input
			System.out.println("\nLine 1 : First Endpoint");
			System.out.println("-----------------------");
			System.out.print("Enter x1: ");
			x1 = input.nextDouble();
			System.out.print("Enter y1: ");
			y1 = input.nextDouble();
			
			System.out.println("\nLine 1 : Second Endpoint");
			System.out.println("------------------------");
			System.out.print("Enter x2: ");
			x2 = input.nextDouble();
			System.out.print("Enter y2: ");
			y2 = input.nextDouble();
			
			System.out.println("\nLine 2 : First Endpoint");
			System.out.println("-----------------------");
			System.out.print("Enter x3: ");
			x3 = input.nextDouble();
			System.out.print("Enter y3: ");
			y3 = input.nextDouble();
			
			System.out.println("\nLine 2 : Second Endpoint");
			System.out.println("------------------------");
			System.out.print("Enter x4: ");
			x4 = input.nextDouble();
			System.out.print("Enter y4: ");
			y4 = input.nextDouble();
			
			//Echo user input
			System.out.println("\nYour coordinates:");
			System.out.println("Line 1: ("+x1+", "+y1+")\t("+x2+", "+y2+")");
			System.out.println("Line 2: ("+x3+", "+y3+")\t("+x4+", "+y4+")\n");
			
			//Test to see if the lines have an intersection
			try {
				helper = new LinearEquation(x1,y1,x2,y2,x3,y3,x4,y4);
				// if get here fpzc executed without Exception
				helper.print();
				System.out.println("The Lines intersect at ("+helper.getX()+", "+helper.getY()+")");
				System.out.println("\nEnter 0 to exit; any other integer to test another set of Lines");
				repeat = input.nextInt();
			}
			catch(Exception e){
				// if get here then setD() threw Exception e
				System.out.println(" - FAILED - " +
						"\nhelper = new LinearEquation(x1,y1,x2,y2,x3,y3,x4,y4);" +
						"\nthrew Exception w/ message:\n" +
						e.getMessage());
				System.out.println("- TRY AGAIN - ");
				//Goes back to user input after message is printed
			}// end catch
			
		}//end while
		input.close();
	}//end main

}
