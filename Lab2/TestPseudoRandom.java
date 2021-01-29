//***********************************************************************************
// TestPseudoRandom.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: February 06, 2018
//***********************************************************************************


import java.util.Scanner;

public class TestPseudoRandom {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a multiplier: ");
		double multi = scan.nextDouble();
		
		System.out.print("Enter an increment: ");
		double i = scan.nextDouble();

		System.out.print("Enter a modulus: ");
		double mod = scan.nextDouble();
		
		System.out.print("Enter a seed: ");
		int s = scan.nextInt();
		
		PseudoRandom first = new PseudoRandom (multi, i, mod, s);
		
		first.changeSeed(3431);
		System.out.println(first.nextInt());
		System.out.println(first.nextDouble());
		
	}

}
