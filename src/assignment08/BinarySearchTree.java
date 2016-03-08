package assignment08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {
	int size = 0;

    Node<T> root;


	@Override
	public boolean add(T item) {
		
		Node<T> temp = new Node<T>(item);
		
		if (item == null)
		{
			throw new NullPointerException();
		}
		
		if (root == null)
		{
			root = temp;
			size++;
			
		}

		temp = root;
		
		while(true)
		{
			if ((item.compareTo(temp.data) < 0) && (temp.left == null))
			{
				temp.left = new Node<T>(item);	
				size++;
				return true;
			}
			else if ((item.compareTo(temp.data) < 0) && (temp.left != null))
			{
				temp = temp.left;
			}
			else if ((item.compareTo(temp.data) > 0) && (temp.right == null))
			{
				temp.right = new Node<T>(item);	
				size++;
				return true;
			}
			else if ((item.compareTo(temp.data) > 0) && (temp.right != null))
			{
				temp = temp.right;
			}
			else if ((item.compareTo(temp.data) == 0))
			{
				return false;
			}
		}
		

	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		boolean bool = false;
		
		for (T temp : items)
		{
			if (temp == null)
			{
				throw new NullPointerException();
			}
			
			if (this.add(temp))
				{
				size++;
				bool = true;
				}
			
		}

		return bool;
	}

	@Override
	public void clear() {
		root = null;		
	}

	@Override
	public boolean contains(T item) {
		Node<T> temp = new Node<T>(item);
		
		if (item == null)
		{
			throw new NullPointerException();
		}

		temp = root;
		
		while(true)
		{
			if ((item.compareTo(temp.data) < 0) && (temp.left == null))
			{
				return false;
			}
			else if ((item.compareTo(temp.data) < 0) && (temp.left != null))
			{
				temp = temp.left;
			}
			else if ((item.compareTo(temp.data) > 0) && (temp.right == null))
			{
				return false;
			}
			else if ((item.compareTo(temp.data) > 0) && (temp.right != null))
			{
				temp = temp.right;
			}
			else if ((item.compareTo(temp.data) == 0))
			{
				return true;
			}
		}
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T first() throws NoSuchElementException {
		
		if (root == null)
		{
			throw new NoSuchElementException();
		}
		Node<T> temp;
		temp = root;
		
		while(true)
		{
			if(temp.left == null)
			{
				return temp.data;
			}
			else
			{
				temp = temp.left;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (root == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public T last() throws NoSuchElementException {
		if (root == null)
		{
			throw new NoSuchElementException();
		}
		Node<T> temp;
		temp = root;
		
		while(true)
		{
			if(temp.right == null)
			{
				return temp.data;
			}
			else
			{
				temp = temp.right;
			}
		}
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}


}
