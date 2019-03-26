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
}