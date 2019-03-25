import java.util.Scanner;
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
		// Tree test = new Tree();
		test.createAlphabetTree();
		test.displayTreeEngToSpan(test.getRoot());
		test.displayTreeSpanToEng(test.getRoot());
	}
	
}