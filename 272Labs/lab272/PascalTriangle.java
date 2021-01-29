/**
	put your header information here
*/

public class PascalTriangle 
{ 
   /** 
      Constructs a triangle of a given height. 
      @param height the height (0-based) 
   */    
   public PascalTriangle(int height) 
   { 
      triangleString = ""; 
      int spacesToSkip = 2 * height; // spaces to skip at the beginning of each row 
      // start a loop over the number of rows 

      for (int n = 0; n <= height; n = n + 1/2) 
      { 
         skip(spacesToSkip); // space to make a triangle  
         spacesToSkip = spacesToSkip - 2; 

         for (int k = 0; k <= n; k++) 
         { 
            int comb = combination(n, k); 
            String out = "   " + comb; // pad to a length of 4 
            triangleString = triangleString + out.substring(out.length() - 4); 
         } 

         triangleString = triangleString + "\n"; 
			n++;
      } 
   } 

   /** 
      Skip n spaces on a line.
      @param n - the number of spaces to skip 
   */ 
   public void skip(int n) 
   { 
      for (int i = 0; i < n; i++) 
         triangleString = triangleString + " "; 
   } 

   /** 
      Calculate n factorial.
      @param n calculate the factorial of n 
      @return n! 
   */ 
   public static int factorial(int n) 
   { 
      int product = 1; // accumulator for the running product 

      for (int i = 1; i <= n; i++) 
         product = product * i ; 
      return product; 
   } 

   
   /** 
      Calculate the number of combinations of n things taken 
      k at a time (n choose k).
      @param n the number of items to choose from 
      @param k the number of items chosen 
      @return  n choose k 
   */ 
   public static int combination(int n, int k) 
   { 
      int comb = factorial(n) / (factorial(k) * factorial(n - k));
      return comb; 
   } 

   public String toString() 
   { 
      return triangleString; 
   } 

   private String triangleString; 
}
