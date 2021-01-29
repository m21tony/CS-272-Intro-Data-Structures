import java.util.Scanner;

public class TestDistribution {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		//Variables used to keep count of occurences of a double within a certain range
		
			int countOne = 0;  //Count of occurences between 0.0..0.1
			int countTwo = 0;  //Count of occurences between 0.1..0.2
			int countThree = 0;  //Count of occurences between 0.2..0.3
			int countFour = 0;  //Count of occurences between 0.3..0.4
			int countFive = 0;  //Count of occurences between 0.4..0.5
			int countSix = 0;  //Count of occurences between 0.5..0.6
			int countSeven = 0;  //Count of occurences between 0.6..0.7
			int countEight = 0;  //Count of occurences between 0.7..0.8
			int countNine = 0;  //Count of occurences between 0.8..0.9
			int countTen = 0;  //Count of occureces between 0.9..1.0

		//User input for values
			
			System.out.println("This program will count the occurences of ranges of double values generated Pseudorandomly using given values.");
			System.out.println();
			
			System.out.println("Enter initial value of Seed: ");
			int seed = scan.nextInt();
			
			System.out.println("Enter initial value of Multiplier");
			int multiplier = scan.nextInt();
			
			System.out.println("Enter initial value of Increment");
			int increment = scan.nextInt();
			
			System.out.println("Enter initial value of Modulus. NOTE: Modulus CANNOT equal 0. If 0 is entered, modulus will be set to 1.");
			int modulus = scan.nextInt();
			
		//Create a new Pseudorandom using user input
			Pseudorandom newPattern = new Pseudorandom(multiplier, increment, modulus, seed);

			System.out.println();
			System.out.println("The seed is: " + newPattern.getSeed());
			System.out.println("The multiplier is: " + newPattern.getMultiplier());
			System.out.println("The modulus is: " + newPattern.getModulus());
			System.out.println("The increment is: " + newPattern.getIncrement());
			System.out.println();
			
		//Run the process 1,000,000 times in order to determine occurences
			
			for (int i = 1; i <= 1000000; i++){
				 newPattern.nextInt(); 
				double rand = newPattern.nextDouble();
					
				
		
		//Takes the value of nextDouble() generated and determines the range of values
		//And adds to the occurence count of that range
			
			if(rand <= 0.1)
				countOne ++;
			else if(rand <=0.2)
				countTwo ++;
			else if(rand <=0.3)
				countThree ++;
			else if(rand <=0.4)
				countFour ++;
			else if(rand <=0.5)
				countFive ++;
			else if(rand <=0.6)
				countSix ++;
			else if(rand <=0.7)
				countSeven ++;
			else if(rand <=0.8)
				countEight ++;
			else if(rand <=0.9)
				countNine ++;
			else if(rand <=1.0)
				countTen ++;
		}
					
		//Display the number of occurences of double values in ranges from [0, 1)
			
		System.out.println("Range [0.0..0.1)      # of occurences: " + countOne);
		System.out.println("Range [0.1..0.2)      # of occurences: " + countTwo);
		System.out.println("Range [0.2..0.3)      # of occurences: " + countThree);
		System.out.println("Range [0.3..0.4)      # of occurences: " + countFour);
		System.out.println("Range [0.4..0.5)      # of occurences: " + countFive);
		System.out.println("Range [0.5..0.6)      # of occurences: " + countSix);
		System.out.println("Range [0.6..0.7)      # of occurences: " + countSeven);
		System.out.println("Range [0.7..0.8)      # of occurences: " + countEight);
		System.out.println("Range [0.8..0.9)      # of occurences: " + countNine);
		System.out.println("Range [0.9..1.0)      # of occurences: " + countTen);

		
	}	
}
