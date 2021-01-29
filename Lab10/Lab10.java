//Cs 272 - Lab10.java
//Written by Antonio Maldonado
//05-03-2018

import java.util.Scanner;
public class Lab10 {
   public static void main(String args[]) {      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the number of integer in the tree: ");
      int len = scan.nextInt();  //record user input for length
      int tree[] = new int[len]; //generate array based on lenth
      System.out.print("Enter the integers in the tree with no duplicates and separated by spaces: ");
      
      for(int x = 0; x < len; x++) 
         tree[x] = scan.nextInt();
      
      System.out.print("Entered Array: ");   //print unsorted array
      for(int x = 0; x < len; x++)
         System.out.print(tree[x] + " ");
      
      quicksort(tree, 0, len);   //sort array
      System.out.print("\nSorted Array:  ");   //print sorted array
      for(int x = 0; x < len; x++)
         System.out.print(tree[x] + " ");
      
      //create balanced tree given array
      //print balanced tree
      System.out.println("\n(BST)  Tree 1:");
      IntTreeBag Tree1 = null;
      Tree1 = Tree1.sortedArrayToBST(tree, 0, len-1);
      Tree1.print();
      
      System.out.println("\n(Clone) Tree 2:");
      IntTreeBag Tree2 = null; //test and print clone method
      Tree2 = Tree1.clone();
      Tree2.print();
      
      int action = -1;
      int num = 0;
      while(action != 0) { //prompt user input for action
         System.out.println("-------------");
         System.out.println("1. Add node\n2. Remove node\n0. Exit");
         action = scan.nextInt();
         if(action == 1) { //test add method
            System.out.print("Enter element to add: ");
            num = scan.nextInt();
            Tree2.add(num);
            Tree2.print();
         }
         if(action == 2) { //test remove method
            System.out.print("Enter element to remove: ");
            num = scan.nextInt();
            Tree2.remove(num);
            Tree2.print();
         }
      }
      System.out.print("Enter element to test for occurances: ");
      num = scan.nextInt(); //test count occurrences
      int count = Tree2.countOccurrences(num);
      System.out.println(num + " occur(s) " + count + " time(s) in Tree 2");
      
      System.out.println("Tree 3: (union of Tree 1 & 2)");
      IntTreeBag Tree3 = null; //test union method from tree and it's clone
      Tree3 = Tree3.union(Tree1, Tree2);
      Tree3.print();
      
      System.out.println("Result of adding all nodes from Tree 2 to Tree 1:");
      Tree1.addAll(Tree2);  //test addAll method
      Tree1.print();
            
   }//end main
   public static void quicksort(int data[], int first, int n) {
      int index, n1, n2;
      if(n > 1) {
         index = partition(data, first, n);
         n1 = index - first;
         n2 = n - n1 -1;
         quicksort(data,     first, n1);
         quicksort(data, index + 1, n2);
      }   
   }//end sorting method
   private static int partition(int data[], int first, int n) {
      int pivot         = data[first];   //step 1 - initialize values
      int tooBigIndex   = first + 1;     
      int tooSmallIndex = first + n - 1; 
      
      while(tooBigIndex <= tooSmallIndex) {  //step 2 - run until index cross
         if((tooBigIndex <= n) && (data[tooBigIndex] <= pivot)) {
            tooBigIndex++; //increment
         }   
         if(data[tooSmallIndex] > pivot) {
            tooSmallIndex--;  //decrement
         }   
         if(tooBigIndex < tooSmallIndex) {   //swap
            int temp = data[tooBigIndex];
            data[tooBigIndex]   = data[tooSmallIndex];
            data[tooSmallIndex] = temp;
         }        
      }//end while
      data[first] = data[tooSmallIndex];   //step 3 - sort
      data[tooSmallIndex] = pivot;
      return tooSmallIndex;
   }//end helper method
}      
