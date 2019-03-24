/**
 * 
 */

/**
 * @author holly
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
	
	public void createAlphabetTree()
	{
		char current = "m".charAt(0); //sets m as a character 
		int currentAscii = (int) current; //gets the ascii value of m
		addLetterToTree(currentAscii); //adds m to the tree
		
		createBalancedTree(currentAscii-8, 3); //creates the left of the tree
		createBalancedTree(currentAscii+7, 4); //creates the right of the tree
	}
	
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
}
