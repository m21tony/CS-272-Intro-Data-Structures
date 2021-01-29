//BSTSortAndDisplay.java
//Written by: Greg De La Torre
//4-26-16
//CS272
//Program prompts users to enter an array of numbers and formats them into a binary search tree.
//Program then manipulates the BST by adding & removing elements, copying the BST, counting 
//occurrences of an element, unionizing two BST's, and adding all nodes of a BST to another


//Import java.util.Arrays to easily print Array of the user
import java.util.Arrays;
import java.util.Scanner;

public class BSTSortAndDisplay {

	//Main
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//User Input Size of Array
		System.out.print("How many elements are there? \n");
		int numOfElem = scan.nextInt();
		
		//Create array of user specified size
		int []arrayBST = new int[numOfElem];
		
		//User Input Elements into array
		System.out.print("Please enter " + numOfElem + " interger(s). \n");	
		for (int i = 1; i <= arrayBST.length; i++){

	        System.out.println("Please enter number " + i);

	        arrayBST[i-1] = scan.nextInt();

	    }//end for
		
		//Present information to user
		System.out.println("You enterd the array: " + Arrays.toString(arrayBST));
		
		//Sort array using mergesort method
		mergesort(arrayBST, arrayBST[0], arrayBST.length-1);
		//Print sorted array
		System.out.print("Sorted array: " + Arrays.toString(arrayBST) + "\n");
		
		//Create an IntTreeBag from the sorted array
		IntTreeBag tree1 = IntTreeBag.sortedArrayToBST(arrayBST, 0, arrayBST.length-1);
		//Print sorted array
		System.out.println("BST(tree1) obtained from the array:");
		IntTreeBag.print(tree1);
		
		//Create clone of original tree & print
		IntTreeBag tree2 = tree1.clone();
		System.out.println("Clone of the tree (tree2):");
		IntTreeBag.print(tree2);
		
		//Prompt user to edit tree2 or exit editing, user may:
		//add an element to the tree - enter 1
		//remove an element to the tree - enter 2
		//exit editing of the tree - enter 0
		System.out.print("Please enter 1 to add an element, 2 to remove an element, or 0 to exit: ");
		int decision = scan.nextInt();
		while(decision != 0){
			if(decision == 1){
				System.out.print("Please enter the element you wish to add: ");
				int add =  scan.nextInt();
				//Add user indicated element to tree2, then print updated tree2
				tree2.add(add);
				System.out.println("Updated tree2:");
				IntTreeBag.print(tree2);
				//Enquire if user wishes to continue to edit tree2
				System.out.print("Please enter 1 to add an element, 2 to remove, or 0 to exit: ");
				decision = scan.nextInt();
			}
			else if(decision == 2){
				System.out.print("Please enter the element you wish to remove: ");
				int remove =  scan.nextInt();
				//Remove user indicated element from tree2, then print updated tree2
				tree2.remove(remove);
				System.out.println("Updated tree2:");
				IntTreeBag.print(tree2);
				//Enquire if user wishes to continue to edit tree2
				System.out.print("Please enter 1 to add an element, 2 to remove, or 0 to exit: ");
				decision = scan.nextInt();
			}
		}
		
		//Ask user for an element to count the occurrences of in the tree
		System.out.print("Please enter element to count occurrence: ");
		int countOc = scan.nextInt();
		//Print number of occurrences of indicated element
		System.out.println("The number " + countOc + " occured " + tree2.countOccurrences(countOc) + " times in tree 2");
		
		//Create new tree from union of tree1 & tree2, then print new tree (tree3)
		IntTreeBag tree3 = IntTreeBag.union(tree1, tree2);
		System.out.println("Union of tree1 & tree2 (tree3):");
		IntTreeBag.print(tree3);
		
		//Add all nodes from tree2 to tree1, then print result
		tree1.addAll(tree2);
		System.out.println("Result of adding all nodes from tree2 to tree1:");
		IntTreeBag.print(tree1);

	}//end Main
	
	//mergesort method sorts an array using recursion in order from smallest value to largest
	//Parameters:
	//	int[]data - The array to be sorted
	//	int first - The first location of the range of the array to be sorted
	//	int n - Size of the array
	//Precondition: data must be valid
	//Postcondition: The array will be sorted from smallest value to largest
	public static void mergesort(int[]data, int first, int n){
		int n1;
		int n2;
		if(n>1){
			n1 = n/2;
			n2 = n-n1;
			mergesort(data, first, n1);
			mergesort(data, first + n1, n2);
			merge(data, first, n1, n2);
		}
	}
	
	//merge method assists with mergesort method, helping to complete the sorted array by merging
	//two sorted arrays into a single sorted array
	//Parameters:
	//	int[]data - The array to be sorted
	//	int first - The first location of the range of the array to be sorted
	//	int n1 - Size of the 1st array
	//	int n2 - Size of the 2nd array
	//Precondition: data must be valid
	//Postcondition: The sorted arrays created from a larger array will be merged 
	//into a single sorted array
	public static void merge(int[]data, int first, int n1, int n2){
		int[]temp = new int[n1+n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;
		while((copied1<n1)&&(copied2<n2)){
			if(data[first + copied1] < data[first + n1 + copied2])
				temp[copied++] = data[first+(copied1++)];
			else
				temp[copied++] = data[first + n1 + (copied2++)];
		}
		while(copied1 < n1)
			temp[copied++] = data[first + (copied1++)];
		for(int i = 0; i < copied; i++)
			data[first + i] = temp[i];
	}
}
