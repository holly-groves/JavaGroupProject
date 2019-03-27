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
 * TRANSLATION
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
	 * 3 for english to french
	 * 4 for french to english
	 * @param lang int containing which language to translate to/from (see above)
	 * @param translate String containing the word to be translated
	 * @return String containing the translation
	 */
	public String translateWord(int lang, String translate)
	{
		Tree tree = new Tree();
		tree.createAlphabetTree();
		TreeNode letterNode = null;
		if (translate != null)
		{
			char letter = translate.charAt(0); //gets the first letter in the word
			int  ascii = (int) letter; //gets the ascii value of the first letter
			letterNode = tree.findNode(ascii); //finds the tree node containing the required letter
		}
		
		String translation = searchWord(lang, letterNode.getLetterId(), translate);
		if (translation.equals(null))
		{
			translation = translate;
		}
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
		Tree tree = new Tree();
		tree.createAlphabetTree();
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
		else if (lang == 3) //for an english to french translation
		{
			String letter = Character.toString((char) ascii);
			wordFile = letter + "engtofrew.txt";
			translationFile = letter + "engtofret.txt";
		}
		else if (lang == 4) //for a french to english translation
		{
			String letter = Character.toString((char) ascii);
			wordFile = letter + "fretoengw.txt";
			translationFile = letter + "fretoengt.txt";
		}
		
		try
		{
			FileReader filereader = new FileReader(wordFile);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			
			String fileLine = bufferedReader.readLine();
			int lineCount = 1;
			boolean found = false;
			do
			{
				if (fileLine.equals(word)) //the word has been found
				{
					found = true;
					translation = getTranslation(lineCount, translationFile, word);
					
				}
				else
				{
					lineCount++;
					fileLine = bufferedReader.readLine();
					if (fileLine.equals(null))
					{
						translation = word;
					}
				}
			}while(!found);
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
	public String getTranslation(int line, String file, String word)
	{
		Tree tree = new Tree();
		tree.createAlphabetTree();
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
		if (translation.equals(null))
		{
			translation = word;
		}
		return translation;
	}
	
	/**
	 * method to translate a phrase
	 * 1 for english to spanish
	 * 2 for spanish to english
	 * 3 for english to french
	 * 4 for french to english
	 * @param lang int containing which language to translate to/from (see above)
	 * @param translate String containing the phrase to be translated
	 * @return String containing the translation
	 */
	public String translatePhrase(int lang, String translate)
	{
		Tree tree = new Tree();
		tree.createAlphabetTree();
		String translation = "";
		TreeNode letterNode = null;
		String[] splitWords = translate.split("\\s+"); //takes each word in the phrase and splits them apart
		String[] tSplitWords = new String [splitWords.length];
		for (int i = 0; i < splitWords.length; i++) //for every word in the phrase
		{
			splitWords[i] = splitWords[i].replaceAll("[^\\w]", ""); 
			if (splitWords[i] != null)
			{
				char letter = splitWords[i].charAt(0); //gets the first letter in the word
				int  ascii = (int) letter; //gets the ascii value of the first letter
				letterNode = tree.findNode(ascii); //finds the tree node containing the required letter
			}
			tSplitWords[i] = searchWord(lang, letterNode.getLetterId(), splitWords[i]);
			if (tSplitWords[i] == null)
			{
				tSplitWords[i] = splitWords[i];
			}
		        translation = translation + tSplitWords[i] + " ";
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
	
/**
	 * Allows the user to delete an English word and its translation from the dictionary.
	 * The user enters the word and the word is than translated, both the word and its translations are then found and deleted.
	 */
	public void deleteEngToSpan(boolean test, String testWord)
	{
		tree.createAlphabetTree();
		String english;
		String spanish = "testWordTranslated";
		if (test == false)
		{
			System.out.println("Please enter the word in Englsh to delete: "); // Enter the English word to delete.
			Scanner r = new Scanner(System.in);
			english = r.nextLine();
			r.close();
		} else 
		{
			english = testWord;
		}
		
		//String spanish = translateWord(1, english); // get the translation for the word to delete.

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
			
				if(line1.contentEquals(english)) // If the current English word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
				{
					flag = true;
					break;
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
			fileReader = new FileReader(firstChar + "engtospanwnew.txt"); //Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "engtospanw.txt"); // Output the new file under the name of the original.
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
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
			
					if(line1.contentEquals(spanish)) // If the current Spanish word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
					{
						flag = true;
						break;
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
			
		try {
			fileReader = new FileReader(firstChar + "engtospantnew.txt");//Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "engtospant.txt");// Output the new file under the name of the original.
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This is the same as the previous method except it requests the Spanish word to delete.
	 */
	public void deleteSpanToEng()
	{
		tree.createAlphabetTree();
		System.out.println("Please enter the word in Spanish to delete: ");
		Scanner r = new Scanner(System.in);
		String spanish = r.nextLine();
		r.close();
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

					if(line1.contentEquals(spanish))
					{
						flag = true;
						break;
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
			fileReader = new FileReader(firstChar + "spantoengwnew.txt");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "spantoengw.txt");
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
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
			
					if(line1.contentEquals(english))
					{
						flag = true;
						break;
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
			
		try {
			fileReader = new FileReader(firstChar + "spantoengtnew");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "spantoengt");
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Allows the user to delete an English word and its translation from the dictionary.
	 * The user enters the word and the word is than translated, both the word and its translations are then found and deleted.
	 */
	public void deleteEngToFre()
	{
		tree.createAlphabetTree();
		System.out.println("Please enter the word in Englsh to delete: "); // Enter the English word to delete.
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();
		r.close();
		
		String french = translateWord(3, english); // get the translation for the word to delete.

		char[] characters = english.toCharArray(); // Get the first letter of the word.
		char firstChar = characters[0];
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "engtofrenwnew.txt"); //Create an output for the updated translation file.
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "engtofrew.txt")); //input the translation file as it currently is.
			String line1 = br1.readLine();
			while(line1 != null) //whilst the document isn't blank.
			{
				boolean flag = false;
				
					if(line1.contentEquals(english)) // If the current English word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
					{
						flag = true;
						break;
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}

		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
			
		try {
			fileReader = new FileReader(firstChar + "engtofrewnew"); //Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "engtofrew"); // Output the new file under the name of the original.
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		
		/**
		 * Runs the same thing again but using the translation instead so both are erased.
		 */
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "engtofretnew.txt"); //Create an output for the updated translation file.
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "engtofret.txt")); //input the translation file as it currently is.
			String line1 = br1.readLine();
			while(line1 != null) //whilst the document isn't blank.
			{
				boolean flag = false;
			
					if(line1.contentEquals(french)) // If the current Spanish word that is being processed isn't the one to be deleted print it, if it is then don't print (delete it).
					{
						flag = true;
						break;
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
			
		try {
			fileReader = new FileReader(firstChar + "engtofretnew");//Read in new file.
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "engtofret");// Output the new file under the name of the original.
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This is the same as the previous method except it requests the French word to delete.
	 */
	public void deleteFreToEng()
	{
		tree.createAlphabetTree();
		System.out.println("Please enter the word in Spanish to delete: ");
		Scanner r = new Scanner(System.in);
		String french = r.nextLine();
		r.close();
		
		String english = translateWord(4, french);

		char[] characters = french.toCharArray();
		char firstChar = characters[0];
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "fretoengwnew.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "fretoengw.txt"));
			String line1 = br1.readLine();
			while(line1 != null)
			{
				boolean flag = false;

					if(line1.contentEquals(french))
					{
						flag = true;
						break;
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
			fileReader = new FileReader(firstChar + "fretoengwnew");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "fretoengw");
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
			
		try
		{
			PrintWriter pw = new PrintWriter(firstChar + "fretoengtnew.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "fretoengt.txt"));
			String line1 = br1.readLine();
			while(line1 != null)
			{
				boolean flag = false;

					if(line1.contentEquals(english))
					{
						flag = true;
						break;
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
			fileReader = new FileReader(firstChar + "fretoengtnew");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream(firstChar + "fretoengt");
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
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	} 
	
	/**
	 * Adds an English word and its translation to the dictionary.
	 * Requests both the word and its translation and adds them to the file without writing over them.
	 */
	public void addEngToSpan(boolean test, String testWord, String testWordTwo)
	{
		String english;
		String spanish;
		if(test == false)
		{
			System.out.println("Please enter the word in Englsh to add: "); //Enter the English word.
			Scanner r = new Scanner(System.in);
			english = r.nextLine();
			r.close();
			System.out.println("Please enter the word in Spanish to add: "); // Enter the Spanish translation for that word.
			Scanner s = new Scanner(System.in);
			spanish = s.nextLine();
			s.close();
		} else
		{
			english = testWord;
			spanish = testWordTwo;
		}
		char[] characters = english.toCharArray(); // Get the first letter of the inputted word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "engtospanw.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(english);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "engtospant.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(spanish);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This is the same as the previous method but works for the Spanish word and the English translation of that word.
	 *  I made this separate rather than adding them both automatically in case it could be grammatically incorrect so it gives the user more freedom to add what they want to each.
	 */
	public void addSpanToEng() 
	{
		System.out.println("Please enter the word in Spanish to add: ");
		Scanner r = new Scanner(System.in);
		String spanish = r.nextLine();
		r.close();
		System.out.println("Please enter the word in English to add: ");
		Scanner s = new Scanner(System.in);
		String english = s.nextLine();
		s.close();
		
		char[] characters = spanish.toCharArray();
		char firstChar = characters[0];
		
		try
		{
			FileWriter f = new FileWriter(firstChar + "spantoengw.txt", true);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(spanish);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "spantoengt.txt", true);
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(english);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds an English word and its translation to the dictionary.
	 * Requests both the word and its translation and adds them to the file without writing over them.
	 */
	public void addEngToFre() 
	{
		System.out.println("Please enter the word in Englsh to add: "); //Enter the English word.
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();
		r.close();
		
		System.out.println("Please enter the word in French to add: "); // Enter the French translation for that word.
		Scanner s = new Scanner(System.in);
		String french = s.nextLine();
		s.close();
		
		char[] characters = english.toCharArray(); // Get the first letter of the inputed word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "engtofrew.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(english);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "engtofret.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(french);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * This is the same as the previous method but works for the French word and the English translation of that word.
	 *  I made this separate rather than adding them both automatically in case it could be grammatically incorrect so it gives the user more freedom to add what they want to each.
	 */
	public void addFreToEng() 
	{
		System.out.println("Please enter the word in French to add: ");
		Scanner r = new Scanner(System.in);
		String french = r.nextLine();
		r.close();
		
		System.out.println("Please enter the word in English to add: ");
		Scanner s = new Scanner(System.in);
		String english = s.nextLine();
		s.close();
		
		char[] characters = french.toCharArray();
		char firstChar = characters[0];
		
		try
		{
			FileWriter f = new FileWriter(firstChar + "fretoengw.txt", true);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(french);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "fretoengt.txt", true);
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(english);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * This is method requests a file name and than translates that file and outputs it as a new .txt file.
	 * The user inputs the file name and the name of the Translated file.
	 * Then the file is read in line by line and parsed so each word can be translated and printed.
	 */
	public void translateFileEngToSpan(boolean test, String testWord, String testWordTwo) 
	{
		tree.createAlphabetTree();
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
		String file;
		String translatedFile;
		
		if (test == false)
		{
			System.out.println("Please enter name of file to be translated:"); // Enter the name of the file to be translated.
			Scanner s = new Scanner(System.in);
			file = s.nextLine();
			s.close();
		
			System.out.println("Please enter the name you would like the translated file to have: "); // Enter the name of the new translated file.
			Scanner r = new Scanner(System.in);
			translatedFile = s.nextLine();
			r.close();
		} else 
		{
			file = testWord;
			translatedFile = testWordTwo;
		}
		
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
				for (int i = 0; i < line.length; i++) // Do for each word in the line.
				{
					String temp = translateWord(1, line[i]); // Translate the word.
					printWriter.print(temp + " "); //Print to file.
					System.out.print(temp + " "); //Print to Console.
					nextLine = bufferedReader.readLine(); //Read in the next line.
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but it translates the words from spanish to english.
	 */
	public void translateFileSpanToEng() 
	{
		tree.createAlphabetTree();
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
		r.close();
		
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
				for (int i = 0; i < line.length; i++)
				{
					String temp = translateWord(2, line[i]);
					printWriter.print(temp + " "); 
					System.out.print(temp + " ");
					nextLine = bufferedReader.readLine();
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * This is method requests a file name and than translates that file and outputs it as a new .txt file.
	 * The user inputs the file name and the name of the Translated file.
	 * Then the file is read in line by line and parsed so each word can be translated and printed.
	 */
	public void translateFileEngToFre()
	{
		tree.createAlphabetTree();
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
		r.close();
		
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
				for (int i = 0; i < line.length; i++) // Do for each word in the line.
				{
					String temp = translateWord(3, line[i]); // Translate the word.
					printWriter.print(temp + " "); //Print to file.
					System.out.print(temp + " "); //Print to Console.
					nextLine = bufferedReader.readLine(); //Read in the next line.
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but it translates the words from spanish to english.
	 */
	public void translateFileFreToEng() 
	{
		tree.createAlphabetTree();
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
		r.close();
		
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
				for (int i = 0; i < line.length; i++)
				{
					String temp = translateWord(4, line[i]);
					printWriter.print(temp + " "); 
					System.out.print(temp + " ");
					nextLine = bufferedReader.readLine();
				}
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the add method.
	 * @param english however the word is inputed automatically
	 */
	public void autoAddEngToSpan(String english) 
	{
		System.out.println("The word you would like to enter a translation for is: " + english);
		System.out.println("Please enter the spanish translation for the word: "); // Enter the Spanish translation for that word.
		Scanner s = new Scanner(System.in);
		String spanish = s.nextLine();
		s.close();
		
		char[] characters = english.toCharArray(); // Get the first letter of the inputed word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "engtospanw.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(english);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "engtospant.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(spanish);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but using Spanish to English
	 * @param spanish
	 */
	public void autoAddSpanToEng(String spanish) 
	{
		System.out.println("The word you would like to enter a translation for is: " + spanish);
		System.out.println("Please enter the english translation for the word: "); // Enter the english translation for that word.
		Scanner s = new Scanner(System.in);
		String english = s.nextLine();
		s.close();
		
		char[] characters = spanish.toCharArray(); // Get the first letter of the inputed word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "spantoengw.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(spanish);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "spantoengt.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(english);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but using English to French.
	 * @param spanish
	 */
	public void autoAddEngToFre(String english) 
	{
		System.out.println("The word you would like to enter a translation for is: " + english);
		System.out.println("Please enter the French translation for the word: "); // Enter the French translation for that word.
		Scanner s = new Scanner(System.in);
		String french = s.nextLine();
		s.close();
		
		char[] characters = english.toCharArray(); // Get the first letter of the inputed word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "engtofrew.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(english);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "engtofret.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(french);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * The same as the previous method but using French to English
	 * @param spanish
	 */
	public void autoAddFreToEng(String french) 
	{
		System.out.println("The word you would like to enter a translation for is: " + french);
		System.out.println("Please enter the english translation for the word: "); // Enter the English translation for that word.
		Scanner s = new Scanner(System.in);
		String english = s.nextLine();
		s.close();
		
		char[] characters = french.toCharArray(); // Get the first letter of the inputed word.
		char firstChar = characters[0];
		
		try 
		{
			FileWriter f = new FileWriter(firstChar + "fretoengw.txt", true); // This adds to the file rather than writing over it so it can be added without deleting the file.
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);
			p.println(french);
			p.close();
			
			FileWriter g = new FileWriter(firstChar + "fretoengt.txt", true); // Adds the translation to the translation file.
			BufferedWriter c = new BufferedWriter(g);
			PrintWriter q = new PrintWriter(c);
			q.println(english);
			q.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
	}	
}
