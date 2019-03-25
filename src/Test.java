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
}
