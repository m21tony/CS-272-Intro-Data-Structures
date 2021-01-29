//CapitalGain.java
//Written by: Greg De La Torre
//Date: 3/29/16
//CS272
//Program calculates capital gain and remaining shares from transactions scanned from text file.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CapitalGain {
	public static void main (String args[])throws FileNotFoundException{
		Scanner scan =  new Scanner(System.in);
		System.out.print("Please enter the transaction's file name: ");
		String filename = scan.nextLine();
		System.out.println();
		System.out.println("The following transactions were read from this file: ");
		System.out.println();
		Scanner reader = new Scanner(new File(filename));
		while (reader.hasNext()){
		   String str = reader.nextLine();
		   System.out.println(str);
		}
		System.out.println();
		LinkedQueue<Transaction> allItems = new LinkedQueue<Transaction>();
		LinkedQueue<Transaction> buyItems = new LinkedQueue<Transaction>();
		Scanner process = new Scanner(new File(filename));
		while (process.hasNext()){
			String st = process.nextLine();
			String Am = "";
			String price = "";
			if(st.charAt(0) == 'b'){
				if(st.charAt(7) == ' '){
					Am = st.substring(4,7);
					price = st.substring(19,21);
				}
				else{
					if(st.charAt(6) == ' '){
						Am = st.substring(4,6);
						if(st.charAt(19)== ' ')
							price = st.substring(18,19);
						else
							price = st.substring(18,20);
					}
					else{
						Am = st.substring(4,5);
						price = st.substring(19, 20);
					}
				}
				int b = Integer.parseInt(Am);
				int p = Integer.parseInt(price);
				Transaction buy = new Transaction(false, b, p);
				allItems.add(buy);
			}
			else{
				if(st.charAt(8) == ' '){
					Am = st.substring(5,8);
					price = st.substring(20,22);
				}
				else{
					if(st.charAt(7) == ' '){
						Am = st.substring(5,7);
						if(st.charAt(20) == ' '){
							price = st.substring(19, 20);
						}
						else
							price = st.substring(19,21);
					}
					else{
						Am = st.substring(5,6);
						price = st.substring(19,20);
					}
				}
				int b = Integer.parseInt(Am);
				int p = Integer.parseInt(price);
				Transaction sell = new Transaction(true, b, p);
				allItems.add(sell);
			}
		}//end while
			int gain = 0;
			int leftover = 0;
			while(allItems.isEmpty() == false){
				System.out.println("Processing transaction: " + allItems.peek());
				
					Transaction check = allItems.remove();
					if(check.isSell() == false){
						buyItems.add(check);
					}
					else{
						Transaction c = buyItems.peek();
						int shares = c.getNumber();
						if(shares - check.getNumber() < 0){
							gain += shares * (check.getPrice() - c.getPrice());
							check.changeNumber(check.getNumber()- shares);
							buyItems.remove();
							
						}
						else if(shares - check.getNumber() > 0){
							gain += shares * (check.getPrice() - c.getPrice());
							c.changeNumber(shares - check.getNumber());
							allItems.remove();
						}
						else{
							gain += shares * (check.getPrice() - c.getPrice());
							buyItems.remove();
							allItems.remove();
							c.changeNumber(shares - check.getNumber());
						}
						leftover += c.getNumber();
				   }
				}//end while
		if(gain > 0){
			System.out.println("Capital Gain: " + gain);
			System.out.println("Shares remaining: " + leftover);
		}
		else
			System.out.println("You cannot sell more stocks then owned!");
	}//end main
}//end class
