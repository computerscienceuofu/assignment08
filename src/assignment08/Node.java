package assignment08;


/**
 * This Node method is where the Nodes values are kept, such as left and right.  It also keeps the data 
 * of each node.  There's also a few methods such as GetLeft, getLeftMost, GetRight, and getRightMost
 * to help find needed Nodes, mainly for removing items.  
 * @author Chris Murphy && Li Yu
 *
 * @param <T>
 */
public class Node<T> {
	
	T data;
	public Node<T> left;
	public Node<T> right;

	/**
	 * This keeps track of the data, left, and right values.  
	 * @param data - value connected to the Node.
	 * @param left - Left Node connected to the current node.
	 * @param right - Right Node connected to the current node.
	 */
	public Node(T data, Node<T> left, Node<T> right) 
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * This creates a Node with data, left, and right values. 
	 * @param data
	 */
	public Node(T data) 
	{
		this(data, null, null);
	}

	/**
	 * This get's the Left Node from the current position.
	 * @return left node
	 */
	public Node<T> getLeft(){
		return this.left;
	}

	/**
	 * This get's the Right Node from the current position.
	 * @return Right node
	 */
	public Node<T> getRight(){
		return this.right;
	}

	/**
	 * This method recurses down the the left Nodes until there are no more.  
	 * @return The left most Node from the current node.  
	 */
	public Node<T> getLeftMost(){
		if(this.getLeft() == null){
			return this;
		}else{
			return this.left.getLeftMost();
		}
	}

	/**
	 * This method recurses own the right Nodes until there are no more.
	 * @return The right most Node from the current node.
	 * 
	 */
	public Node<T> getRightMost(){
		if(this.getRight() == null){
			return this;
		}
		return this.right.getRightMost();
	}
}



