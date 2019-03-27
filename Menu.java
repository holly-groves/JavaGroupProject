import java.util.Scanner;

/**
 * @author Group 13
 *
 */
public class Menu {

	Scanner s = new Scanner(System.in);
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}

	/**
	 * Runs the translator menu
	 */
	public void runMenu()
	{
		Translation tran = new Translation();
		int lang = 0;
		boolean exit = false;
		
		do
		{
			System.out.println("Translator");
			System.out.println("1. English to Spanish");
			System.out.println("2. Spanish to English");
			System.out.println("3. English to French");
			System.out.println("4. French to English");
			System.out.println("5. Run automated tests");
			System.out.println("0. Exit");
			
			try
			{
				System.out.println("Enter menu choice: ");
				lang = Integer.parseInt(s.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not a valid menu choice, please enter a number");
			}
			
			int option;
			if (lang == 1) //eng to span
			{
				option = getOption();
				processOption(option, lang);
				
			}
			else if (lang == 2) //span to eng
			{
				option = getOption();
				processOption(option, lang);
			}
			else if (lang == 3) //eng to fren
			{
				option = getOption();
				processOption(option, lang);
			}
			else if (lang == 4) //fren to eng
			{
				option = getOption();
				processOption(option, lang);
			}
			else if (lang == 5)
			{
				Test test = new Test();
				test.runTest();
			}
			else if (lang == 0) //exit
			{
				System.out.println("Goodbye");
				exit = true;
			}
			else
			{
				System.out.println("Invalid menu option");
			}
		}while(!exit);
		System.exit(0);
	}
	
	/**
	 * gets the option number entered by the user
	 * @return int storing the option number
	 */
	public int getOption()
	{
		int option = 0;
		System.out.println("What would you like to do?");
		System.out.println("1. Translate a word");
		System.out.println("2. Translate a phrase");
		System.out.println("3. Translate from a file");
		System.out.println("4. Display dictonary");
		System.out.println("5. Search for a translation");
		System.out.println("6. Add a translation");
		System.out.println("7. Remove a translation");
		
		try
		{
			System.out.println("Enter menu choice: ");
			 option = Integer.parseInt(s.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Not a valid menu choice, please enter a number");
		}
		
		return option;
	}

	public void processOption(int opt, int lang)
	{
		Translation tran = new Translation();
		if (opt == 1) //translate a word
		{
			String word = getWord();
			String translation = tran.translateWord(lang, word);
			System.out.println("Translation: " + translation);
		}
		else if (opt == 2) //translate a phrase
		{
			String translate = getPhrase();
			tran.translatePhrase(lang, translate);
		}
		else if (opt == 3) //translate from file
		{
			if (lang == 1)
			{
				tran.translateFileEngToSpan(false, "blank", "blank");
			}
			if (lang == 2)
			{
				tran.translateFileSpanToEng(false, "blank", "blank");
			}
			if (lang == 3)
			{
				tran.translateFileEngToFre(false, "blank", "blank");
			}
			if (lang == 4)
			{
				tran.translateFileFreToEng(false, "blank", "blank");
			}
		}
		else if (opt == 4) //display dictionary
		{
			Tree dictionary = new Tree();
			dictionary.createAlphabetTree();
			if (lang == 1)
			{
				dictionary.displayTreeEngToSpan(dictionary.getRoot());
			}
			if (lang == 2)
			{
				dictionary.displayTreeSpanToEng(dictionary.getRoot());
			}
			if (lang == 3)
			{
				dictionary.displayTreeEngToFre(dictionary.getRoot());
			}
			if (lang == 4)
			{
				dictionary.displayTreeFreToEng(dictionary.getRoot());
			}
		}
		else if (opt == 5) //search for a translation
		{
			String word = getWord();
			int ascii = getAscii(word);
			
			String search = tran.searchWord(lang, ascii, word);
			
			if (search == null) //word not found
			{
				System.out.println("Word not found in the dictonary");
				//option to add a translation setting thing goes here (Jack)
			}
			else
			{
				System.out.println("Word has been found");
				System.out.println(word + " - " + search);
			}	
		}
		else if (opt == 6) //add a translation
		{
			if (lang == 1)
			{
				tran.addEngToSpan(false, "blank", "blank");
			}
			if (lang == 2)
			{
				tran.addSpanToEng(false, "blank", "blank");
			}
			if (lang == 3)
			{
				tran.addEngToFre(false, "blank", "blank");
			}
			if (lang == 4)
			{
				tran.addFreToEng(false, "blank", "blank");
			}
		}
		else if (opt == 7) //remove a translation
		{
			if (lang == 1)
			{
				tran.deleteEngToSpan(false, "blank");
			}
			if (lang == 2)
			{
				tran.deleteSpanToEng(false, "blank");
			}
			if (lang == 3)
			{
				tran.deleteEngToFre(false, "blank");
			}
			if (lang == 4)
			{
				tran.deleteFreToEng(false, "blank");
			}
		}
		else
		{
			System.out.println("Invalid choice");
		}
	}
	
	/**
	 * gets the word from the user
	 * @return String containing the word
	 */
	public String getWord()
	{
		System.out.println("Enter the word to translate: ");
		String word = s.nextLine();
		return word;
	}
	
	/**
	 * gets the phrase from the user 
	 * @return String containing the phrase
	 */
	public String getPhrase()
	{
		System.out.println("Enter the phrase to translate: ");
		String phrase = s.nextLine();
		return phrase;
	}
	
	/**
	 * gets the ascii value of the first letter of a given word
	 * @param word String containing the word 
	 * @return int containing the ascii value of the first letter of the word
	 */
	public int getAscii(String word)
	{
		word = word.toLowerCase(); //puts the word in lower case so the ascii value is of the lowercase first letter
		char letter = word.charAt(0); //gets the first letter in the word
		int  ascii = (int) letter; //gets the ascii value of the first letter
		return ascii;
	}
}