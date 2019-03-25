import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Group 13
 *
 */
public class Translation {

	Scanner s = new Scanner(System.in);
	Tree tree = new Tree();
	
	/**
	 * method to translate a word
	 * 1 for english to spanish
	 * 2 for spanish to english
	 * @param lang int containing which language to translate to/from (see above)
	 * @param translate String containing the word to be translated
	 * @return String containing the translation
	 */
	public String translateWord(int lang, String translate)
	{
		TreeNode letterNode = null;
		if (translate != null)
		{
			char letter = translate.charAt(0); //gets the first letter in the word
			int  ascii = (int) letter; //gets the ascii value of the first letter
			letterNode = tree.findNode(ascii); //finds the tree node containing the required letter
		}
		
		String translation = searchWord(lang, letterNode.getLetterId(), translate);
		return translation;
	}
	
	/**
	 * searchs for a word and if it is found, gets it's translation
	 * 1 for english to spanish
	 * 2 for spanish to english
	 * @param lang int containing which langauge to translate to/from (see above)
	 * @param ascii int containing the ascii value of the first letter of the word to be found
	 * @param word int containing the word to be searched for
	 * @return String containing the translation if it is found, null if it isn't found
	 */
	public String searchWord(int lang, int ascii, String word)
	{
		String translation = "";
		String wordFile = "";
		String translationFile = "";
		
		if (lang == 1) //for an english to spanish translation
		{
			String letter = Character.toString((char) ascii);
			wordFile = letter + "engtospanw.txt";
			translationFile = letter + "engtospant.txt";
		}
		else if (lang == 2)
		{
			String letter = Character.toString((char) ascii);
			wordFile = letter + "spantoengw.txt";
			translationFile = letter + "spantoengt.txt";
		}
		
		try
		{
			FileReader filereader = new FileReader(wordFile);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			
			String fileLine = bufferedReader.readLine();
			int lineCount = 1;
			while (fileLine != null)
			{
				if (fileLine == word) //the word has been found
				{
					translation = getTranslation(lineCount, translationFile);
				}
				else
				{
					lineCount++;
					fileLine = bufferedReader.readLine();
				}
			}
			bufferedReader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error reading from files: " + e);
		}
		
		return translation;
	}
	
	/**
	 * 
	 * @param line int containing the line number of the word to get the translation for
	 * @param file String containing the name of the file to search for the translation for
	 * @return Stirng containing the translation of the word
	 */
	public String getTranslation(int line, String file)
	{
		String translation = "";
		int count = 1;
		try
		{
			FileReader filereader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			
			String fileLine = bufferedReader.readLine();
			
			if (line == 1)
			{
				translation = fileLine;
			}
			else
			{
				while (fileLine != null)
				{
					fileLine = bufferedReader.readLine();
					count++;
					if (count == line)
					{
						translation = fileLine;
					}
				}
			}
			bufferedReader.close();
		}
		catch (IOException e)
		{
			System.out.println("Error reading from files: " + e);
		}
		return translation;
	}
	
	/**
	 * calls on the display methods from the tree class
	 */
	public void display()
	{
		tree.displayTreeEngToSpan(tree.getRoot());
		tree.displayTreeSpanToEng(tree.getRoot());
	}
	
	public void deleteEngToSpan()
	{
		System.out.println("Please enter the word in Englsh to delete: "); // Enter the English word to delete.
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();
		
		String spanish = translateWord(1, english); // get the translation for the word to delete.

		char[] characters = english.toCharArray(); // Get the first letter of the word.
		char firstChar = characters[0];
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "engtospanwnew.txt"); //Create an output for the updated translation file.
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "engtospanw.txt")); //input the translation file as it currently is.
			String line1 = br1.readLine();
			while(line1 != null) //whilst the document isn't blank.
			{
				boolean flag = false;
			
				while(english != null) // while the English word isn't blank.
				{
					if(line1.contentEquals(english)) // If the current English word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
					{
						flag = true;
						break;
					}
				}
				if(!flag)
					pw.println(line1);
				
				line1 = br1.readLine();
			}
			pw.flush(); // Close tools.
			br1.close();
			pw.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
			
		try {
			fileReader = new FileReader("engtospanwnew"); //Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("engtospanw"); // Output the new file under the name of the original.
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine(); // Read in the first line.
			while (nextLine != null) // Do whilst the document is not blank
			{
				printWriter.println(nextLine); // Print the line to the updated original file.
				nextLine = bufferedReader.readLine(); // Read in the next line.
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Runs the same thing again but using the translation instead so both are erased.
		 */
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "engtospantnew.txt"); //Create an output for the updated translation file.
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "engtospant.txt")); //input the translation file as it currently is.
			String line1 = br1.readLine();
			while(line1 != null) //whilst the document isn't blank.
			{
				boolean flag = false;
			
				while(spanish != null)  // while the Spanish word isn't blank.
				{
					if(line1.contentEquals(spanish)) // If the current Spanish word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
					{
						flag = true;
						break;
					}
				}
				if(!flag)
					pw.println(line1);
				
				line1 = br1.readLine();
			}
			pw.flush();// Close tools.
			br1.close();
			pw.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			fileReader = new FileReader("engtospantnew");//Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("engtospant");// Output the new file under the name of the original.
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();// Read in the first line.
			while (nextLine != null)// Do whilst the document is not blank
			{
				printWriter.println(nextLine); // Print the line to the updated original file.
				nextLine = bufferedReader.readLine();// Read in the next line.
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The same as the previous method just done the opposite way around so the Spanish word is entered and the Spanish translation is deleted.
	 */
	public void deleteSpanToEng()
	{
		System.out.println("Please enter the word in Spanish to delete: ");
		Scanner r = new Scanner(System.in);
		String spanish = r.nextLine();
		
		String english = translateWord(2, spanish);

		char[] characters = spanish.toCharArray();
		char firstChar = characters[0];
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "spantoengwnew.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "spantoengw.txt"));
			String line1 = br1.readLine();
			while(line1 != null)
			{
				boolean flag = false;
			
				while(spanish != null)
				{
					if(line1.contentEquals(spanish))
					{
						flag = true;
						break;
					}
				}
				if(!flag)
					pw.println(line1);
				
				line1 = br1.readLine();
			}
			pw.flush();
			br1.close();
			pw.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
			
		try {
			fileReader = new FileReader("spantoengwnew");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("spantoengw");
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
				System.out.println(nextLine);
				printWriter.println(nextLine);
				nextLine = bufferedReader.readLine();
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "spantoengtnew.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "spantoengt.txt"));
			String line1 = br1.readLine();
			while(line1 != null)
			{
				boolean flag = false;
			
				while(english != null)
				{
					if(line1.contentEquals(english))
					{
						flag = true;
						break;
					}
				}
				if(!flag)
					pw.println(line1);
				
				line1 = br1.readLine();
			}
			pw.flush();
			br1.close();
			pw.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			fileReader = new FileReader("spantoengtnew");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("spantoengt");
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
				System.out.println(nextLine);
				printWriter.println(nextLine);
				nextLine = bufferedReader.readLine();
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEngToSpan() 
	{
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter the word in Englsh to add: "); //Enter the English word.
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();
		System.out.println("Please enter the word in Spanish to add: "); // Enter the Spanish translation for that word.
		Scanner s = new Scanner(System.in);
		String spanish = s.nextLine();
		
		char[] characters = english.toCharArray(); // Get the first letter of the inputted word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "engtospanw.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(english);
			
			FileWriter g = new FileWriter(firstChar + "engtospant.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(spanish);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This is the same as the previous method but works for the Spanish word and the English translation of that word.
	 *  I made this separate rather than adding them both automatically in case it could be grammatically incorrect so it gives the user more freedom to add what they want to each.
	 */
	public void addSpanToEng() 
	{
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter the word in Spanish to add: ");
		Scanner r = new Scanner(System.in);
		String spanish = r.nextLine();
		System.out.println("Please enter the word in English to add: ");
		Scanner s = new Scanner(System.in);
		String english = r.nextLine();
		
		char[] characters = spanish.toCharArray();
		char firstChar = characters[0];
		
		try
		{
			FileWriter f = new FileWriter(firstChar + "spantoengw.txt", true);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(spanish);
			
			FileWriter g = new FileWriter(firstChar + "spantoengt.txt", true);
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			p.println(english);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This is a modified version of the decryption method used last semester.
	 */
	public void translateFileEngToSpan() 
	{
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter name of file to be translated:"); // Enter the name of the file to be translated.
		Scanner s = new Scanner(System.in);
		String file = s.nextLine();
		
		System.out.println("Please enter the name you would like the translated file to have: "); // Enter the name of the new translated file.
		Scanner r = new Scanner(System.in);
		String translatedFile = s.nextLine();
		
		try 
		{
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(translatedFile);
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine(); // Read in the first line.
			while (nextLine != null) // Whilst the line is not blank.
			{
				String[] line = nextLine.split("\\s"); // Split the line into separate words for translation.
				for (int i = 0; i <= line.length; i++) // Do for each word in the line.
				{
					String temp = translateWord(1, line[i]); // Translate the word.
					printWriter.println(temp); //Print to file.
					System.out.println(temp); //Print to Console.
					nextLine = bufferedReader.readLine(); //Read in the next line.
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but it translates the words from spanish to english.
	 */
	public void translateFileSpanToEng() 
	{
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter name of file to be translated:");
		Scanner s = new Scanner(System.in);
		String file = s.nextLine();
		
		System.out.println("Please enter the name you would like the translated file to have: ");
		Scanner r = new Scanner(System.in);
		String translatedFile = s.nextLine();
		
		try 
		{
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(translatedFile);
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
				String[] line = nextLine.split("\\s");
				for (int i = 0; i <= line.length; i++)
				{
					String temp = translateWord(2, line[i]);
					printWriter.println(temp); 
					System.out.println(temp);
					nextLine = bufferedReader.readLine();
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
