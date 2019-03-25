import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Group 13
 *
 */
public class Tree {
	
	private TreeNode root; //stores the root of the tree
	
	/**
	 * Default constructor to initialise fields
	 */
	public Tree()
	{
		root = null;
	}

	/**
	 * Gets the tree node that is the root of the tree
	 * @return TreeNode that is the root of the tree
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * Sets the root node
	 * @param rootNode node to be set as the root
	 */
	public void setRoot(TreeNode rootNode)
	{
		root = rootNode;
	}
	
	/**
	 * adds all the letters to a binary tree using ascii values (lowercase)
	 * @param letterId int containing the ascii value of the letter to be added
	 * @return boolean containing whether or not the letter has been added
	 */
	public boolean addLetterToTree(int letterId)
	{
		TreeNode newNode;
		TreeNode current;
		TreeNode currentLeft;
		TreeNode currentRight;
		boolean complete = false; //this will be used for the while loop and the return

		/**
		 * Sets what the name of the translation files will be 
		 */
		String letter = Character.toString((char) letterId); //gets the letter of the ascii value
		String fileEngToSpan = letter + "EngToSpan"; //file for English to Spanish translations
		String fileSpanToEng = letter + "SpanToEng"; //file for Spanish to English translations
		
		
		
		newNode = new TreeNode(letterId, fileEngToSpan, fileSpanToEng);

		if (root == null)
		{
			root = newNode;
		}
		else
		{
			current = root;
			int newId = newNode.getLetterId();

			while (!complete)
			{
				int currentId = current.getLetterId();

				if (newId == currentId) //if the node is a duplicate tree node, nothing is added
				{
					complete = true;
				}
				else if (newId < currentId) //going left in the tree
				{
					currentLeft = current.getLeft();

					if (currentLeft == null)
					{
						current.setLeft(newNode);
						complete = true;
					}
					else
					{
						current = currentLeft;
					}
				}
				else if (newId > currentId) //going right in the tree
				{
					currentRight = current.getRight();

					if (currentRight == null)
					{
						current.setRight(newNode);
						complete = true;
					}
					else
					{
						current = currentRight;
					}
				}
			}
		}
		return complete;
	}
	
	/**
	 * finds a node wihtin the binary tree
	 * @param requiredId int containing the id of the node to be found
	 * @return TreeNode containing a reference to the found node (if it is found)
	 */
	public TreeNode findNode(int requiredId)
	{
		TreeNode current = root;
		boolean complete = false;

		while (!complete) //repeat until the search is complete
		{
			if (current == null) //item not found
			{
				return null;
			}
			else
			{
				int currentId = current.getLetterId();

				if (currentId == requiredId) //item found
				{					
					complete = true;
				}
				else
				{
					TreeNode currentLeft = current.getLeft();
					TreeNode currentRight = current.getRight();

					if (currentId > requiredId) //go left down the tree and continue search
					{
						current = currentLeft;
					}
					else if (currentId < requiredId) //go right down the tree and continue search
					{
						current = currentRight;
					}
				}
			}
		}
		return current;
	}
	
	/**
	 * creates the binary tree of the alphabet in a way so the tree is balanced to minimise search times
	 * the ascii values of the lowercase letters are used to make comparing id easier
	 * also as most words begin with lowercase letters, this will make finding translations easier
	 */
	public void createAlphabetTree()
	{
		char current = "m".charAt(0); //sets m as a character 
		int currentAscii = (int) current; //gets the ascii value of m
		addLetterToTree(currentAscii); //adds m to the tree
		
		createBalancedTree(currentAscii-8, 3); //creates the left of the tree
		createBalancedTree(currentAscii+7, 4); //creates the right of the tree
	}
	
	/**
	 * Recursive method to add the letters to the tree in the right order to make the tree balanced
	 * @param current int containing the current ascii value to be dealt with
	 * @param dif int containing the difference to be used in adding things to the tree
	 */
	public void createBalancedTree(int current, int dif)
	{
		if (current > 96 && current < 107 && dif > 0) //this deals with the left side of the tree
		{
			addLetterToTree(current);
			addLetterToTree(current+dif);
			addLetterToTree(current-dif);
			createBalancedTree(current+dif, dif--);
			createBalancedTree(current-dif, dif--);
		}
		else if (current > 109 && current < 120 && dif > 0) //this deals with the right side of the tree
		{
			addLetterToTree(current);
			addLetterToTree(current+dif);
			addLetterToTree(current-dif);
			createBalancedTree(current+dif, dif--);
			createBalancedTree(current-dif, dif--);
		}
	}
	
	/**
	 * Method to call another method to print the tree depending on the choice passed to it
	 * 1: prints the tree in order
	 * 2: prints the tree pre order
	 * 3. prints the tree post order
	 * 
	 * @param choice int containing the choice of which why to display the tree
	 */
	public void printTree(int choice)
	{		
		if (choice == 1) //if the items will be displayed in-order
		{
			printInOrder(root);
		}
		else if (choice == 2) //if the items will be displayed pre-order
		{
			printPreOrder(root);
		}
		else if (choice == 3) //if the items will be displayed post-order
		{
			printPostOrder(root);
		}
	}

	/**
	 * recursive method to print the tree in order
	 * @param currentNode TreeNode that is being processed
	 */
	public void printInOrder(TreeNode currentNode)
	{		
		if (currentNode != null) //if there isn't a current node, there is nothing to display
		{
			TreeNode currentLeft = currentNode.getLeft();
			TreeNode currentRight = currentNode.getRight();

			printInOrder(currentLeft); //recursion
			printDetails(currentNode);
			printInOrder(currentRight); //recursion
		}
	}

	/**
	 * Recursive method to print the tree pre order
	 * @param currentNode TreeNode that is being processed
	 */
	public void printPreOrder(TreeNode currentNode)
	{
		if (currentNode != null)
		{
			TreeNode currentLeft = currentNode.getLeft();
			TreeNode currentRight = currentNode.getRight();

			printDetails(currentNode);
			printPreOrder(currentLeft); //recursion
			printPreOrder(currentRight); //recursion
		}
	}

	/**
	 * Recursive method to print the tree post order
	 * @param currentNode TreeNode that is being processed
	 */
	public void printPostOrder(TreeNode currentNode)
	{
		if (currentNode != null)
		{
			TreeNode currentLeft = currentNode.getLeft();
			TreeNode currentRight = currentNode.getRight();

			printPostOrder(currentLeft); //recursion
			printPostOrder(currentRight); //recursion
			printDetails(currentNode);
		}
	}
	
	/**
	 * displays the details of the node 
	 * @param node TreeNode to be displayed
	 */
	public void printDetails(TreeNode node)
	{
		int id = node.getLetterId();
		String letter = Character.toString((char) id);
		System.out.println(letter);
	}
	
//	/**
//	 * Method used to display all the dictionaries
//	 * @param root TreeNode containing the root of the tree
//	 */
//	public void displayTree(TreeNode root)
//	{
//		FileReader fileReader1 = null;
//		BufferedReader bufferedReader1 = null;
//		String nextLine1;
//		FileReader fileReader2 = null;
//		BufferedReader bufferedReader2 = null;
//		String nextLine2;
//		
//		TreeNode current = root;
//		boolean complete = false;
//		while (!complete)
//		{
//			if (current == null)
//			{
//				complete = true;
//			}
//			else
//			{
//				TreeNode currentLeft = current.getLeft();
//				TreeNode currentRight = current.getRight();
//
//				if (currentLeft != null)
//				{
//					displayTree(currentLeft);
//				}
//
//				int id = current.getLetterId();
//				String letter = Character.toString((char) id);
//				String fileEngToSpanWords = letter + "engtospanw.txt";
//				String fileEngToSpanTranslations = letter + "engtospant.txt";
//				System.out.println(letter);
//				System.out.println();
//				
//				try
//				{
//					fileReader1 = new FileReader(fileEngToSpanWords);
//					bufferedReader1 = new BufferedReader(fileReader1);
//					nextLine1 = bufferedReader1.readLine();
//					
//					fileReader2 = new FileReader(fileEngToSpanTranslations);
//					bufferedReader2 = new BufferedReader(fileReader2);
//					nextLine2 = bufferedReader2.readLine();
//					
//					while (nextLine1 != null || nextLine2 != null)
//					{
//						System.out.println(nextLine1 + " - " + nextLine2);
//						nextLine1 = bufferedReader1.readLine();
//						nextLine2 = bufferedReader2.readLine();
//					}
//					bufferedReader1.close();
//				}
//				
//				catch (IOException e)
//				{
//					System.out.println("IO Error reading from file: " + e);
//				}				
//
//				System.out.println();
//				
//    			if (currentRight != null)
//				{
//					displayTree(currentRight);
//				}
//
//				complete = true;
//			}
//		}
//	}
	
	/**
	 * Method used to display the dictionary for English into Spanish
	 * @param root TreeNode containing the root of the tree
	 */
	public void displayTreeEngToSpan(TreeNode root)
	{
		FileReader fileReader1 = null;
		BufferedReader bufferedReader1 = null;
		String nextLine1;
		FileReader fileReader2 = null;
		BufferedReader bufferedReader2 = null;
		String nextLine2;
		
		TreeNode current = root;
		boolean complete = false;
		while (!complete)
		{
			if (current == null) // if tree is empty then skip, as there's nothing to display
			{
				complete = true;
			}
			else
			{
				TreeNode currentLeft = current.getLeft();
				TreeNode currentRight = current.getRight();

				if (currentLeft != null)
				{
					displayTreeEngToSpan(currentLeft); // recursive; go left if the current node's left subtree exists
				}

				int id = current.getLetterId();
				String letter = Character.toString((char) id);
				String fileEngToSpanWords = letter + "engtospanw.txt";
				String fileEngToSpanTranslations = letter + "engtospant.txt";
				
				System.out.println(letter + " (English to Spanish)");
				System.out.println();
				
				try
				{
					fileReader1 = new FileReader(fileEngToSpanWords); // reads in English words
					bufferedReader1 = new BufferedReader(fileReader1);
					nextLine1 = bufferedReader1.readLine();
					
					fileReader2 = new FileReader(fileEngToSpanTranslations); // reads in translations to Spanish
					bufferedReader2 = new BufferedReader(fileReader2);
					nextLine2 = bufferedReader2.readLine();
					
					while (nextLine1 != null || nextLine2 != null)
					{
						System.out.println(nextLine1 + " - " + nextLine2); // display the word with its translation
						nextLine1 = bufferedReader1.readLine();
						nextLine2 = bufferedReader2.readLine();
					}
					bufferedReader1.close();
					bufferedReader2.close();
				}
				
				catch (IOException e)
				{
					System.out.println("IO Error reading from file: " + e);
				}				

				System.out.println();
				
    			if (currentRight != null) 
				{
					displayTreeEngToSpan(currentRight); // recursive; go right if current node's right subtree exists
				}

				complete = true;
			}
		}
	}
	
	/**
	 * Method used to display the dictionary for Spanish into English
	 * @param root TreeNode containing the root of the tree
	 */
	public void displayTreeSpanToEng(TreeNode root)
	{
		FileReader fileReader1 = null;
		BufferedReader bufferedReader1 = null;
		String nextLine1;
		FileReader fileReader2 = null;
		BufferedReader bufferedReader2 = null;
		String nextLine2;
		
		TreeNode current = root;
		boolean complete = false;
		while (!complete)
		{
			if (current == null) // if tree is empty then skip, as there's nothing to display
			{
				complete = true;
			}
			else
			{
				TreeNode currentLeft = current.getLeft();
				TreeNode currentRight = current.getRight();

				if (currentLeft != null) // go left if the current node's left subtree exists
				{
					displayTreeSpanToEng(currentLeft);
				}

				int id = current.getLetterId();
				String letter = Character.toString((char) id);
				String fileSpanToEngWords = letter + "spantoengw.txt";
				String fileSpanToEngTranslations = letter + "spantoengt.txt";
				
				System.out.println(letter + " (Spanish to English)");
				System.out.println();
				
				try
				{
					fileReader1 = new FileReader(fileSpanToEngWords); // reads in Spanish words
					bufferedReader1 = new BufferedReader(fileReader1);
					nextLine1 = bufferedReader1.readLine();
					
					fileReader2 = new FileReader(fileSpanToEngTranslations); // reads in translations to English
					bufferedReader2 = new BufferedReader(fileReader2);
					nextLine2 = bufferedReader2.readLine();
					
					while (nextLine1 != null || nextLine2 != null)
					{
						System.out.println(nextLine1 + " - " + nextLine2); // display the word with its translation
						nextLine1 = bufferedReader1.readLine();
						nextLine2 = bufferedReader2.readLine();
					}
					bufferedReader1.close();
					bufferedReader2.close();
				}
				
				catch (IOException e)
				{
					System.out.println("IO Error reading from file: " + e);
				}				

				System.out.println();
				
    			if (currentRight != null) // go right if current node's right subtree exists
				{
					displayTreeSpanToEng(currentRight);
				}

				complete = true;
			}
		}
	}

}
