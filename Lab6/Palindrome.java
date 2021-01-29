//Palindrome.java
//Written by Antonio Maldonado
//03-29-2018

import java.util.Scanner;
public class Palindrome {
   public static void main(String args[]) {
      //Variables
      Scanner scan = new Scanner(System.in);
      int length = 0;
      int num = 0;
      boolean result;
      LinkedStack <Integer> L1 = new LinkedStack <Integer> ();
      LinkedStack <Integer> L2 = new LinkedStack <Integer> ();
      LinkedStack <Integer> L3 = new LinkedStack <Integer> ();
      
      //prompt user for sequence length and sequence itself
      System.out.println("How many integers are in the sequence?");
      length = scan.nextInt();      
      System.out.println("Please enter the " + length + " digit sequence:");
      
      //create the linkedStacks
      for(int x = 0; x < length; x++)
         L1.push(scan.nextInt());
      L2 = L1.clone();
      
      //reverse copy of list
      while(L2.isEmpty() == false)
         L3.push(L2.pop());
      
      //test palindrome
      result = isPalindrome(L1, L3);
      if(result == true)
         System.out.println("The sequence is a palindrome.");      
      else
         System.out.println("The sequence is not a palindrome.");     

   }
   //test all entries of the sequences
   public static boolean isPalindrome(LinkedStack a, LinkedStack b) {
      while(a.isEmpty() == false) {
         if(a.pop() != b.pop())     //if not equal, then false
            return false;
      }      
      return true;   //if whole list is checked then true
   }   
}   
