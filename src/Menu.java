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
	 * runs the menu for the program
	 */
	public void runMenu()
	{
		Translation tran = new Translation();
		int choice = 0;
		boolean exit = false;
		
		do
		{
			System.out.println("Tranlsator");
			System.out.println("1. Translate a word");
			System.out.println("2. Translate a phrase");
			System.out.println("3. Translate from a file");
			System.out.println("4. Search for a translation");
			System.out.println("5. Add a translation");
			System.out.println("6. Remove a translation");
			System.out.println("7. Display dictonaries");
			//option 8. is turning the add a translation setting on and off (Jack)
			System.out.println("9. Run Automated Tests");
			System.out.println("0. Exit");
			
			try
			{
				System.out.println("Enter menu choice: ");
				choice = Integer.parseInt(s.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not a valid menu choice, please enter a number");
			}
			
			if (choice == 1) //translate a word
			{
				System.out.println("Translate a word"); //ADD TRANSLATION TIME (Beth)
				
				int langChoice = getLang();
				
				String word = getWord();
				String translation = "";
				
				if (langChoice == 1) //english to spanish
				{
					translation = tran.translateWord(1, word);
				}
				else if (langChoice == 2) //spanish to english
				{
					translation = tran.translateWord(2, word);
				}
				else //invalid
				{
					System.out.println("Invalid choice, enter again");
					runMenu();
				}
				
				if (translation != null)
				{
					System.out.println(word + " - " + translation);
				}
				else
				{
					System.out.println("No translation found");
					//option to add a translation setting thing goes here (Jack)
				}
			}
			else if (choice == 2) //translate a phrase
			{
				//Michael
			}
			else if (choice == 3) //translate from a file
			{
				//Jack
			}
			else if (choice == 4) //search for a translation
			{
				String word = getWord();
				int lang = getLang();
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
			else if (choice == 5) //add a translation
			{
				//Jack
			}
			else if (choice == 6) //remove a translation
			{
				//Jack
			}
			else if (choice == 7) //display dictionaries
			{
				Tree dictionary = new Tree();
				dictionary.createAlphabetTree();
				Scanner s = new Scanner(System.in);
				
				int i = getLang();
				if (i == 1)
				{
					dictionary.displayTreeEngToSpan(dictionary.getRoot());
				}
				if (i == 2)
				{
					dictionary.displayTreeSpanToEng(dictionary.getRoot());
				}
				if (i == 3)
				{
					dictionary.displayTreeEngToFre(dictionary.getRoot());
				}
				if (i == 4)
				{
					dictionary.displayTreeFreToEng(dictionary.getRoot());
				}
			}
			else if (choice == 8) //turn the add a translation setting thingy on or off
			{
				//Jack
			}
			else if (choice == 9) //run automated tests
			{
				Test test = new Test();
				System.out.println("Tests:"); //Tests need added (everyone)
				test.treeTest();
			}
			else if (choice == 0)
			{
				System.out.println("Goodbye");
				exit = true;
			}
			else
			{
				System.out.println("Invalid menu choice");
			}
		}while (!exit);
		System.exit(0);
	}

	/**
	 * gets the word to be dealt with (translated/searched for/removed) from the user
	 * @return String containing the user's word
	 */
	public String getWord()
	{
		System.out.println("Enter the word to translate: ");
		String word = s.nextLine();
		return word;
	}
	
	/**
	 * gets the language to be translated to from the user
	 * @return int containing which language to use when translating
	 */
	public int getLang()
	{
		int lang = 0;
		System.out.println("1. English to Spanish");
		System.out.println("2. Spanish to English");
		System.out.println("3. English to French");
		System.out.println("4. French to English");
		System.out.println("Enter choice: ");
		try
		{
			System.out.println("Enter menu choice: ");
			lang = Integer.parseInt(s.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Not a valid menu choice, please enter a number");
		}
		return lang;
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