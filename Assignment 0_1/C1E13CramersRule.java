/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Description: Solving Linear Equations <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

public class C1E13CramersRule {

	public static void main(String[] args) {
		double a = 3.4, b = 50.2, c = 2.1, d = 0.55, e = 44.5, f = 5.9; // Coefficent values
		double x = 0, y = 0; // Variables to solve for
		System.out.println("The following 2x2 linear equations are solved using Cramer's Rule:\n");
		System.out.println("\t "+a+"x + "+b+"y = "+e); 
		System.out.println("\t "+c+"x + "+d+"y = "+f+"\n");
		x = (e * d - b * f) / (a * d - b * c);
		y = (a * f - e * c) / (a * d - b * c);
		System.out.println("Results:");
		System.out.println("\t x = "+x);
		System.out.println("\t y = "+y);
	}

}
