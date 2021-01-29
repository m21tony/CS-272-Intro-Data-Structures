//NumberGuessGame.java
//Written by: Greg De La Torre
//CS272
//5-3-16
//Program will ask the user to input a range of numbers, while thinking of a number
//in that range, and will determine which number the user is thinking of using binary search
//


import java.util.Scanner;

public class NumberGuessGame {

	//Main Method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Prompt user to think of a number
		System.out.println("Please think of a number in a particular range, do NOT input this number.");
		System.out.println();
		
		//Prompt user to enter the low and high value of the range of numbers
		System.out.print("Please input the lowest value in the range: ");
		int low = scan.nextInt();
		System.out.println();
		System.out.print("Please input the highest value in the range: ");
		int high = scan.nextInt();
		
		//Determine the size of the range of numbers
		int size = high-low;
		
		//Create an array with all values of the user specified range
		int[]range = new int[size+1];
		for(int i = 0; i<=size;i++){
			range[i]= low+i;
		}
		
		//Begin binary search game using array from user input range
		search(range, 0, size);
		
			
	}
	
	//search method will use binary search to determine which number the user is thinking of
	//in a specific range (i.e. the array created with the values of the given range)
	//Parameters:
	//	int[]a - The array to perform a binary search on
	//	int first - The index of the first value of the range to search
	//	int size - The size of the array
	//Precondiions:
	//	size must be > 0
	//	int[] a must be valid
	//	first must be valid
	//Postcondition:
	//	Method will question the user if the value searched is indeed the number the user thought of
	//	User can then say if their value is the found number, or if it is higher or lower then the 
	//	number presented by the program
	public static boolean search(int[] a, int first, int size){
		int middle;
		if(size<=0)
			return false;
		Scanner scan = new Scanner(System.in);
		middle = first + size/2;
		System.out.println("Is your number " + a[middle] + "?");
		System.out.print("Input 1 if value is lower, input 2 if value is higher, 0 if value is correct & to end program:");
		int answer = scan.nextInt();
		if(answer == 0){
			return true;
		}
		else if(answer == 1){
			return search(a, first, size/2);		
		}
		else{
			return search(a, middle + 1, (size-1)/2);
		}
	}
}
