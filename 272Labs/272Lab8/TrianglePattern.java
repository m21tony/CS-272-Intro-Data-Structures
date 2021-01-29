//TrianglePattern.java
//Written by: Greg De La Torre
//4-5-16
//CS272
//Program will print triangle recursively using user given parameters.

import java.util.Scanner;

public class TrianglePattern {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the first triangle parameter: ");
		int firstPar = scan.nextInt();
		System.out.println();
		System.out.print("Please enter the second triangle parameter: ");
		int secondPar = scan.nextInt();
		System.out.println();
		triangle(firstPar, secondPar);
		

	}//end main
	
	// Parameters: m - number of asterisks in the first line   
	//             n - number of asterisks in the middle 2 lines  
	// Precondition: m <= n, m > 0, n > 0 
	// Postcondition: The method has printed a pattern of 2*(n-m+1) lines
	 // to the standard output. The first line contains m asterisks, the next 
	 // line contains m+1 asterisks, and so on up to a line with n asterisks.
	  // Then the pattern is repeated backwards, going n back down to m. 
	 /* Example output: 
	  	triangle(3, 5) will print this:
	  	***
	  	****
	  	*****
	  	*****
	  	****
	  	***
	  */
	public static void triangle(int m, int n){    
	    stars(m);
	    if(m <= n){
	        triangle(m+1,n);
	        stars(m);
	    }
	}//end triangle

	//Stars method prints amount of stars based of user input.
	//Method is recursive
	//Precondition: m must be an integer
	//Postcondition: Method will print amount of stars based off of parameter.
	public static void stars(int m){
	    if(m == 1) 
	    	System.out.println("*");
	    else{
	        System.out.print("*");
	        stars(m-1);
	    }
	}//end stars
}//end class

