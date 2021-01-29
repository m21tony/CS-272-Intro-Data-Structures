import java.util.Scanner;

public class DNA {
	//
	//
	//Main Method, creates space and instruction for user input
	//
	//
	public static void main (String args[]){
		Scanner scan = new Scanner (System.in);
		System.out.print("Please input a DNA strand: ");
		String userDNA = scan.nextLine();
		System.out.println("You entered: " + userDNA);
		
		System.out.println();
		System.out.println();
		
		CharNode dnaList = DNA.stringToList(userDNA);
		System.out.println("Your DNA list is: " + dnaList );
		System.out.println("The corresponding mRNA list is: " + DNA.dnaToRNA(DNA.stringToList(userDNA)));
		
		System.out.println();
		
		System.out.print("Please enter sequence 1: ");
		String dna1 = scan.nextLine();
		System.out.print("You entered: " + dna1.toString() + "\n");
		System.out.print("Please enter sequence 2: ");
		String dna2 = scan.nextLine();
		System.out.print("You entered: " + dna2.toString() + "\n");
        CharNode d1 = DNA.stringToList(dna1);
        CharNode d2 = DNA.stringToList(dna2);
        if (DNA.perfAlignment(d1, d2))
            System.out.println("The sequences can be perfectly aligned");
        else
            System.out.println("The sequences can not be perfectly aligned");
	}
		//
		//
		//stringToList converts user input char string into linked list
		//Precondition: User input String of char's, no null values
		//Postcondiion: Linked List created with same nodes as char's from String
		public static CharNode stringToList(String userDNA){
			CharNode head;
			CharNode temp;
			head = new CharNode(userDNA.charAt(0),null);
			temp = head;
			for (int i = 0; i < userDNA.length(); i++){
				CharNode c = new CharNode(userDNA.charAt(i), null);
				temp.setLink(c);
				temp = temp.getLink();
			}
				return head;
		}
		//
		//
		//dnaToRNA determines the mRNA matching pattern to the user input DNA sequence
		//Preconditon: User input DNA string transposed into a linked list
		//Postcondition: mRNA sequence for input DNA sequence is created
		public static CharNode dnaToRNA(CharNode dnaList)
		   {
			
			   CharNode mRNA = CharNode.listCopy(dnaList);
			   CharNode cursor;
			   for(cursor = mRNA; cursor != null; cursor = cursor.getLink()){
				   if (cursor.getData()== 'a' || cursor.getData()=='A')
					   cursor.setData('T');
				   else if (cursor.getData()== 'g' || cursor.getData()=='G')
					   cursor.setData('C');
				   else if (cursor.getData()== 'c' || cursor.getData()=='C')
					   cursor.setData('G');
				   else if (cursor.getData()== 't' || cursor.getData()=='T')
					   cursor.setData('A');
			   }
			   return mRNA;   
		   } 

			//
			//
			//perfAlignment determines whether two DNA strands can be aligned side by side
			//Precondition: Two user input DNA sequences
			//Postcondition: Boolean indicating wether or not sequences can be aligned
		public static boolean perfAlignment(CharNode dna1, CharNode dna2){
			String one;
			String two;
			 			   
			if (CharNode.listLength(dna1) > CharNode.listLength(dna2))
				one = dna1.toString();
			else 
				one = dna2.toString();
			if(one == dna1.toString())
				two = dna2.toString();				 
			else
				two = dna1.toString();
			boolean result;
			int j = 0;
			for(int i = 0; i < two.length(); i++){
				if(two.charAt(i)==one.charAt(j))
					j = j++;
			}
				if(j == two.length()-1)
					result = true;
				
				else
					result = false;
					
			
			return result;
	  
		   } 


}
