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
public class LinearEquation 
{
//------------------------
//Parameter Decelerations
//------------------------
	private double a = 2; // = 2 so denominator != 0	// a = (y1 - y2)
	private double b = 1;								// b = (x1 - x2)
	private double c = 1;								// c = (y3 - y4)
	private double d = 1;								// d = (x3 - x4)
	private double e = 1;								// e = (y1 - y2)x1 - (x1 - x2)y1
	private double f = 1;								// f = (y3 - y4)x3 - (x3 - x4)y3
	private String errorMessage = "";
	
//------------	
//Constructors
//------------
	public LinearEquation() {}
	public LinearEquation(double _a, double _b, double _c, 
						  double _d, double _e, double _f) throws Exception
	{//Constructor for inputing the constants of the Cramer Equation
		a = _a;
		b = _b;
		c = _c;
		setD(_d); //Only need to check if isSolvable for the combinations of a,b,c, and d
		e = _e;
		f = _f;
	}
	public LinearEquation(double x1, double y1, double x2, double y2,
						  double x3, double y3, double x4, double y4) throws Exception
	{//Constructor for entering coordinates of 2 lines endpoints
		a = (y1 - y2);
		b = (x1 - x2);
		c = (y3 - y4);
		setD(x3 - x4);
		e = (y1 - y2)*x1 - (x1 - x2)*y1;
		f = (y3 - y4)*x3 - (x3 - x4)*y3;
	}
//------------------------
//Get (accessor) functions:
//------------------------
	public double getA() { return a; }
	public double getB() { return b; }
	public double getC() { return c; }
	public double getD() { return d; }
	public double getE() { return e; }
	public double getF() { return f; }
	public String getErrorMessage() { return errorMessage; }
	
//-----------------------------
//Special Calculations Methods:
//-----------------------------
	public double getX() { return (e * d - b * f) / (a * d - b * c); }
	public double getY() { return (a * f - e * c) / (a * d - b * c); }
	
//------------------------
//isValid Method:
//------------------------
	public boolean isSolvable(double _a, double _b, double _c, double _d)
	{
		if((_a*_d - _b*_c) != 0)
			return true;
		else
		{
			errorMessage= "Equation has no solution: (a*d - b*c) must not equal 0";
			return false;
		}
	}
	
//------------------------
// Set (mutator) functions:
//------------------------
	public void setA(double _a) throws Exception
	{
		if(!isSolvable(_a,b,c,d))
			throw new Exception(errorMessage);
		a = _a;
	}
	public void setB(double _b) throws Exception
	{
		if(!isSolvable(a,_b,c,d))
			throw new Exception(errorMessage);
		b = _b;
	}
	public void setC(double _c) throws Exception
	{
		if(!isSolvable(a,b,_c,d))
			throw new Exception(errorMessage);
		c = _c;
	}
	public void setD(double _d) throws Exception
	{
		if(!isSolvable(a,b,c,_d))
			throw new Exception(errorMessage);
		d = _d;
	}
	public void setE(double _e) { e = _e; }
	public void setF(double _f) { f = _f; }

//----------------------------------
//Standard Methods from Object class
//----------------------------------
	public void print() 
	{
		System.out.println("Cramer Equation Constants:");
		System.out.println("--------------------------");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		System.out.println("Solution:");
		System.out.println("---------");
		System.out.println("x = " + getX());
		System.out.println("y = " + getY());
		
	}
	public String toString() //Show Cramer equation used to calculate x and y
	{
		return "Solving Linear Equations:\n"+
			   "-------------------------\n"+
			   "ax + by = e \t    ed - bf \t    af - ec\n"+
			   "cx + dy = f \tx = ------- \ty = -------\n"+
			   "            \t    ad - bc \t    ad - bc\n";
	}
	public boolean equals(Object o)
	{
		// check for null parameter
		if( o == null) return false;
		
		// check for object type
		String s = o.getClass().getName(); // method to get class name
		if( !s.equals("LinearEquation")) return false;
		
		// check for equivalent parameter values
		LinearEquation z = (LinearEquation) o;	// cast unspecified object
							
		if(	a != z.getA()) return false;
		if( b != z.getB()) return false;
		if(	c != z.getC()) return false;
		if( d != z.getD()) return false;
		if(	e != z.getE()) return false;
		if( f != z.getF()) return false;
		
		return true;
	}

}//end LinearEquation class
