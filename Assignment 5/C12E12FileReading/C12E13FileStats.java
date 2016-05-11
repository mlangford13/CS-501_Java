/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 12 <br />
 * Exercise: 13 <br />
 * Description: Take in a text file and count letters, words, and lines <br />
 * Due: 3/28/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
12.13 
(Count characters, words, and lines in a file) Write a program that will count
the number of characters, words, and lines in a file. Words are separated by
whitespace characters. The file name should be passed as a command-line
argument
 */
import java.io.File;
import java.util.Scanner;
//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class C12E13FileStats {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Data members
		int repeat = 1;
		String fileName = "test.txt";
		FileStats exampleFile = new FileStats();

		//Program Description
		System.out.println("The following program allows you to the name of a '.txt' file");
		System.out.println("and allows shows you a count of the total number of characters (not whitespace), "
						 + "\nwords, and lines in the file\n");
		
		//Example of program function
		System.out.println("Example of statistics for given 'test.txt' file");
		try {
			exampleFile = new FileStats(fileName);
			exampleFile.print();
		}
		catch(Exception e) {
			System.out.println(" - FAILED - " +
					"\nexampleFile = new FileStats(filename);" +
					"\nthrew Exception w/ message:\n" +
					//exampleFile.getErrorMessage());
					e.getMessage());
		}
		
		//Repeat loop for user testing
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter the file name (including .txt extension): ");
			fileName = input.next();
			
			//Testing for valid input by user
			try {
				exampleFile = new FileStats(fileName);
				exampleFile.print();
				System.out.print("\nEnter 0 to exit, any other integer to go again: ");
				repeat = input.nextInt();
			}
			catch(Exception e) {
				System.out.println(" - FAILED - " +
						"\nexampleFile = new FileStats(filename);" +
						"\nthrew Exception w/ message:\n" +
						//exampleFile.getErrorMessage());
						e.getMessage());
				System.out.println("- TRY AGAIN - ");
				//Goes back to user input after message is printed
			}
		}// end while
		
	}//end main

}//end class
