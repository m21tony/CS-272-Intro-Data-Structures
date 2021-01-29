//***********************************************************************************
// TestDistribution.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: February 06, 2018
//***********************************************************************************

import java.util.Scanner;

public class TestDistribution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a multiplier: ");
		double multi = scan.nextDouble();
		
		System.out.print("Enter a increment: ");
		double i = scan.nextDouble();
		
		System.out.print("Enter a modulus: ");
		double mod = scan.nextDouble();
		
		System.out.print("Enter a seed: ");
		int s = scan.nextInt();
		
		System.out.println();
		
		int count1 = 0; int count2 = 0; 
		int count3 = 0; int count4 = 0; 
		int count5 = 0; int count6 = 0;
		int count7 = 0; int count8 = 0; 
		int count9 = 0; int count10 = 0; 
		double temp = 0;
		
		PseudoRandom test = new PseudoRandom(multi, i, mod, s);
		
		for(int num = 0; num < 1000000; num++) {
			temp = test.nextDouble();
			
			if((temp >= 0.0) && (temp < 0.1))
				count1++;
			else if((temp >= 0.1) && (temp < 0.2))
				count2++;
			else if((temp >= 0.2) && (temp < 0.3))
				count3++;
			else if((temp >= 0.3) && (temp < 0.4))
				count4++;
			else if((temp >= 0.4) && (temp < 0.5))
				count5++;
			else if((temp >= 0.5) && (temp < 0.6))
				count6++;
			else if((temp >= 0.6) && (temp < 0.7))
				count7++;
			else if((temp >= 0.7) && (temp < 0.8))
				count8++;
			else if((temp >= 0.8) && (temp < 0.9))
				count9++;
			else if((temp >= 0.9) && (temp < 1.0))
				count10++;
		}
		System.out.println("Range: No of occurrence:");
		System.out.println("[0.0, 0.1): " + count1);
		System.out.println("[0.1, 0.2): " + count2);
		System.out.println("[0.2, 0.3): " + count3);
		System.out.println("[0.3, 0.4): " + count4);
		System.out.println("[0.4, 0.5): " + count5);
		System.out.println("[0.5, 0.6): " + count6);
		System.out.println("[0.6, 0.7): " + count7);
		System.out.println("[0.7, 0.8): " + count8);
		System.out.println("[0.8, 0.9): " + count9);
		System.out.println("[0.9, 1.0): " + count10);

	}

}
