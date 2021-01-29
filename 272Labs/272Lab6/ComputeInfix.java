//ComputeInfix.java
//Written by: Greg De La Torre
//Program written to solve an Infix program and return result
//CS272
import java.util.Scanner;

public class ComputeInfix {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Please enter an arithmatic fuction");
		String s = scan.nextLine();
		int fin = compute(s);
		System.out.println("The value of your fuction is: " + fin);
		
		
	}
	//compute method computes given arithmatic expression
	//Precondition:arithmatic expression
	//Postcondition:result
	public static int compute(String answer){
		LinkedStack<Integer> nums = new LinkedStack<Integer> ();
		LinkedStack<Character> operands = new LinkedStack<Character>();
		int result = 0;
		for(int i = 0; i< answer.length(); i++){
			char check = answer.charAt(i);
			
				while(!operands.isEmpty()){
				if(check == '(')
					operands.push(check);
				else if(check == '+')
					operands.push(check);
				else if(check == '-')
					operands.push(check);
				else if(check == '*')
					operands.push(check);
				else if(check == '/')
					operands.push(check);
				else if(check == ')'){
					char ops = operands.pop();
					int v = nums.pop();
				}
				else {
					int start = answer.indexOf(answer.charAt(i));
					int l = start;
					int ans;
					while (l < answer.length() && Character.isDigit(answer.charAt(l))) { 
					        l++;
					}
					ans = Integer.parseInt(answer.substring(start,l));
					nums.push(ans);
				}
					char op = operands.pop();
					int val1 = nums.pop();
					int val2 = nums.pop();
					if(op == '+')
						result = val1 + val2;
					else if(op =='-')
						result = val1 - val2;
					else if(op =='/')
						result = val1 / val2;
					else if(op =='*')
						result = val1 * val2;	
				}	
				return result;
			}
		
	}
}
