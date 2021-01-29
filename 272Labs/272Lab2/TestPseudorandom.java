import java.util.Scanner;

public class TestPseudorandom {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		//Introduction and user prompts to input values
		
		System.out.println("This program will generate Pseudorandom numbers based off of given values.");
		System.out.println();
		
		System.out.println("Enter initial value of Seed: ");
		int seed = scan.nextInt();
		
		System.out.println("Enter initial value of Multiplier: ");
		int multiplier = scan.nextInt();
		
		System.out.println("Enter initial value of Increment: ");
		int increment = scan.nextInt();
		
		System.out.println("Enter initial value of Modulus:");
		int modulus = scan.nextInt();
		
		//Create a Pseudorandom object using User given values
		
		Pseudorandom newPattern = new Pseudorandom(multiplier, increment, modulus, seed);
		
		//Demonstrate the created object using accessors
		
		System.out.println();
		System.out.println("The seed is: " + newPattern.getSeed());
		System.out.println("The multiplier is: " + newPattern.getMultiplier());
		System.out.println("The modulus is: " + newPattern.getModulus());
		System.out.println("The increment is: " + newPattern.getIncrement());

		//Ask the user how many numbers to generate, and generate that amount of Pseudorandom intergers
		
		System.out.println();
		System.out.println("How many digits do you wish to generate?");
		int numbers = scan.nextInt();
		for (int i = 1; i <= numbers; i++){
			System.out.println("The " + i + " number generated and new seed is: " + newPattern.nextInt());
		}	
		
		//Demonstrate changeSeed() by prompting the user to input a new seed value
		
		System.out.println();
		System.out.println("Please enter a new seed value");
		int newSeed = scan.nextInt();
		newPattern.changeSeed(newSeed);
		
		//Demonstrate the seed value was changed using getSeed()
		
		System.out.println();
		System.out.println("The seed value has been changed to: " + newPattern.getSeed());
		
		//Demonstrate nextDouble() by generating a Pseudorandom double between [0, 1) using nextDouble()
		
		System.out.println();
		System.out.println("The double value Pseudorandomly generated from the new seed is: " + newPattern.nextDouble());
		
	}
}
