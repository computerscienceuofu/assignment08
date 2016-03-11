package assignment08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * 
 * @author Chris Murphy && Li Yu
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {
	int size = 0;

    Node<T> root;

    
    /**
     * This recursively adds an item to the right or left
     * @param item - item to be added
     * @param node - Starting Node
     * @return
     */
    private Node<T> recursiveAdd(T item, Node<T> node){
    	if(node.data.compareTo(item) > 0){
    		if(node.left == null){
    			node.left = new Node<T>(item);
    			return node;
    		}else{
    			return recursiveAdd(item, node.left);
    		}
    	}else{
    		if(node.right == null){
    			node.right = new Node<T>(item);
    			return node;
    		}else{
    			return recursiveAdd(item, node.right);
    		}
    	}
    }
    
	@Override
	public boolean add(T item) {
		
		if (item == null)
		{
			throw new NullPointerException();
		}
		
		if(contains(item)){
			return false;
		}
		
		if (root == null)
		{
			root = new Node<T>(item);
			size++;
			return true;
		}else{
			recursiveAdd(item, root);
			size++;
			return true;
		}

		

	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		boolean setChange = false;
		for (T temp : items)
		{
			if(add(temp)){
				setChange = true;
			}
		}

		return setChange;
	}

	@Override
	public void clear() {
		this.root = null;
		size = 0;
	}

	private boolean recursiveContains(T item, Node<T> root){
		if(root == null){
			return false;
		}
		if(root.data.equals(item)){
			return true;
		}
		if(root.data.compareTo(item) > 0){
			
			return recursiveContains(item, root.left);
		}else{
			return recursiveContains(item, root.right);
		}
	}
	
	@Override
	public boolean contains(T item) {
		if (item == null)
		{
			throw new NullPointerException();
		}
		return recursiveContains(item, root);
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {
		
		for (T temp : items)
		{
			if (!(this.contains(temp)))
				{
					return false;
				}
		}
		return true;
	}

	@Override
	public T first() throws NoSuchElementException {
		if (this.root == null)
		{
			throw new NoSuchElementException();
		}
		T first = this.root.getLeftMost().data;
		return first;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T last() throws NoSuchElementException {
		if (this.root == null)
		{
			throw new NoSuchElementException();
		}
		
		T last = this.root.getRightMost().data;
		return last;
	}
	
	
	/**
	 * This method searches for the item you wish to remove's parent node.  
	 * @param item - item that's going to be deleted.
	 * @param parent - starting node for the binary search.
	 * @return
	 */
	public Node<T> searchItem(T item, Node<T> parent) {
		if (item == null)
		{
			throw new NullPointerException();
		}
		
		if(parent.data.equals(item)){
			return parent;
		}
		if(parent.left != null){
			if(parent.left.data.equals(item)){
				return parent;
			}
		}else if(parent.right != null){
			if(parent.right.data.equals(item)){
				return parent;
			}
		}
		
		if(parent.data.compareTo(item) > 0){
			return searchItem(item, parent.left);
		}else{
			return searchItem(item, parent.right);
		}
	}
	
	 @Override
		public boolean remove(T item) {

			
			if(contains(item) == false){
				return false;
			}
			
			//tests the root node
			if (item == root.data && root.left == null && root.right == null)
			{
				root = null;
				size--;
				return true;
			}
			else if (item == root.data && root.left != null && root.right == null)
			{
				root = root.left;
				size--;
				return true;
			}
			else if (item == root.data && root.left == null && root.right != null)
			{
				root = root.right;
				size--;
				return true;
			}
			else if (item == root.data && root.left != null && root.right != null)
			{
				size--;
				Node<T> replacement = root.right;
				root.data = replacement.getLeftMost().data;
				return remove(root.right.data, root);
			}
			
			Node<T> current = searchItem(item, root);
			
			return remove(item, current);
			
	}
		
	 /**
	  * This is a helper method for the remove method.  It deletes any node that isn't the root.  
	  * It uses recursion for a node that contains both children.  
	  * @param item - item to be deleted
	  * @param current - current Node to be a starting point for searching the binary tree.  
	  * @return
	  */		
		public boolean remove(T item, Node<T> current) {
			
			current = searchItem(item, current);
			
		while(true)
		{
			//case with no children
			if(current.right != null)
			{
			if (item.compareTo(current.right.data) == 0 && current.right.left == null && current.right.right == null)
			{
				current.right = null;
				size--;
				return true;					
			}
			}
		
			if(current.left != null)
			{
			if (item.compareTo(current.left.data) == 0 && current.left.left == null && current.left.right == null)
			{
				current.left = null;
				size--;
				return true;					
			}
			}
			
		
			
			//case with one child if it's on the left of parent
			
			if((current.left != null))
			{
			if (item.compareTo(current.left.data) == 0 && current.left.right != null && current.left.left == null) 
			{				
				current.left = current.left.right;
				size--;
				return true;
			}
			else if (item.compareTo(current.left.data) == 0 && current.left.right == null && current.left.left != null) 
			{				
				current.left = current.left.left;
				size--;
				return true;
			}
			}
			
		
			//case with one child if it's on the right of parent
			if((current.right != null))
			{
			if (item.compareTo(current.right.data) == 0 && current.right.right != null && current.right.left == null) 
			{				
				current.right = current.right.right;
				size--;
				return true;
			}
			else if (item.compareTo(current.right.data) == 0 && current.right.right == null && current.right.left != null) 
			{				
				current.right = current.right.left;
				size--;
				return true;
			}
			}
		
		
			//case with two children if it's on the right of parent.  This part uses recursion.
			if(current.right != null)
			{
			if (item.compareTo(current.right.data) == 0 && current.right.right != null && current.right.left != null) 
			{			
				size--;
				Node<T> replacement = current.right.right;
				current.right.data = replacement.getLeftMost().data;
				remove(current.right.data, replacement);
			
			}		
			}
		
		
			//case with two children if it's on the left of parent.  This part uses recursion.
			if(item.compareTo(current.left.data) == 0)
			{
			if (item.compareTo(current.left.data) == 0 && current.left.left != null && current.left.right != null) 
			{			
				size--;
				Node<T> replacement = current.left.left;
				current.left.data = replacement.getRightMost().data;
				remove(current.left.data, replacement);
			}
			}
		}
			
			
		
		}

	@Override
	public boolean removeAll(Collection<? extends T> items) {
		boolean removeAllItems = false;
		for (T temp : items)
		{
			if(remove(temp)){
				removeAllItems = true;
			}
		}
		return removeAllItems;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<T> toArrayList() {
		ArrayList<T> toArrayList = new ArrayList<T>();
		recursiveToArray(this.root, toArrayList);
		return toArrayList;
	}

	/**
	 * This is a helper method for the ToArray method.  It recursively adds items from the tree to an array.  
	 * @param root - Root Node
	 * @param toArray - ArrayList<T> to be saved to.  
	 */
	private void recursiveToArray(Node<T> root, ArrayList<T> toArray){
		if(root == null){
			return;
		}else{
			recursiveToArray(root.left, toArray);
			recursiveToArray(root, toArray);
			recursiveToArray(root.right, toArray);
		}
	}
	
	// Driver for writing this tree to a dot file
	/**
	 * This writes the nodes to a file and creates an image to display the path of all the nodes.
	 * @param filename - filename to be saved to
	 */
	public void writeDot(String filename)
	{
		try {
			// PrintWriter(FileWriter) will write output to a file
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			
			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");
			
			if(root != null)
				writeDotRecursive(root, output);
			// Close the graph
			output.println("}");
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

	
	// Recursive method for writing the tree to  a dot file
	/**
	 * 
	 * @param n - starting Node
	 * @param output - PrintWriter
	 * @throws Exception
	 */
	private void writeDotRecursive(Node<T> n, PrintWriter output) throws Exception
	{
		output.println(n.data + "[label=\"<L> |<D> " + n.data + "|<R> \"]");
		if(n.left != null)
		{
			// write the left subtree
			writeDotRecursive(n.left, output);
			
			// then make a link between n and the left subtree
			output.println(n.data + ":L -> " + n.left.data + ":D" );
		}
		if(n.right != null)
		{
			// write the left subtree
			writeDotRecursive(n.right, output);
			
			// then make a link between n and the right subtree
			output.println(n.data + ":R -> " + n.right.data + ":D" );
		}
		
	}

}
