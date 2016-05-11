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
public class MyPoint 
{
//------------------------
//Parameter Decelerations
//------------------------
	private double x = 0.0;
	private double y = 0.0;
	private String errorMessage = "";
	
//------------	
//Constructors
//------------
	public MyPoint() {}
	public MyPoint(double _x, double _y) 
	{
		x = _x;
		y = _y;
	}
	
//------------------------
//Get (accessor) functions:
//------------------------
	public double getX() { return x; }
	public double getY() { return y; }
	public String getErrorMessage() { return errorMessage; }

//------------------------
// Set (mutator) functions:
//------------------------
	public void setX(double _x) { x = _x; }
	public void setY(double _y) { y = _y; }

//----------------------------------
//Standard Methods from Object class
//----------------------------------
	public void print() 
	{
		System.out.print("(" + x + ", " + y + ")");
	}
	public String toString() 
	{
		return "[X = " + x + "; Y = " + y + "]";
	}
	public boolean equals(Object o)
	{
		// check for null parameter
		if( o == null) return false;
		
		// check for object type
		String s = o.getClass().getName(); // method to get class name
		if( !s.equals("MyPoint")) return false;
		
		// check for equivalent parameter values
		MyPoint b = (MyPoint) o;	// cast unspecified object to
								// MyPoint object in order to be able
								// to use MyPoint get() functions
		if(	x != b.getX()) return false;
		if( y != b.getY()) return false;
		
		return true;
	}
	
//-----------------------------
//Special Calculations Methods:
//-----------------------------
	public double distance(MyPoint point)
	{
		//Sum of the squared differences
		double distance = Math.pow((point.getX() - x),2) + Math.pow((point.getY() - y),2);
		//Square root of the sum of squared differences ; Final Answer
		return Math.pow(distance, 0.5);
	}
	public double distance(double _x, double _y)
	{
		//Sum of the squared differences
		double distance = Math.pow((_x - x),2) + Math.pow((_y - y),2);
		//Square root of the sum of squared differences ; Final Answer
		return Math.pow(distance, 0.5);
	}

}
