package assignment08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import org.junit.Test;



public class JunitTesting {
	BinarySearchTree<String> tester = new BinarySearchTree<String>();
	TreeSet<String> treeTester = new TreeSet<String>();
	
	static long startTime = 0;
	static long stopTime = 0;
	static long aveTime = 0;
	static long listsize = 0;


	@Test
	public void TimingTest() throws IOException{
		try(FileWriter fw = new FileWriter(new File("visualization/data.csv"))) { //open up a file writer so we can write to file.
			
			fw.write("Contains BST timer" + "\t" + "Current Iteration of searching for an item" + "\t" + "Time in NanoSeconds it takes to run the Contains method" + "\n");
			
			
			BinarySearchTree<Integer> timetester = new BinarySearchTree<Integer>();
			BinarySearchTree<Integer> timetesterRandom = new BinarySearchTree<Integer>();
			
				//creates a sorted BST of 1000 sequential numbers
				for (int i= 0; i < 10000; i++)
				{	
					timetester.add(i);						
				}
				
			
				//runs the contains method
				for (int i= 0; i < 10000; i++)
				{	
					timetester.contains(i);	
					if(i % 100 == 0)
					{		
					i++;
					startTime = System.nanoTime();
					timetester.contains(i);		
					stopTime = System.nanoTime();
					aveTime = stopTime - startTime;
					fw.write("Contains method (SORTED VALUE) timer with 0 to 10000 items" + "\t" + i + "\t" + aveTime + "\n"); // write to file.
					}
				}
				//Creates a random Array of 10000			
				 Integer[] randomArray = new Integer[10000];
				 for (int i = 0; i < randomArray.length; i++) 
				 {
				     randomArray[i] = i;
				 }				 
				    Collections.shuffle(Arrays.asList(randomArray));
				    
				    //Adds the list of random numbers to a BST
				   for(Integer rand : randomArray)
				   {
					   timetesterRandom.add(rand);
				   }
				   
				 //runs the contains method
					for (int j= 0; j < 10000; j++)
					{	
						timetesterRandom.contains(j);
						if(j % 100 == 0)
						{
						startTime = System.nanoTime();
						timetesterRandom.contains(j);		
						stopTime = System.nanoTime();
						aveTime = stopTime - startTime;
						fw.write("Contains method (RANDOM VALUE) timer with 0 to 10000 items" + "\t" + j + "\t" + aveTime + "\n"); // write to file.
						}
					}
				}
				
				
		  		catch (IOException e) 
		  		{
					e.printStackTrace();
				
		  		}
		}
	
	
	@Test
	public void TreeTimingTestAdd() throws IOException{
		try(FileWriter fw = new FileWriter(new File("visualization/data.csv"))) { //open up a file writer so we can write to file.
			
			fw.write("(Contains Methods) BST and Tree Set timer" + "\t" + "running contains on a random item" + "\t" + "Time in NanoSeconds it takes to run the Add method" + "\n");
			
			
			TreeSet<Integer> timetesterRandomTree = new TreeSet<Integer>();
			BinarySearchTree<Integer> timetesterRandom = new BinarySearchTree<Integer>();
			
			
				//Creates a random Array of 10000			
				 Integer[] randomArray = new Integer[10000];
				 int k= 0;
				 int l = 0;
				 int m = 0;
				 int n = 0;
				 for (int i = 0; i < randomArray.length; i++) 
				 {
				     randomArray[i] = i;
				 }				 
				    Collections.shuffle(Arrays.asList(randomArray));
				    
				    //Adds the list of random numbers to a BST
				   for(Integer rand : randomArray)
				   {
					   if (rand % 100 != 0)
					   {
						   timetesterRandom.add(rand);
						   k++;
					   }
					   if (rand % 100 == 0)
					   {
					   startTime = System.nanoTime();
					   timetesterRandom.add(rand);
					   stopTime = System.nanoTime();
					   aveTime = stopTime - startTime;
					   fw.write("Add method Using the Binary Search Tree" + "\t" + k + "\t" + aveTime + "\n"); 
					   k++;
					   // write to file.
						}
				   }
				   
				   for(Integer randm : randomArray)
				   {
					   if (randm % 100 != 0)
					   {
						   timetesterRandomTree.add(randm);
						   l++;
					   }
					   if (randm % 100 == 0)
					   {
					   startTime = System.nanoTime();
					   timetesterRandomTree.add(randm);
					   stopTime = System.nanoTime();
					   aveTime = stopTime - startTime;
					   fw.write("Add method using Java's Tree Set" + "\t" + l + "\t" + aveTime + "\n");
					   l++;
					   // write to file.
						}
				   }
				   
				   for(Integer rand : randomArray)
				   {
					   if (rand % 100 != 0)
					   {
						   timetesterRandom.contains(rand);
						   m++;
					   }
					   if (rand % 100 == 0)
					   {
					   startTime = System.nanoTime();
					   timetesterRandom.contains(rand);
					   stopTime = System.nanoTime();
					   aveTime = stopTime - startTime;
					   fw.write("Contains method Using the Binary Search Tree" + "\t" + m + "\t" + aveTime + "\n"); 
					   m++;
					   // write to file.
						}
				   }
				   
				   for(Integer randm : randomArray)
				   {
					   if (randm % 100 != 0)
					   {
						   timetesterRandomTree.contains(randm);
						   n++;
					   }
					   if (randm % 100 == 0)
					   {
					   startTime = System.nanoTime();
					   timetesterRandomTree.contains(randm);
					   stopTime = System.nanoTime();
					   aveTime = stopTime - startTime;
					   fw.write("Contains method Using Java's Tree Set" + "\t" + n + "\t" + aveTime + "\n"); 
					   n++;
					   // write to file.
						}
				   }
				   }
				   
					
				
				
				
		  		catch (IOException e) 
		  		{
					e.printStackTrace();
				
		  		}
		
	

		}
					
		

}
