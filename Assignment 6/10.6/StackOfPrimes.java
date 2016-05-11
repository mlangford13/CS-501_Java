
public class StackOfPrimes extends StackOfIntegers{
	private int upperLimit;	//Upper bound, value of prime can not surpass this
	
	public StackOfPrimes(int upperLimit)
	{
		setCapacity(DEFAULT_CAPACITY);
		this.upperLimit = upperLimit;
		loadStack();
	}
	
	//Get and set method for new data member
	public int getUpperLimit() { return upperLimit; }
	public void setUpperLimit(int upperLimit)
	{
		if(upperLimit > this.upperLimit) { addPrimes(upperLimit); }
		else if (upperLimit < this.upperLimit) { removePrimes(upperLimit); }
		this.upperLimit = upperLimit;
	}
	
	//Checks if number is prime
	public boolean isPrime(int n)
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
	
	//Puts all primes below 'upperLimit' onto the stack
	public void loadStack()
	{
		int checkNum = 2;
		while(checkNum < upperLimit)
		{
			if(isPrime(checkNum))
				push(checkNum);
			checkNum++;
		}
	}
	
	//Appends primes to stack if a larger new upperLimit is given by user
	public void addPrimes(int newBound)
	{
		int checkNum = peek()+1;
		while(checkNum < newBound)
		{
			if(isPrime(checkNum))
				push(checkNum);
			checkNum++;
		}
	}
	
	//Removes primes from stack if a smaller new upperLimit is given by user
	public void removePrimes(int newBound)
	{
		while(peek() > newBound)
		{
			pop();
		}
	}
	
	//Removes all elements add displays them for the user
	public void emptyAndDisplay()
	{
		int lineCount = 0;
		while(!empty())
		{
			System.out.print("\t"+pop());
			lineCount++;
			if(lineCount%10 == 0) { System.out.println(""); } 
		}
	}
}
