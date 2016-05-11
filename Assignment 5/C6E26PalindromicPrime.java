import java.util.Scanner;

/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 6 <br />
 * Exercise: 26 <br />
 * Description: Output first 100 Palindrom Primes <br />
 * Due: 3/28/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />
 */
/*
6.26 
(Palindromic prime) A palindromic prime is a prime number and also palindromic.
For example, 131 is a prime and also a palindromic prime, as are 313 and
757. Write a program that displays the first 100 palindromic prime numbers. Display
10 numbers per line, separated by exactly one space, as follows:
2 3 5 7 11 101 131 151 181 191
313 353 373 383 727 757 787 797 919 929
...
 */

public class C6E26PalindromicPrime {
	//Checks if number is prime
	public static boolean isPrime(int n)
	{
		if(n < 2)       // 1 is NOT prime
			return false;
		if(n == 2)       // 2 is prime
			return true;
		if(n % 2 == 0)   // Even numbers are NOT prime
			return false;
		for(int i = 3; i <= Math.sqrt(n); i += 2)    //if a number is not disproven to be prime for all numbers below its square root, then it is prime.
	    {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	//Checks if a number is a palindrom
	public static boolean isPalindrom(int n)
	{
		String check = String.valueOf(n);
		for(int i = 0; i < (check.length()/2)+1; i++)
		{
			if(check.charAt(i) != check.charAt(check.length()-i-1))
				return false;
		}
		return true;
	}
	
	//Prints only prime numbers that are palindroms
	public static void printPalindromPrimes(int numPrimes)
	{
		int lineCount = 0;
		int checkNum = 2;
		while(numPrimes > 0)
		{
			if(isPrime(checkNum) && isPalindrom(checkNum))
			{
				System.out.print(checkNum+"\t");
				numPrimes--;
				lineCount++;
				if(lineCount%10 == 0)		//Go to next line every 10 #s
					System.out.println(""); 
			}
			checkNum++;
		}
	}
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declaring data memebers
		int numPrimes;
		int repeat = 1;
		
		//Program description
		System.out.println("This program displays Palindromic Primes");
		System.out.println("You enter the amount you would like to be displayed");
		
		//Repeat loop for user testing
		while(repeat != 0)
		{
			//Prompt user input
			System.out.print("\nEnter how many Palindromic Primes to print: ");
			numPrimes = input.nextInt();
			printPalindromPrimes(numPrimes);
			
			//Go again?
			System.out.print("\nEnter 0 to exit, any other integer to go again: ");
			repeat = input.nextInt();
		}
	}
}
