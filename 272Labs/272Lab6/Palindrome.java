//Palindrome.java
//Written by: Greg De La Torre
//Program determines whether the user input interger is a palindrome
//CS2772
import java.util.Scanner;
public class Palindrome {
	 public static void main(String args[]){
	       
        System.out.println("Please Enter a number : ");
        Scanner scan = new Scanner(System.in);
        int list = scan.nextInt();
        if(is_Palindrome(list)){
            System.out.println(list + " is a palindrome");
        }else{
            System.out.println(list + " is not a palindrome");
        }      
       
    }
	 
	    
    //isPalindrome method to check if number is palindrome or not
    //Precondition: User input is an interger
	//Postcondition: Integer is determined as a palindrome or not
    public static boolean is_Palindrome(int number) {
    	LinkedStack<Integer> p = new LinkedStack<Integer>();
    	LinkedStack<Integer> q = new LinkedStack<Integer>();
    	LinkedStack<Integer> r = new LinkedStack<Integer>();
        int maybe = number;
        int reverse = 0;
        while (maybe != 0) {
            int remainder = maybe % 10;
            reverse = reverse * 10 + remainder;
            maybe = maybe / 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
    }

}

