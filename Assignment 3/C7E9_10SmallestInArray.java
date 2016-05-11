/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 7 <br />
 * Exercise: 9 and 10 <br />
 * Description: Write two methods, one to return the minimum element of an array of doubles and one to return its index <br />
 * Due: 3/4/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
7.9:
(Find the smallest element) Write a method that finds the smallest element in an
array of double values using the following header:
		public static double min(double[] array)
Write a test program that prompts the user to enter ten numbers, invokes this
method to return the minimum value, and displays the minimum value. Here is a
sample run of the program:
		Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
		The minimum number is: 1.5

7.10:
(Find the index of the smallest element) Write a method that returns the index of
the smallest element in an array of integers. If the number of such elements is
greater than 1, return the smallest index. Use the following header:
		public static int indexOfSmallestElement(double[] array)
Write a test program that prompts the user to enter ten numbers, invokes this
method to return the index of the smallest element, and displays the index.
 */

import java.util.Scanner;
import java.util.Arrays;

public class C7E9_10SmallestInArray {
	
	/** Finds and returns the minimum value in the array*/
	public static double min(double[] array)
	{
		double min = array[0];
		for(double e: array)
			if(min > e) { min = e; }
		return min;
	}
	
	/** Finds and returns the index of the minimum value in the array*/
	public static int indexOfSmallestElement(double[] array)
	{
		int min = 0;
		for(int i = 1; i < array.length; i++)
			if(array[min] > array[i]) { min = i; }
		return min;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double[] numbers = new double[10];	//Holds users input of doubles
		double min;							//Variable to hold the minimum value in the numbers array
		int indexOfMin;						//Variable to hold the index of the min value
		int repeat = 1;						//Used to see if user wants to go again.
		
		//Program Description
		System.out.println("This program allows you to enter 10 decimal values into an array.");
		System.out.println("The program then returns the minimum value you entered and its index in the array.");
		
		while(repeat != 0)
		{
			//Prompt user input and fill array
			System.out.print("\nEnter 10 decimal values: ");
			for(int i = 0; i < numbers.length; i++)
				numbers[i] = input.nextDouble();
			
			//Get min value and its index
			min = min(numbers);
			indexOfMin = indexOfSmallestElement(numbers);
			
			//Echo user input and output results
			System.out.println("\nHere are the numbers you entered:");
			System.out.println(Arrays.toString(numbers));
			System.out.println("The minimum value is: "+min);
			System.out.println("The index in the array is: "+indexOfMin);
			
			//Prompt user input for another search
			System.out.print("\nEnter 0 to exit, any other integer to try again: ");
			repeat = input.nextInt();
		}
		input.close();

	}

}
