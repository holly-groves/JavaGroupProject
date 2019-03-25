/**
 * 
 */

/**
 * @author Group 13
 *
 */
public class Test {
	
	Tree test = new Tree();
	/**
	 * Method to test creating the alphabet tree
	 */
	public void treeTest() 
	{
		System.out.println("TESTS\n");
		testCreatingTree();
		testDisplayingTreeEngToSpan();
		testDisplayingTreeSpanToEng();
	}
	
	/**
	 * tests creating the alphabet tree
	 */
	public void testCreatingTree()
	{
		//Tree test = new Tree();
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
		System.out.println("Displaying English to Spanish dictionary.....");
		test.displayTreeEngToSpan(test.getRoot());		
		System.out.println("Test complete.");
		System.out.println();
	}
	
	public void testDisplayingTreeSpanToEng()
	{
		System.out.println("Displaying Spanish to English dictionary.....");
		test.displayTreeSpanToEng(test.getRoot());
		System.out.println("Test complete.");
		System.out.println();
	}
}