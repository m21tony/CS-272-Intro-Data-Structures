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
public class IntTreeBag implements Cloneable
{
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
   public void add(int element)
   {
      if(root == null) {  //if the tree is empty
         root = new IntBTNode(element, null, null); 
         return;
      }
      IntBTNode squirrel = root; //cursor
      while(true) {  //repeat until break
         if(element <= squirrel.getData()) { //less than
            if(squirrel.getLeft() == null) { //no left
               squirrel.setLeft(new IntBTNode(element, null, null));
               break;
            }   
            else  //update cursor
               squirrel = squirrel.getLeft();
         }         
         else {   //greater than
            if(squirrel.getRight() == null) {   //no right
               squirrel.setRight(new IntBTNode(element, null, null));
               break;
            }
            else  //update cursor   
               squirrel = squirrel.getRight();
         }   
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
   public void addAll(IntTreeBag addend)
   {
      IntBTNode addroot;
      if(root == addend.root) {
         addroot = IntBTNode.treeCopy(addend.root);   //clone of tree to add
         addTree(addroot);
      }  
      else
         addTree(addend.root); 
      
   }
   
   private void addTree(IntBTNode addroot) 
   {
      if(addroot != null) {
         add(addroot.getData()); //call add method
         addTree(addroot.getLeft());   //recursive calls for left
         addTree(addroot.getRight());  //and right
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
   public IntTreeBag clone( )
   {  // Clone an IntTreeBag object.
      IntTreeBag answer = null;
      try {
         answer = (IntTreeBag) super.clone();
         answer.root = IntBTNode.treeCopy(root);
      }
      catch (CloneNotSupportedException e) {
         throw new RuntimeException("This class does not inplement Cloneable."); 
      }     
      return answer; //IntBTNode.treeCopy(addend.root);
 
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      IntBTNode squirrel = root;
      int count = 0;
      while(true) {  //loop till break
         if(squirrel.getData() == target) { //base case
            count++; //increment coutner
            if(squirrel.getLeft() == null)   //check left since <=
               break;   //if null then done
            else
               squirrel = squirrel.getLeft();   //go left and return to top of loop
         }
         else if(squirrel.getData() > target) { //if node is greater than target
            if(squirrel.getLeft() == null)   //check left
               break;   //if null then done
            else
               squirrel = squirrel.getLeft();   //go left and return to top of loop
         }
         else { //squirrel.getData() < target) 
            if(squirrel.getRight() == null)  //check right
               break;   //if null then done
            else
               squirrel = squirrel.getRight();  //get right and return to top of loop
         }
      }//end while
      return count;  //completed tally of occurences
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
   public boolean remove(int target)
   {
      IntBTNode cursor = root;
      IntBTNode parentOfCursor = null;
      
      while(cursor != null || cursor.getData() != target){  //stops when cursor == null or
         if(cursor.getData() > target) {  //if data is greater than target
            parentOfCursor = cursor;   //update parent
            cursor = cursor.getLeft(); //update cursor
         }
         else {   //cursor.getData() < target
            parentOfCursor = cursor;   //update parent
            cursor = cursor.getRight();//update cursor
         }   
      }//end while
      if(cursor == null)
         return false;  //case 1
      //else
      if(cursor == root) { //case 2
         if(cursor.getRight() == null && cursor.getLeft() == null) {
            root = null;
            return true;
         }   
         else if(cursor.getLeft() == null) {
            root = root.getRight();
            return true;
         }   
         else if(cursor.getRight() == null) {
            root = root.getLeft();   
            return true;
         }   
      }
      else if(cursor.getLeft() == null) { //case 3
         if(cursor == parentOfCursor.getLeft()) {   
            parentOfCursor.setLeft(cursor.getRight());
            return true;
         }   
         else { 
            parentOfCursor.setRight(cursor.getRight());
            return true;
         }
      }
      else {
         cursor.setData(cursor.getLeft().getRightmostData());
         cursor.setLeft(cursor.getLeft().removeRightmost());
         return true;    
      }     
      return false;
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
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
   public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
   {
      IntTreeBag answer = new IntTreeBag();
      if(b1 != null && b2 != null) {
         answer.addTree(b1.root);
         answer.addTree(b2.root);
      }
      return answer;   
   }
   
   /**
   *   Create a balanced binary search tree from an array of integers
   *   @param - array is already sorted
   *            smallest to largest
   *          - assume no duplicates allowed
   *            in the array
   *   @return - tree built from the array            
   **/
   public static IntTreeBag sortedArrayToBST(int[] data, int first, int last)
   {
      IntTreeBag answer = new IntTreeBag();
      answer.root = maintainBalance(data, first, last);     
      return answer;
      
   } 
   
   public static IntBTNode maintainBalance(int data[], int first, int last) {
      IntBTNode cursor = new IntBTNode(data[(first + last)/2], null, null);
      if(first > last) 
         return null; // to handle empty subarray. e.g. []
      else if(first == last) 
         return cursor; // to handle one element subarray. e.g. [1]       
         
      cursor.setLeft (maintainBalance(data,              first, ((first+last)/2)-1));  //call for first half of the array
      cursor.setRight(maintainBalance(data, ((first+last)/2)+1,               last));  //call to second half of the array
      return cursor;
   }
   /*
   
   
   public void print(int type) {
      if(type == 0)
         root.inorderPrint();
      else if(type == 1)
         root.preorderPrint();
      else if(type == 2)
         root.postorderPrint();      
   }
   
   */
   public void print(){
    root.print(0);
   }
}
           
