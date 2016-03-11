package assignment08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;

public class BinarySearchTreeTester {
	BinarySearchTree<Integer> testBST;
	
	@Test
	public void testAdd() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		assertTrue(testBST.add(5));
		assertTrue(testBST.add(20));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddException(){
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(null);
		
	}
	
	@Test
	public void testAddAll() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(5);
		test.add(10);
		assertEquals(true, testBST.addAll(test));
	}
	
	@Test
	public void testAddAll2() {
		BinarySearchTree<String> testBST = new BinarySearchTree<String>();
		ArrayList<String> test = new ArrayList<String>();
		testBST.add("frog");
		testBST.add("cat");
		testBST.add("elephant");
		testBST.add("dog");
		assertEquals(true, testBST.contains("frog"));
	}
	
	@Test
	public void testAddAll3() {
		BinarySearchTree<String> testBST = new BinarySearchTree<String>();
		testBST.add("frog");
		testBST.add("cat");
		testBST.add("elephant");
		testBST.add("dog");
		testBST.remove("frog");
		testBST.remove("elephant");
		assertEquals(true, testBST.contains("dog"));
	}
	
	@Test
	public void testAddAll4() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(5);
		testBST.add(7);
		testBST.add(9);
		testBST.add(3);
		assertEquals(true, testBST.contains(3));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddAllException(){
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(null);
		testBST.addAll(test);
	}
	
	@Test
	public void testClear() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(5);
		assertEquals(1,testBST.size());
		testBST.clear();
		assertEquals(0,testBST.size());
		
	}
	
	@Test
	public void testContains() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(16);
		assertTrue(testBST.contains(16));
		assertFalse(testBST.contains(1));
		testBST.clear();
		assertFalse(testBST.contains(16));
	}
	
	@Test(expected=NullPointerException.class)
	public void testContainsException(){
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.contains(null);
	}
	
	@Test
	public void testContainsAll() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(true, testBST.addAll(test));
	}
	
	@Test(expected=NullPointerException.class)
	public void testContainsAllException(){
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(null);
		testBST.addAll(test);
	}
	
	@Test
	public void testIsEmpty() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		assertTrue(testBST.isEmpty());
	}
	
	@Test
	public void testSize() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(5);
		assertEquals(1, testBST.size());
	}
	
	@Test
	public void testFirst() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(10);
		testBST.add(5);
		testBST.add(7);
		assertEquals(5,(int)testBST.first());
	}

	@Test
	public void testLast() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(10);
		testBST.add(5);
		testBST.add(7);
		assertEquals(10,(int)testBST.last());
	}
	
	@Test
	public void testRemove() {
		BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
		testBST.add(15);
		testBST.add(10);
		testBST.add(7);
		testBST.add(8);
		
		testBST.remove(7);
		testBST.remove(10);
		assertEquals(false,testBST.contains(7));
		assertEquals(false,testBST.contains(10));
	}
	
}