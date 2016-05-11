/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 10 <br />
 * Exercise: 6 <br />
 * Description: Use 'StackOfIntegers' class to display first 120 primes in reverse order <br />
 * Due: 4/11/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
 10.6
(Displaying the prime numbers) Write a program that displays all the prime
numbers less than 120 in decreasing order. Use the StackOfIntegers class
to store the prime numbers (e.g., 2, 3, 5, ...) and retrieve and display them in
reverse order.
*/
import java.util.Scanner;
public class C10E6StackDisplayPrimes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declaring data memebers
		int numPrimes;
		int repeat = 1;
		StackOfPrimes primes;	//Extends StackOfIntegers
		
		//Program description
		System.out.println("This program displays prime numbers in reverse order");
		System.out.println("You enter a value and all primes below it will be displayed.");
		
		//Repeat loop for user testing
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter upper bound value for Primes to print: ");
			numPrimes = input.nextInt();
			
			//Load StackOfPrimes object with the primes then display
			primes = new StackOfPrimes(numPrimes);
			primes.emptyAndDisplay();
			
			//Go again?
			System.out.print("\nEnter 0 to exit, any other integer to go again: ");
			repeat = input.nextInt();
		}

	}
}

