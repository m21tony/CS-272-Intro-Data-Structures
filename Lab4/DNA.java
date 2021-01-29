
//***********************************************************************************
// DNA.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: March 03, 2018
//***********************************************************************************

import java.util.Scanner;

public class DNA {
   public static void main (String args []){
      
      //Declare scanner
      Scanner scan = new Scanner(System.in);
      
      //Prompt for a string and scan
      System.out.println("Please enter a DNA strand: ");
      String input1 = scan.nextLine();
      
      //Test stringToList
      CharNode CN1 = CharNode.stringToList(input1);
      
      //Test toString
      System.out.println("You entered: " + CN1);
      System.out.println("Your DNA list is: " + CN1);
      
      //Test dnaToRNA 
      System.out.println("Corresponding mRNA is: " + CharNode.dnaToRNA(CN1));
      
      //Test subSequence method
      
      //Prompt for a string and scan
      System.out.println("Please enter another DNA strand: ");
      String input2 = scan.nextLine();
      
      //Prompt for a string and scan
      System.out.println("Please enter one more DNA strand: ");
      String input3 = scan.nextLine();
      
      CharNode CN2 = CharNode.stringToList(input2);
      CharNode CN3 = CharNode.stringToList(input3);
      
      //Test subSequence method
      int answer = CharNode.subSequence(CN2,CN3);
      
      if(CharNode.listLength(CN3)<CharNode.listLength(CN2)){
         System.out.print("The larger strand was " + input2 + " and the subsequence of " + input3);
         System.out.print(" has a length of " + answer);
      }//end if
      else{
         System.out.print("The larger strand was " + input3 + " and the subsequence of " + input2);
         System.out.print(" has a length of " + answer);
      }//end else

   
   }//end main
   
}//end class
