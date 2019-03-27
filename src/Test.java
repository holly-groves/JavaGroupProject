import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Group 13
 *
 */
public class Test {

	/**
	 * Method to test creating the alphabet tree
	 */
	public void runTest() 
	{
		System.out.println("TESTS\n");
		testCreatingTree();
		testDisplayingTreeEngToSpan();
		testDisplayingTreeSpanToEng();
		testFileTranslationEngToSpan();
		testAddAndDeleteEngToSpan();
		testFileTranslationSpanToEng();
		testAddAndDeleteSpanToEng();
		testFileTranslationEngToFre();
		testAddAndDeleteEngToFre();
		testFileTranslationFreToEng();
		testAddAndDeleteFreToEng();
		testTranslateWord();
		testTranslatePhraseEngToSpan();		
		testTranslatePhraseSpanToEng();
		testTranslatePhraseEngToFre();
		testTranslatePhraseFreToEng();

	}

	/**
	 * tests creating the alphabet tree
	 */
	public void testCreatingTree()
	{
		Tree test = new Tree();
		System.out.println("Creating the alphabet tree");
		test.createAlphabetTree();
		System.out.println("\nIn-Order (alphabet)");
		test.printInOrder(test.getRoot());
		System.out.println("\nPre-Order (how the letters are put in to balance the tree");
		test.printPreOrder(test.getRoot());
		System.out.println("Test complete.");
	}

	public void testDisplayingTreeEngToSpan()
	{
		Tree test = new Tree();
		System.out.println("Displaying English to Spanish dictionary.....");
		test.displayTreeEngToSpan(test.getRoot());		
		System.out.println("Test complete.");
		System.out.println();
	}

	public void testDisplayingTreeSpanToEng()
	{
		Tree test = new Tree();
		System.out.println("Displaying Spanish to English dictionary.....");
		test.displayTreeSpanToEng(test.getRoot());
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a English file into an Spanish file
	 */
	public void testFileTranslationEngToSpan()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("Translate a file called test from english to spanish and rename it testTranslated.");
		System.out.println("Original File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateEng.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		translation.translateFileEngToSpan(true, "testToTranslateEng.txt", "testTranslatedEngToSpan.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Translated File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateEngToSpan.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for translating a Spanish file into an English file;
	 */
	public void testFileTranslationSpanToEng()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("Translate a file called test from spanish to english and rename it testTranslated.");
		System.out.println("Original File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateSpan.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		translation.translateFileSpanToEng(true, "testToTranslateSpan.txt", "testTranslatedSpan.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Translated File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateSpan.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a English file into an French file
	 */
	public void testFileTranslationEngToFre()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("Translate a file called test from english to french and rename it testTranslated.");
		System.out.println("Original File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateEng.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		translation.translateFileEngToFre(true, "testToTranslateEng.txt", "testTranslatedEngToFre.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Translated File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateEngToFre.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a French file into an English file;
	 */
	public void testFileTranslationFreToEng()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("Translate a file called test from french to english and rename it testTranslated.");
		System.out.println("Original File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testToTranslateFre.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		translation.translateFileFreToEng(true, "testToTranslateFre.txt", "testTranslatedFre.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Translated File: ");
		System.out.println("");
		try 
		{
			br = new BufferedReader(new FileReader("testTranslatedFre.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for adding a word and its translation to both dictionaries.
	 * And then deleting it.
	 */
	public void testAddAndDeleteEngToSpan()
	{
		BufferedReader br;
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an english to spanish translation to the dictionary).");
		translation.addEngToSpan(true, "myWillToLive", "NonExistent");
		try 
		{
			br = new BufferedReader(new FileReader("mengtospanw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mengtospant.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			} catch (FileNotFoundException e) {
				System.out.println("Error, file not found: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading from files: " + e);
				e.printStackTrace();
		}
		System.out.println("\nDelete a translation (Delete an english to spanish translation called testWord and the translation testWordTranslated)");
		translation.deleteEngToSpan(true, "myWillToLive");
		try 
		{
			br = new BufferedReader(new FileReader("mengtospanw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mengtospant.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for adding a word and its translation to both dictionaries.
	 * And then deleting it.
	 */
	public void testAddAndDeleteSpanToEng()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("\nTest add translation (add a spanish to english translation to the dictionary).");
		translation.addSpanToEng(true, "myWillToLive", "NonExistent");
		try 
		{
			br = new BufferedReader(new FileReader("mspantoengw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mspantoengt.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("\nDelete a translation (Delete an english to spanish translation called testWord and the translation testWordTranslated)");
		translation.deleteSpanToEng(true, "myWillToLive");
		try 
		{
			br = new BufferedReader(new FileReader("mspantoengw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mspantoengt.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for adding a word and its translation to both dictionaries.
	 * And then deleting it.
	 */
	public void testAddAndDeleteEngToFre()
	{
		Translation translation = new Translation();
		BufferedReader br;
		System.out.println("\nTest add translation (add an english to spanish translation to the dictionary).");
		translation.addEngToFre(true, "myWillToLive", "NonExistent");
		try 
		{
			br = new BufferedReader(new FileReader("mengtofrew.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mengtofret.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("\nDelete a translation (Delete an english to french translation called testWord and the translation testWordTranslated)");
		translation.deleteEngToFre(true, "myWillToLive");
		try {
		br = new BufferedReader(new FileReader("mengtofrew.txt"));
		String line = null;
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		br = new BufferedReader(new FileReader("mengtofret.txt"));
		line = null;
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for adding a word and its translation to both dictionaries.
	 * And then deleting it.
	 */
	public void testAddAndDeleteFreToEng()
	{
		BufferedReader br;
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an spanish to english translation to the dictionary).");
		translation.addFreToEng(true, "myWillToLive", "NonExistent");
		try 
		{
			br = new BufferedReader(new FileReader("mfretoengw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mfretoengt.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("\nDelete a translation (Delete an english to french translation called testWord and the translation testWordTranslated)");
		translation.deleteFreToEng(true, "myWillToLive");
		try 
		{
			br = new BufferedReader(new FileReader("mfretoengw.txt"));
			String line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br = new BufferedReader(new FileReader("mfretoengt.txt"));
			line = null;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from files: " + e);
			e.printStackTrace();
		}
		System.out.println("Test complete.");
		System.out.println();
	}


	public void testTranslateWord()
	{
		String word;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		word = "skirt";
		tran = test.translateWord(1, word);
		System.out.println("Translation: " + tran);
		word = "carro";
		tran = test.translateWord(1, word);
		System.out.println("Translation: " + tran);
		word = "open";
		tran = test.translateWord(1, word);
		System.out.println("Translation: " + tran);

		System.out.println();
		word = "salir";
		tran = test.translateWord(2, word);
		System.out.println("Translation: " + tran);
		//		word = "zona";
		//		tran = test.translateWord(2, word);
		//		System.out.println("Translation: " + tran);

		System.out.println();
		word = "chicken";
		tran = test.translateWord(3, word);
		System.out.println("Translation: " + tran);

		System.out.println();
		word = "quintuplement";
		tran = test.translateWord(4, word);
		System.out.println("Translation: " + tran);

		word = "bagarrer";
		tran = test.translateWord(4, word);
		System.out.println("Translation: " + tran);
	}

	public void testTranslatePhraseEngToSpan()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "i want chocolate cake";
		tran = test.translatePhrase(1, phrase);
		System.out.println("Translation: " + tran);
	}
	
	public void testTranslatePhraseSpanToEng()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "buenos días a ti";
		tran = test.translatePhrase(2, phrase);
		System.out.println("Translation: " + tran);
	}
	
	public void testTranslatePhraseEngToFre()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "the library is empty";
		tran = test.translatePhrase(3, phrase);
		System.out.println("Translation: " + tran);
	}
	
	public void testTranslatePhraseFreToEng()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "tourner a droite et arreter";
		tran = test.translatePhrase(4, phrase);
		System.out.println("Translation: " + tran);
	}
}