import static org.junit.Assert.*;
import java.util.Collection;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MaxHeapTest
{
   private MaxHeap heap;
   private Student t = new Student("Cody", 60, 3.5);

   //This sets up the heap and tests the insert and change key functionality 
   @Before
   public void setUp() throws Exception
   {
      
	   
	  this.heap = new MaxHeap(10);
	  
	  heap.insert(t);
      
      heap.insert(new Student("Ben", 70, 3.4));
      heap.insert(new Student("Reed", 120, 4.0));
      heap.insert(new Student("Johnny", 50, 1.2));
      heap.changeKey(t, 4.1);
      
      
      
      
      
      
   }
   
   
//Tests the public method inside student to determine if it returning the correct value
@Test 
public void testreturnUnits() { int tmp = t.units();  }
   
//This method ensures that the heap is assembled in order 
@Test
   public void test()
   {
	
      assertEquals(4.1, heap.extractMax().gpa(), .000001);
      assertEquals(4.0, heap.extractMax().gpa(), .000001);
      assertEquals(3.4, heap.extractMax().gpa(), .000001); 
      assertEquals(1.2, heap.extractMax().gpa(), .000001);
   }
   
//Tests the compareTo method in MaxHeap by comparing the object values in the heap 
@Test
public void testcompareTo()
{
	Student equal = new Student("Moe",120 ,4.5); 
	Student less = new Student("David", 100, 4.0);
	less.compareTo(heap.getMax());
	equal.compareTo(equal);

}

//Creates an new array list and tests the MaxHeap constructor 
@Test
public void testmaxHeap()
{
	Student a = new Student("William",55,3.2);
	Student b = new Student("Anthony",55,4.0);
	Student c = new Student("Mary",55,2.9);
	Student d = new Student("Ann",55,3.9);
	
	
	
	Collection<Student> myList = new ArrayList<Student>(10);
	myList.add(a);
	myList.add(b);
	myList.add(c);
	myList.add(d);
	
	MaxHeap myHeap = new MaxHeap(myList);
	
	
}

//This method tests the getMax method and ensures the value is the max value in the heap
@Test

public void testgetMax()
{
	Student tmp = new Student("");
	tmp = heap.getMax();
	assertEquals(tmp, t);		

}

//A method that tests that the function will throw and Exception if there is illegal index access
@Test(expected=IndexOutOfBoundsException.class)
public void testEmpty()
{
	
	 MaxHeap maxi = new MaxHeap(0);
	 maxi.getMax().gpa();
	 
	    
}
  
   

}
