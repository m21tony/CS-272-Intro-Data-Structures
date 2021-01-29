//CompareSortTime.java
//Written by: Greg De La Torre
//CS272
//5-3-16
//Program will create an array of 1,000,000 random integers (ranging from 0 to 999,999). It will then
//create a copy of the array. The program will then perform Insertion Sort on the first array, and 
//Merge Sort of the second array. The program will calculate and display the time taken to perform
//each sorting method.
//

public class CompareSortTime {

	public static void main(String[] args) {
		//Create an array of 1,000,000 random values, ranging from 0 to 999,999
		int[] checkTime = new int[1000000];
		for(int i =0; i<checkTime.length; i++){
			checkTime[i] = 0 + (int)(Math.random() * 999999);
		}
		System.out.println("A random array of 1,000,000 values has been created.");
		System.out.println("The values range from 0 to 999,999");
		
		//Create a copy (clone) of the original array
		int[] checkTime2 = checkTime.clone();
		System.out.println();
		System.out.println("The original array has been cloned");
		System.out.println();

		//Perform insertion sort on the original array and calculate 
		//the time of operation of the insertion sort
		long beforeInset = System.currentTimeMillis();
		insertionSort(checkTime);
		long afterInsert = System.currentTimeMillis();
		long timeAfterInsert = afterInsert - beforeInset;
		System.out.println("The time for performing insertion sort on the original array was: " + timeAfterInsert + " milliseconds");
		
		//Perform merge sort on the cloned array and calculate 
		//the time of operation of the merge sort
		long beforeMerge = System.currentTimeMillis();
		mergesort(checkTime2, 0, checkTime2.length);
		long afterMerge = System.currentTimeMillis();
		long timeAfterMerge = afterMerge - beforeMerge;
		System.out.println("The time for performing merge sort on the cloned array was: " + timeAfterMerge + " milliseconds");
		
	}
	
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
	
	
	//inseertionSort method will sort an array by determining where to insert a value 
	//into the array from smallest to largest
	//Parameters:
	//	int[] a - Array to be sorted
	//Precondition:
	//	int[] a must be valid
	//Postcondition:
	//	The array will be sorted from smallest value to largest value
	public static void insertionSort(int[] a){
		for(int i =1; i < a.length; i++){
			int temp = a[1];
			int j;
			for(j = i-1; j>= 0 && temp < a[j]; j--)
				a[j+1] = a[j];
			a[j+1] = temp;
		}
	}
}

