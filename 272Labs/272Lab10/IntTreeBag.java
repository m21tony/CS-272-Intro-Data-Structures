//IntTreeBag.java
//Edited by: Greg De La Torre
//4-26-16
//CS272
//Methods add, addAll, clone, countOccurrences, remove and union have been implemented.
//Print method added to allow easy printing of user BST in BSTSortAndDisplay.java


// File: IntTreeBag.java from the package edu.colorado.collections

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"

//import edu.colorado.nodes.IntBTNode; 

/******************************************************************************
* This class is a homework assignment;
* An <CODE>IntTreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/IntTreeBag.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
*   </A>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 1999
*
* @see IntArrayBag
* @see IntLinkedBag
******************************************************************************/
public class IntTreeBag implements Cloneable{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   //add method will add a new element to the designated IntTreeBag
   //Parameters:
   //	int element - the new element that is being inserted
   //Precondition: IntTreeBag must be initialized
   //Postcondition: Copy of the element will be added to the bag
   public void add(int element){      
	   IntBTNode cursor;
	      boolean done;
	    
	      if (root == null){  // Add first element to binary search tree
	         root = new IntBTNode(element, null, null);
	      }
	      else{  // Add new leaf to binary search tree
	         cursor = root;
	         done = false;
	         do{
	            if (cursor.getData( ) >= element){  // Go left
	               if (cursor.getLeft( ) == null){
	                  cursor.setLeft( new IntBTNode(element, null, null) );
	                  done = true;
	               }
	               else
	                  cursor = cursor.getLeft( );
	            }
	            else{  //Go right
	               if (cursor.getRight( ) == null){
	                  cursor.setRight( new IntBTNode(element, null, null) );
	                  done = true;
	               }
	               else
	                  cursor = cursor.getRight( );
	            }
	         } 
	         while (!done);
	      }      
   }


   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   //addAll method will add the contents of another bag to this bag
   //Parameters:
   //	IntTreeBag addend - a bag whose contents will be added to this bag
   //Precondition: The parameter IntTreeBag addend is not null
   //Postcondition: The elements from IntTreeBag addend have been added to this bag.
   public void addAll(IntTreeBag addend){
	      IntBTNode addroot;

	      if (addend == null){
	         throw new IllegalArgumentException("Null addend");
	      }
	      if (root == addend.root){  
	         addroot = IntBTNode.treeCopy(addend.root);
	         addTree(addroot);
	      }
	      else
	            addTree(addend.root);
   }
   
   //addTree method assists with recursion for addAll method
   //Parameters:
   //	IntBTNode addroot - Node being added
   //Precondition: The parameter IntBTNode addroot is not null
   //Postcondition: The elements addroot have been added to this bag.
   private void addTree(IntBTNode addroot){
      if (addroot != null){
          add(addroot.getData( ));
          addTree(addroot.getLeft( ));
          addTree(addroot.getRight( ));
      }
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
   //clone method will generate a copy of indicated bag
   //No parameters
   //Precondition: Original IntTreeBag but be valid
   //Postcondition:  The return value is a copy of this bag. Subsequent changes to the 
   //copy will not affect the original, nor vice versa. 
   public IntTreeBag clone( ){  
      IntTreeBag answer;
      
      try{
         answer = (IntTreeBag) super.clone( );
      }
      catch (CloneNotSupportedException e){  
         throw new InternalError(e.toString( ));
      }
      
      answer.root = IntBTNode.treeCopy(root);
      
      return answer;
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   //countOccurrences method will count the number of occurrences of a particular element in a bag
   //Parameters:
   //	int target - the element that needs to be counted
   //Precondition: IntTreeBag but be valid
   //Postcondition:  The return value is the number of times 
   //that the element occurs in this bag
   public int countOccurrences(int target){
      
      int answer;
      IntBTNode cursor;

      answer = 0;
      cursor = root;
      while (cursor != null){
         if (cursor.getData( ) < target)
            cursor = cursor.getRight( );
         else{
            if (cursor.getData( ) == target)
               answer++;
            cursor = cursor.getLeft( );
         }
      }
      return answer;
   }
   
             
   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   //remove method will remove an element from the designated IntTreeBag
   //Parameters:
   //	int element - the element to remove from the bag
   //Precondition: IntTreeBag must be initialized
   //Postcondition:  If target was found in the bag, then one copy of 
   //target has been removed and the method returns true. 
   //Otherwise the bag remains unchanged and the method returns false. 
   public boolean remove(int target){
      
     IntBTNode parentOfCursor = null;
     IntBTNode cursor = root;
      
      while (cursor != null && target != cursor.getData( )){
         parentOfCursor = cursor;
         if (target < cursor.getData( ))
            cursor = cursor.getLeft( );
         else
            cursor = cursor.getRight( );
      }
      
      if (cursor ==  null)
         return false;
      else if (cursor.getLeft( ) == null){
         if (parentOfCursor == null)
            root = cursor.getRight( );
         else if (cursor == parentOfCursor.getLeft( ))
            parentOfCursor.setLeft(cursor.getRight( ));
         else
            parentOfCursor.setRight(cursor.getRight( ));
         return true;
      }
      else{
         cursor.setData(cursor.getLeft( ).getRightmostData( ));
         cursor.setLeft(cursor.getLeft( ).removeRightmost( ));
         return true;
      }
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( ){
      return IntBTNode.treeSize(root);
   }
   

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   //union method will create a new bag that contains all the elements from two other bags.
   //Parameters:
   //	IntTreeBag b1 - the first of two bags
   //	IntTreeBag b2 - the second of two bags
   //Precondition: Neither b1 nor b2 is null.
   //Postcondition: The union of b1 and b2 is returned
   public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2){
      IntTreeBag answer = new IntTreeBag( );
      answer.addAll(b1);
      answer.addAll(b2);
      return answer;
   }
	 
   //sortedArrayToBST method will create a new IntTreeBag from a sorted array
   //Parameters:
   //	int data[] - The sorted arrat to be converted to a BST
   //	int first - The first integer of an array
   //	int last - The last integer of an array
   //Precondition: data[] must be valid and sorted
   //Postcondition: A new IntTreeBag will be created from the elements of the sorted array
   public static IntTreeBag sortedArrayToBST(int data[], int first, int last) {
	   	IntTreeBag answer = new IntTreeBag();		
	   	//base case
		if (first > last)
			return answer;
		int mid = (first + last) / 2;
		answer.add(data[mid]);
		IntTreeBag left = sortedArrayToBST(data, first, mid - 1);
		IntTreeBag right= sortedArrayToBST(data, mid + 1, last);
		answer.root.setLeft(left.root);
		answer.root.setRight(right.root);
		return answer;
	}
   
   //print method will print the contents from an IntTreeBAg in a BST format
   //Parameters:
   //	IntTreeBag data - IntTreeBag to be printed
   //Precondition: data must be valid
   //Postcondition: data will be printed in the format of the IntBTNode print method.
   public static void print(IntTreeBag data){
	   data.root.print(0);
   }
   
   
}
           
