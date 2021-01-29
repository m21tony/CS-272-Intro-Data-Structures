// File: IntArrayBag.java from the package edu.colorado.collections
// Additional javadoc documentation is available from the IntArrayBag link in:
//   http://www.cs.colorado.edu/~main/docs

//package edu.colorado.collections;

/******************************************************************************
* An IntArrayBag is a collection of int numbers.
* The same number may appear multiple times in a bag.
*
* @note
*   (1) The capacity of one of these bags can change after it's created, but
*   the maximum capacity is limited by the amount of free memory on the 
*   machine. The constructor, addItem, clone, 
*   and union will result in an OutOfMemoryError
*   when free memory is exhausted.
*   <p>
*   (2) A bag's capacity cannot exceed the maximum integer 2,147,483,647
*   (Integer.MAX_VALUE). Any attempt to create a larger capacity
*   results in a failure due to an arithmetic overflow. 
*   <p>
*   (3) Because of the slow linear algorithms of this
*   class, large bags will have poor performance.
*
* @see
*   <A HREF="../../../../edu/colorado/collections/IntArrayBag.java">
*   Java Source Code for this class
*   (www.cs.colorado.edu/~main/edu/colorado/collections/IntArrayBag.java)
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 5, 2005
*
* @see ArrayBag
* @see IntLinkedBag
******************************************************************************/
public class IntArrayBag implements Cloneable
{
   // Invariant of the IntArrayBag class:
   //   1. The number of elements in the bag is in the instance variable 
   //      manyItems, which is no more than data.length.
   //   2. For an empty bag, we do not care what is stored in any of data;
   //      for a non-empty bag, the elements in the bag are stored in data[0]
   //      through data[manyItems-1], and we don’t care what’s in the
   //      rest of data.
   private int[ ] data;
   private int manyItems; 
   
   /**
   * Initialize an empty bag with an initial capacity of 10.  Note that the
   * addItem method works efficiently (without needing more
   * memory) until this capacity is reached.
   * @param - none
   * @postcondition
   *   This bag is empty and has an initial capacity of 10.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new int[10].
   **/   
   public IntArrayBag( )
   {
      final int INITIAL_CAPACITY = 10;
      manyItems = 0;
      data = new int[INITIAL_CAPACITY];
   }
     

   /**
   * Initialize an empty bag with a specified initial capacity. Note that the
   * addItem method works efficiently (without needing more
   * memory) until this capacity is reached.
   * @param initialCapacity
   *   the initial capacity of this bag
   * @precondition
   *   initialCapacity is non-negative.
   * @postcondition
   *   This bag is empty and has the given initial capacity.
   * @exception IllegalArgumentException
   *   Indicates that initialCapacity is negative.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new int[initialCapacity].
   **/   
   public IntArrayBag(int initialCapacity)
   {
      if (initialCapacity < 0)
         throw new IllegalArgumentException
         ("The initialCapacity is negative: " + initialCapacity);
      data = new int[initialCapacity];
      manyItems = 0;
   }
        
 
   /**
   * Add a new element to this bag. If the new element would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new element.
   * @param element
   *   the new element that is being inserted
   * @postcondition
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the bag's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the bag to fail with an
   *   arithmetic overflow.
   **/
   public void add(int element)
   {
      if (manyItems == data.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1)*2);
      }

      data[manyItems] = element;
      manyItems++;
   }


   /**
   * Add new elements to this bag. If the new elements would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new elements.
   * @param elements
   *   (a variable-arity argument)
   *   one or more new elements that are being inserted
   * @postcondition
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the bag's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the bag to fail with an
   *   arithmetic overflow.
   **/
   public void addMany(int... elements)
   {
      if (manyItems + elements.length > data.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + elements.length)*2);
      }

      System.arraycopy(elements, 0, data, manyItems, elements.length);
      manyItems += elements.length;
   }


   /**
   * Add the contents of another bag to this bag.
   * @param addend
   *   a bag whose contents will be added to this bag
   * @precondition
   *   The parameter, addend, is not null. 
   * @postcondition
   *   The elements from addend have been added to this bag.
   * @exception NullPointerException
   *   Indicates that addend is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the bag to fail. Such large collections should use
   *   a different bag implementation.
   **/
   public void addAll(IntArrayBag addend)
   {
      // If addend is null, then a NullPointerException is thrown.
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.
      ensureCapacity(manyItems + addend.manyItems);
         
      System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
      manyItems += addend.manyItems;
   }   
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public IntArrayBag clone( )
   {  // Clone an IntArrayBag object.
      IntArrayBag answer;
      
      try
      {
         answer = (IntArrayBag) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.data = data.clone( );
      
      return answer;
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param target
   *   the element that needs to be counted
   * @return
   *   the number of times that target occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      int answer;
      int index;
      
      answer = 0;
      for (index = 0; index < manyItems; index++)
         if (target == data[index])
            answer++;
      return answer;
   }


   /**
   * Change the current capacity of this bag.
   * @param minimumCapacity
   *   the new capacity for this bag
   * @postcondition
   *   This bag's capacity has been changed to at least minimumCapacity.
   *   If the capacity was already at or greater than minimumCapacity,
   *   then the capacity is left unchanged.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new int[minimumCapacity].
   **/
   public void ensureCapacity(int minimumCapacity)
   {
      int[ ] biggerArray;
      
      if (data.length < minimumCapacity)
      {
         biggerArray = new int[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray;
      }
   }

   
   /**
   * Accessor method to get the current capacity of this bag. 
   * The add method works efficiently (without needing
   * more memory) until this capacity is reached.
   * @param - none
   * @return
   *   the current capacity of this bag
   **/
   public int getCapacity( )
   {
      return data.length;
   }

              
   /**
   * Remove one copy of a specified element from this bag.
   * @param target
   *   the element to remove from the bag
   * @postcondition
   *   If target was found in the bag, then one copy of
   *   target has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(int target)
   {
      int index; // The location of target in the data array.
       
      // First, set index to the location of target in the data array,
      // which could be as small as 0 or as large as manyItems-1; If target
      // is not in the array, then index will be set equal to manyItems;
      for (index = 0; (index < manyItems) && (target != data[index]); index++)
         // No work is needed in the body of this for-loop.
         ;
         
      if (index == manyItems)
         // The target was not found, so nothing is removed.
         return false;
      else
      {  // The target was found at data[index].
         // So reduce manyItems by 1 and copy the last element onto data[index].
         manyItems--;
         data[index] = data[manyItems];
         return true;
      }
   }
                 
   
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/ 
   public int size( )
   {
      return manyItems;
   }
   
   
   /**
   * Reduce the current capacity of this bag to its actual size (i.e., the
   * number of elements it contains).
   * @param - none
   * @postcondition
   *   This bag's capacity has been changed to its current size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity. 
   **/
   public void trimToSize( )
   {
      int[ ] trimmedArray;
      
      if (data.length != manyItems)
      {
         trimmedArray = new int[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      }
   }
      

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param b1
   *   the first of two bags
   * @param b2
   *   the second of two bags
   * @precondition
   *   Neither b1 nor b2 is null, and
   *   b1.getCapacity( ) + b2.getCapacity( ) &lt;= Integer.MAX_VALUE.
   * @return
   *   the union of b1 and b2
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   * @note
   *   An attempt to create a bag with a capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the bag to fail. Such large collections should use
   *   a different bag implementation.
   **/   
   public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2)
   {
      // If either b1 or b2 is null, then a NullPointerException is thrown. 
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.   
      IntArrayBag answer = new IntArrayBag(b1.getCapacity( ) + b2.getCapacity( ));
      
      System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
      System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
      answer.manyItems = b1.manyItems + b2.manyItems;
      
      return answer;
   }
   
   //************************************************************************************************
   // Antonio Maldonado
   //************************************************************************************************
   
   /**
   * Determines if two IntArrayBag objects are equal;if the two objects have the exact same elements
   * 	regardless of order
   * @param obj
   * 	An IntArrayBag object that is to be compared to the calling object
   * @returs
   * 	The method returns true if the two bag objects contain the same elements and false if they don't
   **/
   public boolean equals(Object obj){
      
       if( obj instanceof IntArrayBag ){ //Only test for equality if the parameter is an IntArrayBag
           IntArrayBag candidate = (IntArrayBag) obj; //Typecast the object into an IntArrayBag
           
           IntArrayBag copy = candidate.clone();     //create a clone of the candidate, so any alterations are only made to the clone
           
           int i = 0; //declare a variable to keep track of the current index of the IntArrayBag that is being compared.
           
           if(manyItems == copy.manyItems){ 
        	   	   //the objects should only have the same items if they have the same number of items- 
               //check for that here and return false if the condition is false 
               //This is a while loop that runs only if there are elements to remove
               //This line will only remove the elements of the data array of the calling object from the copy
               //It will run for all the items in the calling object's array
               while( copy.remove(data[i]) == true && i < manyItems ){
                   i++;
               }
    
               //After running the while loop, if there are still elements in the copy, then the 
               //two objects did not have the same elements. If there are not elements in copy, the arrays
               //were the same and the method returns true
               if(copy.manyItems == 0 )
                   return true;
           }
           
           //If the bags did not have the same number of items or copy was not empty after the execution of the while loop
           //return false
           return false;
       
       }
       else
           return false; //returns false if the parameter was not an IntArrayBag
   }
      

   /** 
   * Converts a IntArrayBag object into a string using set notation
   * @returns 
   * 	Each element of the bag is printed, separated by commas, within curly braces.
   **/
   
   public String toString(){
       
       String output = new String(); //declaring a string to hold the string to be returned
       
       if(manyItems == 0){ //If the bag is empty, print a set of curly braces
           output += "{}";
       }
       
       else
           for( int i = 0 ; i < manyItems ; i++ ){ //for loop to generate an output
               if( i == 0){ //print a starting curly brace at the very beginning
                   output+="{";
               }
           
               output+=data[i]; //print the current element of the object's data instance variable
           
            if(i != manyItems - 1){ //only add commas to output if the current element is not the last element in the bag
                output+=", ";
            }
            
            else
                output+="}"; //if it is the last element, add an ending curly brace to the string
       }    
       
       return output; //return the resulting string
       
   }

   
   /**
   * Removes all of the elements in the argument removed from the calling object
   * @param removed
   * 	An IntArrayBag containing elements that we want to remove
   * @returns
   * 	Returns true if an element was actually removed from the calling object
   *    Removes all of the elements of removed from the calling object
   **/
   
   public boolean removeAll( IntArrayBag removed ){
       int count = 0; //variable to keep track of the current index of the removed IntArrayBag
       
       boolean changeOccurred = false; //boolean variable to keep track of whether or not an element was removed from the calling object
       
       //for loop to remove elements of removed from the calling object
       for(int i = 0 ; i < data.length ; i++ ){
           
           if(remove(removed.data[count]) == true) //this line removes elements of removed from data
               changeOccurred = true; //changeOccurred is only set to true if an int was removed from the calling object
           
           count++; //increment count
       }
       
       return changeOccurred; //return the boolean indicated whether or not a change took place
       
   }
   
   
   /**
   * Method that finds the intersection of two IntArrayBag objects
   * @param b1
   * 	First IntArrayBag
   * @param b2
   * 	Second IntArrayBag
   * @precondition
   * 	Neither of the two bags can be null
   * @returns
   * 	Returns a bag containing the elements that are the same between the two parameters 
   * @throws NullPointerException 
   *		Thrown if one or more of the bags is a null reference
   **/
   
   public static IntArrayBag intersection(IntArrayBag b1, IntArrayBag b2){
       //create copies of the parameters so that the arguments themselves are not changed
       IntArrayBag copy1 = b1.clone(); 
       IntArrayBag copy2 = b2.clone();
       
       //create a new IntArrayBag- this is what will be returned
       IntArrayBag answer = new IntArrayBag( copy1.manyItems + copy2.manyItems );
       
       boolean alreadyAdded; //boolean variable to ensure that no element is added more times than it should be
       
              //for loop to keep track of the current element of copy1 being compared
           for( int i = 0 ; i < copy1.manyItems ; i++){
               alreadyAdded = false; //every time a new element is checked, alreadyAdded is set to false
               
               //for loop to compare every item in copy2 to the current element of copy1
               for(int j = 0 ; j < copy2.manyItems ; j++ ){
                 //only performs actions if the items are equal and if an element hasn't already been removed
                   if( copy1.data[i] == copy2.data[j] && alreadyAdded == false ) {
                       answer.add(copy1.data[i]); //add the matching element to answer
                       copy2.remove(copy1.data[i]); //remove the element from copy2 so that there is no unnecessary additions to answer
                       alreadyAdded = true; //ensures the integer is only added to answer one time per execution of the inner loop
                   }
               }
           }
       
       return answer; //return the resulting IntArrayBag
       
   }
     
}