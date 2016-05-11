/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 7 <br />
 * Exercise: 19 <br />
 * Description: Write a method to check whether an array is sorted in ascending order <br />
 * Due: 3/4/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
7.19:
(Sorted?) Write the following method that returns true if the list is already sorted
in increasing order.
		public static boolean isSorted(int[] list)
Write a test program that prompts the user to enter a list and displays whether
the list is sorted or not. Here is a sample run. Note that the first number in the
input indicates the number of the elements in the list. This number is not part
of the list.
		Enter list: 8 10 1 5 16 61 9 11 1
		The list is not sorted
		Enter list: 10 1 1 3 4 4 5 7 9 11 21
		The list is already sorted
 */
import java.util.Scanner;

public class C7E19IsSorted {
	
	/** Returns to if list is sorted in ascending order*/
	public static boolean isSorted(int[] list)
	{
		for(int curr = 0, next = 1; next < list.length; curr++, next++)
		{
			if(list[curr] > list[next]) 
				return false;
			curr++;
			next++;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeat = 1;	//Used to all user to go again
		
		//Program description
		System.out.println("This program lets you enter a list of integers and tell you if it is sorted in ascending order.");
		System.out.println("The first number you enter MUST correspond to the number of elements you will enter.");
		
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter the list size followed by the elements: ");
			int size = input.nextInt();
			int[] list = new int[size];
			for(int i = 0; i < size; i++)
				list[i] = input.nextInt();
			
			//Determine if list is sorted and output results
			if(isSorted(list))
				System.out.println("This list is sorted!");
			else
				System.out.println("This list is NOT sorted :(");
			
			//Prompt user input for another search
			System.out.print("Enter 0 to exit, any other integer to try again: ");
			repeat = input.nextInt();
			
		} //end while
		input.close();
		
	}//end main
}//end class
