import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class SpellChecker
{
	public static void main(String[ ] args)
	{
		String Textfile;
		String Libraryfile;
		ArrayList textItems = new ArrayList();
		ArrayList libraryItems = new ArrayList();
		ArrayList uniqueItems = new ArrayList();

		Scanner userInput = new Scanner(System.in);

		System.out.println("Please enter a text file (Only txt files are valid)");
		Textfile = userInput.next();
		textItems = SpellChecker.getText(Textfile);

		System.out.println("Please enter a library (Only txt files are valid)");
		Libraryfile = userInput.next();

		libraryItems = SpellChecker.getDictionary(Libraryfile);

		System.out.println("\nPrinting out what is in the text and then what is in the library:");
		System.out.println(textItems + "\n");
		System.out.println(libraryItems + "\n");

		uniqueItems = SpellChecker.compareWord(textItems, libraryItems);
		System.out.println("Printing out the unique words:");
		System.out.println(uniqueItems + "\n");

		for(int index = 0; index < uniqueItems.size(); index++)
		{
			System.out.println("Would you like to add \"" + uniqueItems.get(index) + "\" to the library or would you like to ignore it?");
			String addOrIgnore = userInput.next();

			while(addOrIgnore.equalsIgnoreCase("Add") == false && addOrIgnore.equalsIgnoreCase("Ignore") == false)
			{
					System.out.println("Sorry your only choices are Add or Ignore");
					addOrIgnore = userInput.next();
			}

			if(addOrIgnore.equalsIgnoreCase("Add") == true)
			{
				libraryItems = SpellChecker.addWord(libraryItems, uniqueItems.get(index));
			}

		}

		System.out.println("\nHere is the new Library!");
		System.out.println(libraryItems + "\n");

	}

	public static ArrayList getText(String Textfile)
	{
		ArrayList arrayListText = new ArrayList();
		Scanner ReadingTextFile = null;

		try
		{
			ReadingTextFile = new Scanner(new FileInputStream(Textfile));
		}
		catch (Exception e)
		{
			System.out.println("File " + Textfile + " not found or could not be opened.");
			System.exit(0);
		}

		while(ReadingTextFile.hasNext())
		{
			arrayListText.add(ReadingTextFile.next());
		}

		return arrayListText;
	}


	public static ArrayList getDictionary(String Libraryfile)
	{
		ArrayList arrayListLibrary = new ArrayList();
		Scanner ReadingLibraryFile = null;

		try
		{
			ReadingLibraryFile = new Scanner(new FileInputStream(Libraryfile));
		}
		catch (Exception e)
		{
			System.out.println("File " + Libraryfile + " not found or could not be opened.");
			System.exit(0);
		}

		while(ReadingLibraryFile.hasNext())
		{
			arrayListLibrary.add(ReadingLibraryFile.next());;
		}

		return arrayListLibrary;
	}

	public static ArrayList compareWord(ArrayList textFile, ArrayList LibraryFile)
	{
		ArrayList uniqueItems = new ArrayList();

		for(int index = 0; index < textFile.size(); index++)
		{
			if(LibraryFile.contains(textFile.get(index)) == false)
			{
				uniqueItems.add(textFile.get(index));
			}

		}

		return uniqueItems;
	}

	public static ArrayList addWord(ArrayList LibraryFile, Object word)
	{
		ArrayList newLibrary = new ArrayList(LibraryFile);

		newLibrary.add(word);

		return newLibrary;
	}


}