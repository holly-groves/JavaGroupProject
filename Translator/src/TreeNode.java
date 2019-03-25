/**
 * 
 *
 */
public class TreeNode {

	private int letterId; //this will contain the lower case ASCII value
	private String engToSpanFile;
	private String spanToEngFile;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode()
	{
		letterId = 0;
		engToSpanFile = "";
		spanToEngFile = "";
		left = null;
		right = null;
	}
	
	/**
	 * Default constructor to initialise fields
	 * @param id int containing what is to be set as the letter id
	 */
	public TreeNode(int id, String engToSpan, String spanToEng)
	{
		this.letterId = id;
		this.engToSpanFile = engToSpan;
		this.spanToEngFile = spanToEng;
		
		this.left = null;
		this.right = null;
	}

	/**
	 * gets the id of a tree node
	 * @return int containing the id
	 */
	public int getLetterId() {
		return letterId;
	}

	/**
	 * Sets the id of a tree node
	 * @param letterId int containing the id to be set
	 */
	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public String getEngToSpanFile() {
		return engToSpanFile;
	}

	public void setEngToSpanFile(String engToSpanFile) {
		this.engToSpanFile = engToSpanFile;
	}

	public String getSpanToEngFile() {
		return spanToEngFile;
	}

	public void setSpanToEngFile(String spanToEngFile) {
		this.spanToEngFile = spanToEngFile;
	}

	/**
	 * Gets the node left of the current tree node
	 * @return TreeNode containing a reference to the left node
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * Sets the tree node left of the current node
	 * @param left TreeNode containing a reference to the node to be set left
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * Gets the node right of the current node
	 * @return TreeNode containing a reference to the left node
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * Sets the node right of the current node
	 * @param right TreeNode containing a reference to the node to be set right
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
}