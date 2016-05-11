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
*/
public class Triangle extends GeometricObject 
{
//------------------------
//Parameter Decelerations
//------------------------
	private double side1, side2, side3;
	private String errorMessage = "";
	
//------------	
//Constructors
//------------
	Triangle() { side1 = side2 = side3 = 1.0; }
	Triangle(double side1, double side2, double side3) throws IllegalTriangleException
	{
		if(!isValidTriangle(side1,side2,side3))
			throw new IllegalTriangleException(side1,side2,side3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException
	{
		if(!isValidTriangle(side1,side2,side3))
			throw new IllegalTriangleException(side1,side2,side3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		setColor(color);
		setFilled(filled);
	}
	
//------------------------
//Get (accessor) functions:
//------------------------
	public double getSide1() { return side1; }
	public double getSide2() { return side2; }
	public double getSide3() { return side3; }
	public String getErrorMessage() { return errorMessage; }
	
//------------------------
// Set (mutator) functions:
//------------------------
	public void setSide1(double side1) throws IllegalTriangleException
	{
		if(!isValidTriangle(side1,side2,side3))
			throw new IllegalTriangleException(side1,side2,side3);
		this.side1 = side1;
	}
	public void setSide2(double side2) throws IllegalTriangleException
	{
		if(!isValidTriangle(side1,side2,side3))
			throw new IllegalTriangleException(side1,side2,side3);
		this.side2 = side2;
	}
	public void setSide3(double side3) throws IllegalTriangleException
	{
		if(!isValidTriangle(side1,side2,side3))
			throw new IllegalTriangleException(side1,side2,side3);
		this.side3 = side3;
	}
	
//------------------------
//isValid Method:
//------------------------
	public boolean isValidTriangle(double side1, double side2, double side3)
	{
		if(side1+side2 > side3 && side2+side3 > side1 && side1+side3 > side2)
			return true;
		else
		{
			errorMessage = "Invalid Input: Side lengths must be greater than zero and "
					+ "\nthe sum of any two sides must be greater than the third";
			return false;
		}
	}
	
//-----------------------------
//Special Calculations Methods:
//-----------------------------
	public double getArea()
	{
		 double sideSum = (side1+side2+side3)/2;
		 double area = sideSum;
		 area *= (sideSum - side1) * (sideSum - side2) * (sideSum - side3);
		 area = Math.pow(area,0.5);
		 return area;
	}
	public double getPerimeter()
	{
		 return side1+side2+side3;
	}
	
//----------------------------------
//Standard Methods from Object class
//----------------------------------
	public void print() 
	{
		System.out.println("Triangle:");
		System.out.println("---------");
		System.out.println("Side1     = " + side1);
		System.out.println("Side2     = " + side2);
		System.out.println("Side3     = " + side3);
		System.out.println("Color     = " + getColor());
		System.out.println("Filled    = " + isFilled());
		System.out.println("Area      = " + getArea());
		System.out.println("Perimeter = " + getPerimeter());
	}
	public String toString() 
	{
		return "[Side1 = " + side1 + " : Side2 = " + side2 + " : Side3 = "+ side3 +"]";
	}
	public boolean equals(Object o)
	{
		// check for null parameter
		if( o == null) return false;
		
		// check for object type
		String s = o.getClass().getName(); // method to get class name
		if( !s.equals("Triangle")) return false;
		
		// check for equivalent parameter values
		Triangle b = (Triangle) o;	// cast unspecified object to
								// Triangle object in order to be able
								// to use Triangle get() functions
		if(	side1 != b.getSide1()) return false;
		if(	side2 != b.getSide2()) return false;
		if(	side3 != b.getSide3()) return false;
		
		return true;
	}
}
