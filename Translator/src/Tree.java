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
		String letter = Character.toString((char) letterId);
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
	
	public void createTree()
	{
		char current = "m".charAt(0); //sets m as a character 
		int currentAscii = (int) current;
		addLetterToTree(currentAscii);
		
		/*
		 * Creates the right of the tree by adding numbers 14-26
		 * UNBALANCED AND IN THE FORM OF A LINKED LIST
		 */
		for (int i = currentAscii+1; i < 27; i++)
		{
			addLetterToTree(i);
		}
		
		/**
		 * Creates the left of the tree by adding numbers 1-12
		 * UNBALANCED AND IN THE FORM OF A LINKED LIST
		 */
		// for (int j = currentAscii-1; j > 0; j++)
		for (int j = currentAscii-1; j < 123; j++)
		{
			addLetterToTree(j);
		}
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
	
	public void print()
	{
		displayTree(root);
	}
	
	public void displayTree(TreeNode root)
	{
		TreeNode current = root;
		boolean complete = false;
		
		while (!complete)
		{
			if (current == null)
			{
				complete = true;
			}
			else
			{
				TreeNode currentLeft = current.getLeft();
				TreeNode currentRight = current.getRight();
				
				if (currentLeft != null)
				{
					displayTree(currentLeft);
				}
				
				int id = current.getLetterId();
				String engToSpan = current.getEngToSpanFile();
				String spanToEng = current.getSpanToEngFile();
				System.out.println("[" + id + "] " + engToSpan + " - " + spanToEng);
				
				if (currentRight != null)
				{
					displayTree(currentRight);
				}
				
				complete = true;
			}
		}
	}
	
//	public void createAlphabetTree()
//	{
//		char current = "m".charAt(0); //sets m as a character 
//		int currentAscii = (int) current;
//		addLetterToTree(currentAscii);
//		
//		/*
//		 * Create the left of the tree
//		 */
//		currentAscii = currentAscii + 7;
//		for (int i = 3; i > 0; i--)
//		{
//			
//			addLetterToTree(currentAscii - i);
//			addLetterToTree(currentAscii + i);
//			currentAscii
//		}
//	}
}