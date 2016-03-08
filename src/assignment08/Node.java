package assignment08;


/**
 * This Node method is where the Nodes values are kept, such as left and right.  It also keeps the data 
 * of each node.
 * @author Chris Murphy && Li Yu
 *
 * @param <T>
 */
public class Node<T> {
	
	T data;
	public Node<T> left = null;
	public Node<T> right = null;
	
	public Node(T data) 
	{
		this.data = data;
	}
			
}



