//FractalPattern.java
//Written by: Greg De La Torre
//4-5-16
//CS272
//Program will create a Fractal Pattern based off of given user input.

import java.util.Scanner;

public class FractalPattern {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the first parameter: ");
		int first = scan.nextInt();
		System.out.println();
		System.out.print("Please input the second parameter: ");
		int sec = scan.nextInt();
		System.out.println();
		pattern(first, sec);
	}
	
	// Parameters: n and i are integers   
	// Precondition: n is a power of 2, n >= 1, i>= 0   
	// Postcondition: A pattern based on the above example has been   
	// printed. The longest line of the pattern has
	// n stars beginning in column i of the output. For example,   
	// The above pattern is produced by the call pattern(8, 0).   
	public static void pattern(int n, int i)
	{      
	    int na = (int)(Math.log(n)/Math.log(2));    
	    if (na == 0){
			  // A loop to print exactly i spaces:   
			for (int k = 0; k < i; k++) System.out.print(" ");
			// A loop to print n asterisks, each one followed by a space:   
			for (int k = 0; k < n; k++) System.out.print("* ");
			System.out.println();
	    }
	    else{
	    	pattern((int)(Math.pow(2.0,na - 1)),i);
			  // A loop to print exactly i spaces:   
			for (int k = 0; k < i; k++) System.out.print(" ");
			// A loop to print n asterisks, each one followed by a space:   
			for (int k = 0; k < n; k++) System.out.print("* ");
            i+= na * 2;
            System.out.println();
            pattern((int)(Math.pow(2.0,na - 1)),i);
	    }
	}
}
