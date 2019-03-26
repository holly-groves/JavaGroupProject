import java.util.Scanner;

/**
 * @author Group 13
 *
 */
public class Menu {

	int addWords = 0;
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
				else if (langChoice == 3) //english to french
				{
					translation = tran.translateWord(3, word);
				}
				else if (langChoice == 4) //french to english
				{
					translation = tran.translateWord(4, word);
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
					if(addWords == 1)
					{
						if (langChoice == 1) 
						{
							tran.autoAddEngToSpan(word);//option to add a translation setting thing goes here (Jack)
						} else if(langChoice == 2)
						{
							tran.autoAddSpanToEng(word);
						} else if(langChoice == 3)
						{
							tran.autoAddEngToFre(word);
						} else if(langChoice == 4)
						{
							tran.autoAddFreToEng(word);
						}
					}//option to add a translation setting thing goes here (Jack)
				}
			}
			else if (choice == 2) //translate a phrase
			{
				System.out.println("Translate a phrase: ");
				
				int langChoice = getLang();
				
				String phrase = getPhrase();
				String translatePhrase = "";
				
				if (langChoice == 1) // English to Spanish
				{
					translatePhrase = tran.translateWord(1, phrase);
					if (translatePhrase == null)
					{
						translatePhrase = "";
						String[] splitWords = phrase.split("\\s+");
						for (int i = 0; i < splitWords.length; i++)
						{
							splitWords[i] = splitWords[i].replaceAll("[^\\w]", "");
						}
						for (int i = 0; i < splitWords.length; i++)
						{
							translatePhrase = tran.translateWord(1, splitWords[i]) + " ";
						}
						if (translatePhrase != null)
						{
							System.out.println(phrase + " - " + translatePhrase);
						}
						else
						{
							System.out.println("No translation found.");
							
						}
					}
					else
					{
						System.out.println(phrase + " - " + translatePhrase);
					}
				}
				
				else if (langChoice == 2) // Spanish to English
				{
					translatePhrase = tran.translateWord(2, phrase);
					if (translatePhrase == null)
					{
						translatePhrase = "";
						String[] splitWords = phrase.split("\\s+");
						for (int i = 0; i < splitWords.length; i++)
						{
							splitWords[i] = splitWords[i].replaceAll("[^\\w]", "");
						}
						for (int i = 0; i < splitWords.length; i++)
						{
							translatePhrase = tran.translateWord(2, splitWords[i]) + " ";
						}
						if (translatePhrase != null)
						{
							System.out.println(phrase + " - " + translatePhrase);
						}
						else
						{
							System.out.println("No translation found.");
						}
					}
					else
					{
						System.out.println(phrase + " - " + translatePhrase);
					}
				}
				
				else if (langChoice == 3) // English to French
				{
					translatePhrase = tran.translateWord(3, phrase);
					if (translatePhrase == null)
					{
						translatePhrase = "";
						String[] splitWords = phrase.split("\\s+");
						for (int i = 0; i < splitWords.length; i++)
						{
							splitWords[i] = splitWords[i].replaceAll("[^\\w]", "");
						}
						for (int i = 0; i < splitWords.length; i++)
						{
							translatePhrase = tran.translateWord(3, splitWords[i]) + " ";
						}
						if (translatePhrase != null)
						{
							System.out.println(phrase + " - " + translatePhrase);
						}
						else
						{
							System.out.println("No translation found.");
						}
					}
					else
					{
						System.out.println(phrase + " - " + translatePhrase);
					}
				}
				
				else if (langChoice == 4) // French to English
				{
					translatePhrase = tran.translateWord(4, phrase);
					if (translatePhrase == null)
					{
						translatePhrase = "";
						String[] splitWords = phrase.split("\\s+");
						for (int i = 0; i < splitWords.length; i++)
						{
							splitWords[i] = splitWords[i].replaceAll("[^\\w]", "");
						}
						for (int i = 0; i < splitWords.length; i++)
						{
							translatePhrase = tran.translateWord(4, splitWords[i]) + " ";
						}
						if (translatePhrase != null)
						{
							System.out.println(phrase + " - " + translatePhrase);
						}
						else
						{
							System.out.println("No translation found.");
						}
					}
					else
					{
						System.out.println(phrase + " - " + translatePhrase);
					}
				}
				else //invalid
				{
					System.out.println("Invalid choice, enter again");
					runMenu();
				}
				
			}
			else if (choice == 3) //translate from a file          this needs to be added!!!!!!!!!!!!!
			{
				int langChoice = getLang();
				if (langChoice == 1)
				{
					tran.translateFileEngToSpan(false, "blank", "blank");
				}
				if (langChoice == 2)
				{
					tran.translateFileSpanToEng();
				}
				if (langChoice == 3)
				{
					tran.translateFileEngToFre();
				}
				if (langChoice == 4)
				{
					tran.translateFileFreToEng();
				}//Jack
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
			else if (choice == 5) //add a translation         this needs to be added!!!!!!!!!!!!!
			{
				int langChoice = getLang();
				if (langChoice == 1)
				{
					tran.addEngToSpan(false, "blank", "blank");
				}
				if (langChoice == 2)
				{
					tran.addSpanToEng();
				}
				if (langChoice == 3)
				{
					tran.addEngToFre();
				}
				if (langChoice == 4)
				{
					tran.addFreToEng();
				}//Jack
			}
			else if (choice == 6) //remove a translation         this needs to be added!!!!!!!!!!!!!
			{
				int langChoice = getLang();
				if (langChoice == 1)
				{
					tran.deleteEngToSpan(false, "blank");
				}
				if (langChoice == 2)
				{
					tran.deleteSpanToEng();
				}
				if (langChoice == 3)
				{
					tran.deleteEngToFre();
				}
				if (langChoice == 4)
				{
					tran.deleteFreToEng();
				}//Jack
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
				if (addWords == 1)
				{
					System.out.println("You have de-activated the auto add translation feature.");
					addWords = 0;
				} else if (addWords == 0)
				{
					System.out.println("You have activated the auto add translation feature.");
					addWords = 1;
				}//Jack
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
	
	public String getPhrase()
	{
		System.out.println("Enter the phrase to translate: ");
		String phrase = s.nextLine();
		return phrase;
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