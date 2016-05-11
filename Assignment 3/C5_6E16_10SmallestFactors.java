/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 5 and 6 <br />
 * Exercise: 16 and 10 <br />
 * Description: Use the isPrime method to count number of <br />
 * Due: 3/4/2016 <br />
 * Cited: Textbook (10th Edition) for isPrime() and binarySearch()
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */

/*
5.16:
Find the factors of an integer) Write a program that reads an integer and displays
all its smallest factors in increasing order. For example, if the input integer is
120, the output should be as follows: 2, 2, 2, 3, 5.

6.10:
(Use the isPrime Method) Listing 6.7, PrimeNumberMethod.java, provides the
isPrime(int number) method for testing whether a number is prime. Use this
method to find the number of prime numbers less than 1000. Store the primes in an array
and print only the first 50. Then ask the user for numbers less than 1000 in a repeat loop, 
check if they are prime by searching the array, and if not and show their prime factors in 
ascending order. Searching arrays is described in Chapter 7 in 10e.

For all the program remember to show the user some introductory text saying what the program 
will do and include a repeat loop to allow the user to run the program until the user indicates 
no more input, i.e., after the output ask the user if  more input is to be entered and if not exit.
 */

import java.util.Scanner; //Include Scanner library

public class C5_6E16_10SmallestFactors {
	
	/** Check whether number is prime */
	public static boolean isPrime(int number) 
	{
		if(number == 1) { return false; }
		for (int divisor = 2; divisor <= number / 2; divisor++) 
		{
			if (number % divisor == 0)  // If true, number is not prime
				return false; 			// Number is not a prime
		}
		return true; // Number is prime
	}
	
	/** Count the number of primes in a given range */
	public static int countPrimes(int first, int last)
	{
		int count = 0;
		for(int i = first; i <= last; i++)
			if(isPrime(i)) { count++; } //Increment count when a prime is found
		return count;
	}
	
	/** Store primes in a given range in an array */
	public static void storePrimes(int first, int last, int[] a)
	{
		int i = 0;
		while(first <= last && i < a.length) //Store the range from first to last, don't go over arrays size
		{
			if(isPrime(first))
				a[i++] = first; //Set current element to the prime number, then increment i to point to next element
			first++;
		}
	}
	
	/** Display a given number of elements in an array */
	public static void displayElements(int numElements, int[] a)
	{
		if (numElements > a.length) { numElements = a.length; } //Make sure program does not try to print more elements than the array contains
		System.out.print("First "+ numElements +" Primes:");
		for(int i = 0; i < numElements; i++)
		{
			if(i%10 == 0) { System.out.print('\n'); } //New line every 10 elements
			System.out.print(a[i] + "\t");
		}
	}
	
	/** Search for a number in array sorted in ascending order */
	public static boolean binarySearch(int[] list, int key) 
	{
		int low = 0;
		int high = list.length - 1;
		while (high >= low) 
		{
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key > list[mid])
				low = mid + 1;
			else
				return true;
		}
		return false; // Not found
	}
	
	/** Recursive function to display the prime factors of the given number */
	public static void displayPrimeFactors(int number)
	{
		if(number == 1) return;
		for(int i = 2; i <= number; i++)
		{
			if(number % i == 0)
			{
				System.out.print(i + "\t");
				displayPrimeFactors(number/i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Program Description
		System.out.println("This program allows you check if a number (less than 1000) is a prime number.");
		System.out.println("If your number is not prime, the program will display its prime factors in ascending order");
		System.out.println("The first 50 prime numbers (2 -> 229) are printed below.");
		
		int repeat = 1;							//Variable to check if user wants to go again
		int searchValue;						//Holds the number the user wants to check
		int numPrimes = countPrimes(1,1000);	//Holds the total # of prime numbers in the range of 1 to 1000 inclusively
		int[] primes = new int[numPrimes];		//Array to prime numbers between 1 and 1000, sized to fit exact amount
		
		//Insert primes into array and display the first 50 elements
		storePrimes(1,1000,primes);
		displayElements(50,primes);
		
		//Repeating search loop for user to check if a number is prime
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter a number (1 < n < 1000) to check if it is prime: ");
			searchValue = input.nextInt();
			
			//Validate input and act accordingly
			if(searchValue > 1000 || searchValue < 0)
				System.out.println("Input out of range. Must be a number between 1 and 1000 inclusively.");
			else if(binarySearch(primes, searchValue))
				System.out.println("Congrats! "+ searchValue +" is a prime number!");
			else
			{
				System.out.println("Sorry, "+ searchValue +" is NOT a prime number! Here are its prime factors:");
				displayPrimeFactors(searchValue);
			}
			
			//Prompt user input for another search
			System.out.print("\nEnter 0 to exit, any other integer to try again: ");
			repeat = input.nextInt();
		}
		input.close();
	}

}
