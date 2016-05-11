/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 11 <br />
 * Exercise: 1 <br />
 * Description: Create Triangle class that extends GeometricObject <br />
 * Due: 4/11/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
 11.1
(The Triangle class) Design a class named Triangle that extends
GeometricObject. The class contains:
 	* Three double data fields named side1, side2, and side3 with default
		values 1.0 to denote three sides of the triangle.
 	* A no-arg constructor that creates a default triangle.
 	* A constructor that creates a triangle with the specified side1, side2, and
		side3.
 	* The accessor methods for all three data fields.
 	* A method named getArea() that returns the area of this triangle.
 	* A method named getPerimeter() that returns the perimeter of this triangle.
	* A method named toString() that returns a string description for the triangle.
	* Validate the triangle for having sides that actually form a triangle, that is, 
		the sum of any two sides must be less than the third.
For the formula to compute the area of a triangle, see Programming Exercise 2.19.
The toString() method is implemented as follows:
	return "Triangle: side1 = " + side1 + " side2 = " + side2 +
		   " side3 = " + side3;
Write a test program that prompts the user to enter three
sides of the triangle, a color, and a Boolean value to indicate whether the triangle
is filled. The program should create a Triangle object with these sides and set
the color and filled properties using the input. The program should display
the area, perimeter, color, and true or false to indicate whether it is filled or not.

12.5
(IllegalTriangleException) Programming Exercise 11.1 defined the
Triangle class with three sides. In a triangle, the sum of any two sides is
greater than the other side. The Triangle class must adhere to this rule.
Create the IllegalTriangleException class, and modify the constructor
of the Triangle class to throw an IllegalTriangleException object if a
triangle is created with sides that violate the rule, as follows:
*/
import java.util.Scanner;
public class C11E1TriangleClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declaring data types
		double side1, side2, side3;		//Parameters for length of sides
		String color;					//Color of triangle object
		boolean filled;					//True to fill with color
		int filledInt;
		int repeat = 1;					//To allow user to continue testing
		Triangle triangle = new Triangle();	//Triangle object to test

		//Program description
		System.out.println("The following program allows you to test the 'Triangle' "
						  +"class which extend 'GeometricObjects'. ");
		System.out.println("You will enter values for each side length, color and "
						  +"whether or not to fill the triangle\n"
						  +"The program then displays perimeter and area of your Triangle object");
		
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter side1 length: ");
			side1 = input.nextDouble();
			System.out.print("Enter side2 length: ");
			side2 = input.nextDouble();
			System.out.print("Enter side3 length: ");
			side3 = input.nextDouble();
			System.out.print("Enter color: ");
			color = input.next();
			System.out.print("Enter '1' to set as filled (any other integer to not fill): ");
			filledInt = input.nextInt();
			filled = (filledInt == 1); //Sets filled to true if user entered a 1
			
			//Testing for valid input by user
			try {
				triangle = new Triangle(side1,side2,side3,color,filled);
				System.out.println("\nYour Triangle(toString): "+triangle.toString()+"\n");
				triangle.print();
				System.out.print("\nEnter 0 to exit; any other integer to test another Triangle: ");
				repeat = input.nextInt();
			}
			catch(IllegalTriangleException e) {
				System.out.println("--- FAILED ---\n" + e + "\n--- TRY AGAIN ---");
				//Goes back to user input after message is printed
			}
		}
	}

}
