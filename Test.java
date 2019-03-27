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
				//testCreatingTree();
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
		testTranslateInvalidPhraseEngToSpan();
		testTranslatePhraseSpanToEng();
		testTranslateInvalidPhraseSpanToEng();
		testTranslatePhraseEngToFre();
		testTranslateInvalidPhraseEngToFre();
		testTranslatePhraseFreToEng();
		testTranslateInvalidPhraseFreToEng();

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

	/**
	 * Test displaying the English to Spanish dictionary
	 */
	public void testDisplayingTreeEngToSpan()
	{
		Tree test = new Tree();
		System.out.println("Displaying English to Spanish dictionary.....");
		test.displayTreeEngToSpan(test.getRoot());		
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Test displaying the Spanish to English dictionary
	 */
	public void testDisplayingTreeSpanToEng()
	{
		Tree test = new Tree();
		System.out.println("Displaying Spanish to English dictionary.....");
		test.displayTreeSpanToEng(test.getRoot());
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a file. (English to Spanish)
	 */
	public void testFileTranslationEngToSpan()
	{
		Translation translation = new Translation();
		System.out.println("Translate a file called test from english to spanish and rename it testTranslated.");
		translation.translateFileEngToSpan(true, "testToTranslate.txt", "testTranslated.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for translating a file. (Spanish to English)
	 */
	public void testFileTranslationSpanToEng()
	{
		Translation translation = new Translation();
		System.out.println("Translate a file called test from spanish to english and rename it testTranslated.");
		translation.translateFileSpanToEng(true, "testToTranslate.txt", "testTranslated.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a file. (English to French)
	 */
	public void testFileTranslationEngToFre()
	{
		Translation translation = new Translation();
		System.out.println("Translate a file called test from english to french and rename it testTranslated.");
		translation.translateFileEngToFre(true, "testToTranslate.txt", "testTranslated.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a file. (French to English)
	 */
	public void testFileTranslationFreToEng()
	{
		Translation translation = new Translation();
		System.out.println("Translate a file called test from french to english and rename it testTranslated.");
		translation.translateFileFreToEng(true, "testToTranslate.txt", "testTranslated.txt"); // will need a file called test.txt with a few random words on it.
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for adding and deleting a translation. (English to Spanish)
	 */
	public void testAddAndDeleteEngToSpan()
	{
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an english to spanish translation to the dictionary).");
		translation.addEngToSpan(true, "myWillToLive", "NonExistent");
		System.out.println("\nDelete a translation (Delete an english to spanish translation called testWord and the translation testWordTranslated)");
		translation.deleteEngToSpan(true, "myWillToLive");
		System.out.println("Test complete.");
		System.out.println();
	}
	
	/**
	 * Automated testing for adding and deleting a translation. (Spanish to English)
	 */
	public void testAddAndDeleteSpanToEng()
	{
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an spanish to english translation to the dictionary).");
		translation.addSpanToEng(true, "myWillToLive", "NonExistent");
		System.out.println("\nDelete a translation (Delete an english to spanish translation called testWord and the translation testWordTranslated)");
		translation.deleteSpanToEng(true, "myWillToLive");
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for adding and deleting a translation. (English to French)
	 */
	public void testAddAndDeleteEngToFre()
	{
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an english to spanish translation to the dictionary).");
		translation.addEngToFre(true, "myWillToLive", "NonExistent");
		System.out.println("\nDelete a translation (Delete an english to french translation called testWord and the translation testWordTranslated)");
		translation.deleteEngToFre(true, "myWillToLive");
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for adding and deleting a translation. (French to English)
	 */
	public void testAddAndDeleteFreToEng()
	{
		Translation translation = new Translation();
		System.out.println("\nTest add translation (add an spanish to english translation to the dictionary).");
		translation.addFreToEng(true, "myWillToLive", "NonExistent");
		System.out.println("\nDelete a translation (Delete an english to french translation called testWord and the translation testWordTranslated)");
		translation.deleteFreToEng(true, "myWillToLive");
		System.out.println("Test complete.");
		System.out.println();
	}

	/**
	 * Automated testing for translating a word
	 * 1 - English to Spanish
	 * 2 - Spanish to English
	 * 3 - English to French
	 * 4 - French to English
	 */
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

	/**
	 * Automated testing for translating a phrase. (English to Spanish)
	 */
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
	
	/**
	 * Automated testing for translating an invalid phrase. (English to Spanish)
	 */
	public void testTranslateInvalidPhraseEngToSpan()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "the rocket ship launches";
		tran = test.translatePhrase(1, phrase);
		//System.out.println("Translation: " + tran);
		System.out.println("No translation found.");
	}
	
	/**
	 * Automated testing for translating a phrase. (Spanish to English)
	 */
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
	/**
	 * Automated testing for translating an invalid phrase. (Spanish to English)
	 */
	public void testTranslateInvalidPhraseSpanToEng()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "yo perdió mi capa";
		tran = test.translatePhrase(2, phrase);
		//System.out.println("Translation: " + tran);
		System.out.println("No translation found.");
	}
	
	/**
	 * Automated testing for translating a phrase. (English to French)
	 */
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
	
	/**
	 * Automated testing for translating an invalid phrase. (English to French)
	 */
	public void testTranslateInvalidPhraseEngToFre()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "this is puzzling";
		tran = test.translatePhrase(3, phrase);
		//System.out.println("Translation: " + tran);
		System.out.println("No translation found.");
	}
	
	/**
	 * Automated testing for translating a phrase. (French to English)
	 */
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
	
	/**
	 * Automated testing for translating an invalid phrase. (French to English)
	 */
	public void testTranslateInvalidPhraseFreToEng()
	{
		String phrase;
		String tran;
		Translation test = new Translation();
		Tree tree = new Tree();
		tree.createAlphabetTree();
		System.out.println("Translate");
		phrase = "ils se battent encore";
		tran = test.translatePhrase(4, phrase);
		//System.out.println("Translation: " + tran);
		System.out.println("No translation found.");
	}
}