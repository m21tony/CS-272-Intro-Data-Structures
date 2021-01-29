//***********************************************************************************
// part3.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: January 28. 2018
// This program will input an integer and print 'blue', 'berry', or 'blueberry'
// 		depending on whether divisible by 2, 3, or 6
//***********************************************************************************

import java.util.*;

public class Part3 {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		int n;
		System.out.println("Enter a positive interger: ");
		n = scnr.nextInt();
		
		int blue = 0;
		int berry = 0;
		int blueberry = 0;
		
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				if (i % 6 == 0 ) {
					System.out.println(i + " Blueberry");
					blueberry++;
				}
					else if (i % 3 ==0) {
						System.out.println(i + " Berry");
						berry++;
					}
					else if (i % 2 == 0) {
						System.out.println(i + " Blue");
						blue++;
					}
					else {
						System.out.println(i);
					}
			}
		}
		System.out.println();
		System.out.println("Blue is printed " + blue + " time(s).");
		System.out.println("Berry is printed " + berry + " time(s).");
		System.out.println("Blueberry is printed " + blueberry + " time(s).");
	}
}