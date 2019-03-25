import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}
