/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 10 <br />
 * Exercise: 13 <br />
 * Description: Create class MyRectangle <br />
 * Due: 4/11/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
 10.13
(Geometry: the MyRectangle2D class) Define the MyRectangle2D class that
contains:
 	* Two double data fields named x and y that specify the center of the rectangle
	with getter and setter methods. (Assume that the rectangle sides are
	parallel to x- or y- axes.)
 	* The data fields width and height with getter and setter methods.
 	* A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and
	1 for both width and height.
 	* A constructor that creates a rectangle with the specified x, y, width, and
	height.
	* A method getArea() that returns the area of the rectangle.
	* A method getPerimeter() that returns the perimeter of the rectangle.
	* A method contains(double x, double y) that returns true if the
	specified point (x, y) is inside this rectangle (see Figure 10.24a).
	* A method contains(MyRectangle2D r) that returns true if the specified
	rectangle is inside this rectangle (see Figure 10.24b).
	* A method overlaps(MyRectangle2D r) that returns true if the specified
	rectangle overlaps with this rectangle (see Figure 10.24c).
	* A method abut(MyRectangle2D r) that returns true if the specified
	rectangle shares a boundary with this rectangle
	* A method distinct(MyRectangle2D r) that returns true if the specified
	rectangle is not within the bounds nor touching this rectangle
*/
import java.util.Scanner;
public class C10E13MyRectangle2D {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);
		
		//Declaring data types
		double width, height;							//Parameters of rectangle object
		double x, y;
		int outLoop = 2, inLoop = 1;					//To allow user to continue testing
		MyRectangle2D outRect = new MyRectangle2D();	//First Rectangle object to test
		MyRectangle2D inRect = new MyRectangle2D();		//Second Rectangle object
		
		//Program description
		System.out.println("This program allows you to define two rectangles by their width, height, and center coordinate");
		System.out.println("You are then told whether they are distinct, abut, overlap, or contain one another.");
		
		while(outLoop != 0)
		{
			inLoop = 1; //Reset so loop for Rectangle 2 can run
			
			//Prompt user input
			System.out.println("\nRectangle 1");
			System.out.println("-----------");
			System.out.print("Enter center point (x,y): ");
			x = input.nextDouble();
			y = input.nextDouble();
			System.out.print("Enter width: ");
			width = input.nextDouble();
			System.out.print("Enter height: ");
			height = input.nextDouble();
			
			try {
				outRect = new MyRectangle2D(width,height,x,y);
			}
			catch(Exception e) {
				System.out.println("--- FAILED --- " +
						"\noutRect = new MyRectangle2D(width,height,x,y);" +
						"\nthrew Exception w/ message:\n" +
						e.getMessage());
				System.out.println("--- TRY AGAIN --- ");
				inLoop = 0;
			}
			while(inLoop == 1)
			{
				//Echo Rectangle 1
				System.out.println("\nRectangle 1: "+ outRect.toString());
				
				//Prompt user input for Rectangle 2
				System.out.println("\nRectangle 2");
				System.out.println("-----------");
				System.out.print("Enter center point (x,y): ");
				x = input.nextDouble();
				y = input.nextDouble();
				System.out.print("Enter the width: ");
				width = input.nextDouble();
				System.out.print("Enter the height: ");
				height = input.nextDouble();				
				
				try {
					inRect = new MyRectangle2D(width,height,x,y);
					
					//if it gets here, no exception was thrown
					//Echo user input
					System.out.println("\nRectangle 1: "+ outRect.toString());
					System.out.println("Rectangle 2: "+ inRect.toString());
					
					System.out.println("\nTesting: ");
					System.out.println("--------");
					
					//Check if either rectangle CONTAINS the other
					if(outRect.contains(inRect))
						System.out.println("\t- Rectangle 1 DOES contain Rectangle 2!");
					else if(inRect.contains(outRect))
						System.out.println("\t- Rectangle 2 DOES contain Rectangle 1!");
					else
						System.out.println("\t- Neither Rectangle contains the other :(");
					
					//OVERLAP
					if(outRect.overlaps(inRect))
						System.out.println("\t- Rectangle 1 & Rectangle 2 DO overlap!");
					else
						System.out.println("\t- Rectangle 1 & Rectangle 2 DO NOT overlap :(");
					
					//ABUT
					if(outRect.abut(inRect))
						System.out.println("\t- Rectangle 1 & Rectangle 2 ARE abut!");
					else
						System.out.println("\t- Rectangle 1 & Rectangle 2 ARE NOT abut :(");
					
					//DISTINCT
					if(outRect.distinct(inRect))
						System.out.println("\t- Rectangle 1 & Rectangle 2 ARE distinct!");
					else
						System.out.println("\t- Rectangle 1 & Rectangle 2 ARE NOT distinct :(");
					
					//Ask user if they would like to repeat of exit
					System.out.println("\nEnter '0' to exit"
								   + "\nEnter '1' to test another Rectangle 2 with the SAME Rectangle 1"
								   + "\nEnter '2' to test two new Rectangles");
					inLoop = input.nextInt();
					if(inLoop == 0) { outLoop = 0; }
				}
				catch(Exception e) {
					System.out.println("--- FAILED --- " +
							"\ninRect = new MyRectangle2D(width,height,x,y);" +
							"\nthrew Exception w/ message:\n" +
							e.getMessage());
					System.out.println("--- TRY AGAIN --- ");
				}//end try-catch for Rectangle 2
			
			}//end inner loop for Rectangle 2
			
		}//end outer loop for Rectangle 1
		input.close();
	}//end main

}//end class
