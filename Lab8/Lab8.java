//LAB 8
//Written by Jacob Dickens
//4-19-2018
import java.util.Scanner;
public class Lab8 {
   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
   //Part 1: Triangle Pattern
      System.out.print("Enter an integer: ");
      int ends = scan.nextInt();
      System.out.print("Enter another integer: ");
      int middle = scan.nextInt();
      System.out.println();
      triangle(ends, middle);
      
   //Part 2: Section Numbers
      System.out.print("\nEnter a string: ");
      String section = scan.next();
      System.out.print("Enter an integer: ");
      int lvl = scan.nextInt();
      numbers(section, lvl);
      
   //Part 3: Fractal Pattern
      System.out.print("\nEnter an integer: ");
      int stars = scan.nextInt();
      System.out.print("\nEnter another integer: ");
      int spaces = scan.nextInt();
      pattern(stars, spaces);
      
   //Part 4: Binary Number
      System.out.print("\nEnter an integer: ");
      int num = scan.nextInt();
      System.out.print("Binary: ");
      binaryPrint(num);      
   }//end main
   
 // Parameters: m - number of asterisks in the first lin   // n - number of asterisks in the middle 2 lines
 // Precondition: m <= n, m > 0, n > 0
 // Postcondition: The method has printed a pattern of 2*(n-m+1) lines
 // to the standard output. The first line contains m asterisks, the next
 // line contains m+1 asterisks, and so on up to a line with n asterisks.
 // Then the pattern is repeated backwards, going n back down to m.  
   public static void triangle(int m, int n) {
      if(m == 0 || n == 0) {  //precondition catch
         System.out.println("Precondition(s) not met:" +
                            "\n    m cannot equal 0" +
                            "\n    n cannot equal 0" );
         return;                   
      }
      if(m <= n) {
         for(int i = 0; i < m; i++)
            System.out.print("*");
         System.out.println();      
         triangle(m+1, n);
         
         for(int j = 0; j < m; j++)
            System.out.print("*"); 
         System.out.println(); 
      }
   }//end triangle pattern  
      
   public static void numbers(String prefix, int levels) {
         if(levels == 0)         
            System.out.println(prefix);   
      else
         for(int c = 1; c <= 9; c++) {
           String s = prefix + c + "." ;
           numbers(s, levels-1);
         }           
   }//end numbers method 
   
 // Parameters: n and i are integers
 // Precondition: n is a power of 2, n >= 1, i>= 0
 // Postcondition: A pattern based on the above example has been
 // printed. The longest line of the pattern has
 // n stars beginning in column i of the output. For example,
 // The above pattern is produced by the call pattern(8, 0).  
   public static void pattern(int n, int i) {
   
      if(n == 1) {
         for(int k = 0; k < i; k++) System.out.print(" ");  
         System.out.println("*");
      }
      else {
         pattern(n/2, i);
         for(int k = 0; k < i; k++) System.out.print(" ");       
         for(int k = 0; k < n; k++) System.out.print("* ");
         System.out.println();
         pattern(n/2, i+n);         
      }   
   }//end pattern method
   
 // Parameters: n – an integer
 // Precondition: n is non-negative.
 // Postcondition: The method prints the value of n as a BINARY number.
 // If n is zero, then a single zero is printed;
 // otherwise no leading zeros are printed in the output.
 // The '\n' character is NOT printed at the end of the output.
   public static void binaryPrint(int n) {
      if(n == 1 || n == 0) System.out.print(n);
      else {
         binaryPrint(n/2);
         System.out.print(n%2);
      }     
   }
}   
   