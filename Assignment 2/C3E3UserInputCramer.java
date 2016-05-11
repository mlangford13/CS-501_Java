/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 3 <br />
 * Exercise: 3 <br />
 * Description: Solving Linear Equations using Cramers Rule <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

import java.util.Scanner;

public class C3E3UserInputCramer {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Scanner object 'input' created
		
		double a, b, c, d, e, f; 				// Coefficient variables
		double x = 0, y = 0; 					// Variables to solve for
		int again = 1;							// Variable for repeating the loop
		
		while(again == 1)
		{
			// Program description and prompt user to input
			System.out.println("\nThe following 2x2 linear equations are solved using Cramer's Rule:");
			System.out.println("\t ax + by = e"); 
			System.out.println("\t cx + dy = f");
			System.out.println("Please input the values for the coefficients a, b, c, d, e, and f: ");
			a = input.nextDouble();
			b = input.nextDouble();
			c = input.nextDouble();
			d = input.nextDouble();
			e = input.nextDouble();
			f = input.nextDouble();
			
			// Echo input back to user
			System.out.println("Your two equations are: ");
			System.out.println("\t "+a+"x + "+b+"y = "+e); 
			System.out.println("\t "+c+"x + "+d+"y = "+f);
			
			//Check if equations have a solution (avoid dividing by 0)
			if((a * d - b * c) != 0)
			{
				x = (e * d - b * f) / (a * d - b * c);
				y = (a * f - e * c) / (a * d - b * c);
				System.out.println("Results:");
				System.out.println("\t x = "+x);
				System.out.println("\t y = "+y);
			}
			else
			{
				System.out.println("The equation has no solution! :(");
			}
			
			//Asking user if they want to go again
			System.out.println("Would you like to do another? Enter 1 for 'Yes' and 0 for 'No'");
			again = input.nextInt();
			
		} // end while
	} // end main()

}// end class