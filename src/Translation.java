import java.util.Scanner;

/**
 * 
 */

/**
 * @author holly
 *
 */
public class Translation {

	Scanner s = new Scanner(System.in);
	Tree tree = new Tree();
	
	/**
	 * 
	 */
	public void translateWord()
	{
		System.out.println("Enter the word to translate: ");
		String translate = s.nextLine();
		if (translate != null)
		{
			char letter = translate.charAt(0); //gets the first letter in the word
			int  ascii = (int) letter; //gets the ascii value of the first letter
			tree.findNode(ascii); //finds the tree node containing the 
		}
	}
}
