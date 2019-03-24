/**
 * 
 */

/**
 * @author holly
 *
 */
public class Test {
	
	/**
	 * Method to test creating the alphabet tree
	 */
	public void treeTest() 
	{
		Tree test = new Tree();
		test.createAlphabetTree();
		test.printTree(2);
		System.out.println();
		test.printTree(1);
		System.out.println();
		test.printTree(3);
	}
}
