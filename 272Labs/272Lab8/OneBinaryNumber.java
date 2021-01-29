//OneBinaryNumber.java
//Written by: Greg De La Torre
//4-5-16
//CS272
//Program will convert user input decimal number into its binary equivalent

import java.util.Scanner;

public class OneBinaryNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the number to convert: ");
		int num = scan.nextInt();
		System.out.print("The number in binary is: ") ;
		binaryPrint(num);

	}
	
	//binaryPrint method will convert a given integer into its binary equivalent
	// Parameters: n – an integer   
	// Precondition: n is non-negative.   
	// Postcondition: The method prints the value of n as a BINARY number.   
	// If n is zero, then a single zero is printed;     
	// otherwise no leading zeros are printed in the output.   
	// The '\n' character is NOT printed at the end of the output.
	public static void binaryPrint(int n){
		int r;
		if(n <=1){
			System.out.print(n);
			return;
		}
	    if (n>0) {
	    	r = n%2;
	        binaryPrint(n/2);
	        System.out.print(r);
	    }
	}
}
