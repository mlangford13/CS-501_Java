
public class IllegalTriangleException extends Exception{
	private double side1, side2, side3;
	
	/** Construct an exception */
	public IllegalTriangleException(double side1, double side2, double side3) {
		super("Invalid side lengths: " + side1 + ", "+ side2 +", "+ side3
			 +"\n - The sum of any two sides must be greater than 0"
			 +"\n - All lengths must be greater than 0");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	/** Return the side lengths */
	public double getSide1() { return side1; }
	public double getSide2() { return side2; }
	public double getSide3() { return side3; }
}
