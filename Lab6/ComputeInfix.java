//ComputeInfix.java
//Written by Antonio Maldonado
//03-29-2018

import java.util.Scanner;
public class ComputeInfix {
   public static void main(String args[]) {
      //variables
      Scanner scan = new Scanner(System.in);
      String equ = "";
      int num = 0;
      char cursor = ' ';
      char symbol;
      int temp1, temp2;
      LinkedStack <Integer> numbers = new LinkedStack <Integer> ();
      LinkedStack <Character> operators = new LinkedStack <Character> ();

      
      //prompt user for input
      System.out.println("Enter a mathematical expression: ");
      equ = scan.nextLine();
      
      for(int pos = 0; pos < equ.length(); pos++) {
         cursor = equ.charAt(pos);
         if(cursor == '(')       //if open parentheses
            operators.push(cursor);
         else if(Character.isDigit(cursor)) {   //if digit
            num = pos;
            for(pos++; pos < equ.length() && Character.isDigit(equ.charAt(pos)); pos++);  //get whole digit
            num = Integer.parseInt(equ.substring(num, pos));
            numbers.push(num);
            pos--;   //fix pos to not skip next operator
         }
         else if(cursor == '*' ||  cursor == '/' || cursor == '+' || cursor == '-') {
            while(operators.isEmpty() == false && operators.peek() != '(' && !precidence(cursor, operators.peek()) ) {
               symbol = operators.pop();  //grab top operator
               temp1 = numbers.pop();     //grab first two numbers
               temp2 = numbers.pop();     //
               numbers.push(performOp(temp1, symbol, temp2));  //compute math and return to stack
            }//end while
            operators.push(cursor);
         }//end else if
         else {
            //discard next char ')'
            while(operators.isEmpty() == false && operators.peek() != '(') {
               symbol = operators.pop();
               temp1 = numbers.pop();
               temp2 = numbers.pop();
               numbers.push(performOp(temp1, symbol, temp2));  //call method
            }
            if(operators.peek() != '(')
               throw new IllegalArgumentException("Unbalanced Parentheses!");
            operators.pop();
         }                
      }//end for
      while(!operators.isEmpty()) {
         symbol = operators.pop();
         temp1 = numbers.pop();
         temp2 = numbers.pop();
         numbers.push(performOp(temp1, symbol, temp2)); //call method
      }
      //print result
      System.out.println("The result is " + numbers.pop());   
   }
   public static boolean precidence(char a, char b) {
      //determine precidence of current and next operator
      return((a == '*' || a == '/') && (b == '+' || b == '-'));
   }
   
   public static int performOp(int a, char b, int c) {
      switch(b) {    //determine the outcome based on the operator
         case '*': return c * a;
         case '/': return c / a;
         case '+': return c + a;
         case '-': return c - a;
      }
      return -1;   //should never reach this return
   }   
      
}
