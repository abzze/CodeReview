import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{   


	
	
		
   private ArrayList<Student> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }
      
   public MaxHeap(Collection<Student> collection)
   {
      students = new ArrayList<Student>(collection);
      for(int i = size()/2; i >= 0; i--)
      {
         maxHeapify(i);
      }
   }
   
   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public Student extractMax()
   {
      Student value = getMax();
      students.set(0,students.get(size()-1));
      students.remove(size()-1);
      maxHeapify(0);
      return value;
   }
   
   
   public void insert(Student elt)
   {
      students.add(elt);
     
      
      
      for(int i = students.size()-1; i >= 0; i = parent(i))
      {
         if(students.get(i).gpa()>students.get(parent(i)).gpa())
            swap(i, parent(i));
         else return;
            
      }


   }
   
   public void changeKey(Student s, double newGPA)
   {
	   
	   boolean found = false;
	    
	   //locate student object 
      for(int i = students.size()-1; i >= 0; i--)
      {
    	  //if found, update student object inside the collection
         if(students.get(i) == s)
         {
             students.get(i).setGPA(newGPA);
             found = true;
         }
         
    	 
         //Node ascends through the heap
         if((found == true) && (students.get(i).gpa()>students.get(parent(i)).gpa()))
         {
        	 swap(i, parent(i));
         }
         //Node descends to the left/right or stays in its location
         else if ((found == true) && (i < (size()-1)/2))
         {
        	 maxHeapify(i);
         }
          
        	 
      }

   

   }

   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   private int size()
   {
      return students.size();
   }
   
   private void swap(int from, int to)
   {
      Student val = students.get(from);
      students.set(from,  students.get(to));
      students.set(to,  val);
   }
   
   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(largest);
      }  
   }   
}

