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
	public void treeTest() 
	{
		System.out.println("TESTS\n");
		testCreatingTree();
		testDisplayingTreeEngToSpan();
		testDisplayingTreeSpanToEng();
		testTranslation();
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
	 * Automated testing for; translate file, add and delete method.
	 */
	public void testTranslation()
	{
		Translation translation = new Translation();
		System.out.println("Translate a file called test from english to spanish and rename it testTranslated.");
		translation.testTranslateFileEngToSpan(); // will need a file called test.txt with a few random words on it.
		System.out.println("\nTest add translation (add an english to spanish translation to the dictionary).");
		translation.testAddEngToSpan();
		System.out.println("\nDelete a translation (Delete an english to spanish translation called testWord and the translation testWordTranslated)");
		translation.testDeleteEngToSpan();
		System.out.println("Test complete.");
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
		word = "carrot";
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
		phrase = "tourner à droite et aller tout droit";
		tran = test.translatePhrase(4, phrase);
		System.out.println("Translation: " + tran);
	}
}