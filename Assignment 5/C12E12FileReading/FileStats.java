import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStats 
{
//------------------------
//Parameter Decelerations
//------------------------
	private File file = null;
	private int numLetters = 0;
	private int numWords = 0;
	private int numLines;
	private String errorMessage = "hello";
	private Scanner reader = null;
	
//------------	
//Constructors
//------------
	public FileStats() {}
	public FileStats(String fileName) throws Exception
	{
		setStats(fileName);
	}
	public FileStats(File file) throws Exception
	{
		setStats(file);
	}

//------------------------
//Get (accessor) functions:
//------------------------
	public String getErrorMessage() {return errorMessage; }
	public int getNumLetters() { return numLetters; }
	public int getNumWords() { return numWords; }
	public int getNumLines() { return numLines; }
	
//------------------------
// Set (mutator) functions:
//------------------------
	public void setStats(String filename) throws Exception
	{
		File check = new File(filename);
		if(!isValidFile(check))
			throw new Exception(errorMessage);
		setFile(check);
		setNumLetters(file);
		setNumWords(file);
		setNumLines(file);
	}
	public void setStats(File _file) throws Exception
	{
		if(!isValidFile(_file))
			throw new Exception(errorMessage);
		setFile(file);
		setNumLetters(file);
		setNumWords(file);
		setNumLines(file);
		
	}
	public void setFile(File _file)
	{
		file = _file;
	}
	public void setReader(File _file) throws FileNotFoundException
	{
		reader = new Scanner(_file);
	}
	public void setNumLetters(File _file) throws FileNotFoundException
	{
		setReader(_file);
		numLetters = 0;
		while(reader.hasNext())
		{
			numLetters += reader.next().length();
		}
	}
	public void setNumWords(File _file) throws FileNotFoundException
	{
		setReader(_file);
		numWords = 0;
		while(reader.hasNext())
		{
			reader.next();
			numWords++;
		}
	}
	public void setNumLines(File _file) throws FileNotFoundException
	{
		setReader(_file);
		numLines = 0;
		while(reader.hasNext())
		{
			reader.nextLine();
			numLines++;
		}
	}
	
//------------------------
//isValid Methods:
//------------------------
	public boolean isValidFile(File _file)
	{
		if(_file.exists())
		{
			if(_file.isFile()) //Not a directory name
			{
				if(_file.getName().endsWith(".txt"))
				{
					return true;
				}
				else
				{
					errorMessage = "Invalid Input: File was not a .txt file";
					return false;
				}
			}
			else
			{
				errorMessage = "Invalid Input: This is not a file!";
				return false;
			}
		}
		else
		{
			errorMessage = "Invalid Input: This file does not exist";
			return false;
		}
	}

//----------------------------------
//Standard Methods from Object class
//----------------------------------
	public void print() 
	{
		System.out.println("File Statistics:");
		System.out.println("----------------");
		System.out.println("File Name:\t" + file.getName());
		System.out.println("# of Letters:\t" + numLetters);
		System.out.println("# of Words:\t" + numWords);
		System.out.println("# of Lines:\t" + numLines);
	}
}