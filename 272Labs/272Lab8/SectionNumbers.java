//SectionNumbers.java
//Written by: Greg De La Torre
//4-5-16
//CS272
//Program will print given prefix along with section numbers based off of user desired level.

import java.util.Scanner;

public class SectionNumbers {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the prefix: ");
		String prefix = scan.nextLine();
		System.out.println();
		System.out.print("Please enter the number of levels: ");
		int levels = scan.nextInt();
		System.out.println();
		numbers(prefix, levels);
	}
	
	//numbers method will print prefix + input desired levels of sections
	//Parameters:
	//Prefix - String to be printed with section numbers
	//Levels - Int, levels of sections desired
	//Precondition: Levels >= 0
	//Postcondition: Program will print prefix along with section numbers
	public static void numbers(String prefix, int levels){
			 if (levels == 0){
					System.out.println(prefix);
			}
			else{
				for (int i= 1; i <= 9; i++){
					numbers(prefix + i + ".", levels-1);
				}
			}
					
	}
	

}
