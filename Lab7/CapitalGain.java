//***********************************************************************************
// CapitalGain.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: April 10, 2018
// Calculates the capital gain of a system from a file input
//***********************************************************************************


import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CapitalGain {

	public static void main(String[] args) {

		// User reading scanner
		Scanner userIn = new Scanner(System.in);
		System.out.print("Please enter the transactions file name: ");
		String filename = userIn.nextLine();
		String fileInputStr;
		LinkedQueue <Transaction> all = new LinkedQueue <Transaction> ();
		LinkedQueue <Transaction> buy = new LinkedQueue <Transaction> ();
		Transaction tempTrans;
		boolean isSell;
		int number, price;
		int tempInt;
		int ssStart = -1; //sub-string-Start
		int shares = 0;
		int capitalGain = 0; 
		
		// File reading scanner
		Scanner fileIn = null;
		try {
		   fileIn = new Scanner(new FileInputStream(filename));    
		} 
		catch(FileNotFoundException fnfe) {
		   System.out.println("File " + filename + 
				   " was not found or could not be opened.");
		   System.exit(0);
		}
		
		// Report to the use what the system read
		System.out.println("The following transactions were read from the file: ");
		while(fileIn.hasNext()) {
			number = -1;
			price = -1;
			fileInputStr = fileIn.nextLine();
			// Check if the file line says 's'ell or buy
			if (fileInputStr.charAt(0) == 's')
				isSell = true;
			else
				isSell = false;
			// Find the digits in the string
			for (int i = 0; i < fileInputStr.length(); i++) {
				if (Character.isDigit(fileInputStr.charAt(i)) && ssStart == -1)
					ssStart = i;
				else if (!Character.isDigit(fileInputStr.charAt(i)) && ssStart != -1) {
					tempInt = Integer.parseInt(fileInputStr.substring(ssStart, i));
					// First number is the number of shares
					if (number == -1)
						number = tempInt;
					// Second number is the price
					else
						price = tempInt;
					ssStart = -1;
				}
			}
			// Push and make the transaction onto the all queue
			tempTrans = new Transaction(isSell, number, price);
			System.out.println("\t" + tempTrans);
			all.add(tempTrans);
		}

		System.out.println(); // White-space for clarity
		
		// Process the transactions
		while(!all.isEmpty()) {
			tempTrans = all.remove();
			System.out.println("Processing transaction: " + tempTrans);
			// If the current transaction is selling...
			if (tempTrans.isSell()) {
				// Selling shares removes shares
				shares = shares - tempTrans.getNumber();
				// While there are shares to sell...
				while(!buy.isEmpty() && shares < 0) {
					// If the buy-transaction bought less transactions than are being sold,
					// remove from the queue, add those shares to partial sum, and 
					// change the capitol gain (shares*(gain per share))
					if(buy.peek().getNumber() <= -shares) {
						shares = shares + buy.peek().getNumber();
						capitalGain = capitalGain + buy.peek().getNumber() * (tempTrans.getPrice() - buy.peek().getPrice());
						buy.remove();
					}
					// If more shares bought in the transaction than are being sold,
					// same as above but don't remove the transaction, just modify it correctly
					else {
						capitalGain = capitalGain + (-shares) * (tempTrans.getPrice() - buy.peek().getPrice());
						buy.updateFront(new Transaction(false, buy.peek().getNumber() + shares, buy.peek().getPrice()));
						shares = 0;
					}
				}
			}
			// If the current transaction is buying, push it on the buying stack
			else {
				buy.add(tempTrans);
			}
			// If there aren't shares to sell, break
			if (buy.isEmpty() && shares < 0) break;
		}
		// If there aren't enough shares, print error
		if (shares < 0)
			System.out.println("Error: attempt to sell non-existing shares!");
		// Otherwise...
		else {
			while (!buy.isEmpty()) {
				// Compute remaining shares buy adding all that remain
				tempTrans = buy.remove();
				shares = shares + tempTrans.getNumber();
			}
			
			System.out.println(); // White space for readability
			
			// Print the wanted values
			System.out.println("Capital gain is " + capitalGain);
			System.out.println("There are " + shares + " left.");
		}
	}

}
