//
//Class will generate a Psuedorandom number based off of user input
//
public class Pseudorandom {
	//Instance Variables
	private int multiplier, increment, modulus, seed;
	//Constructor
	public Pseudorandom (int mult, int incr, int mod, int sd){
		multiplier = mult;
		increment = incr;
		modulus = mod;
		seed = sd;
	}
	//
	//Accessors
	//
	//getSeed returns the value input for seed
	public  int getSeed(){
		return seed;
	}
	
	//getMultiplier returns the value input for multiplier
	public  int getMultiplier(){
		return multiplier;
	}
	
	//getIncrement returns the value input for increment
	public  int getIncrement(){
		return increment;
	}
	
	//getModulus returns the value input for modulus
	public  int getModulus(){
		return modulus;
	}
	
	//
	//Mutators
	//
	//changeSeed Allows the user to change the value of the seed
	public void changeSeed (int new_seed){
		seed = new_seed;
	}
	
	//nextInt generates a pseudorandom interger using the formula,and sets the seed as the integer generated
	//nextInt CANNOT work if modulus is equal to zero
	public int nextInt(){
			int random = (multiplier * seed + increment) % modulus ;
			seed = random;
			return random;
	}
	
	//nextDouble generates a pseudorandom double value between [0, 1)
	//nextDouble CANNOT work if modulus is equal to zero
	public double nextDouble(){
		return ((multiplier * seed + increment) % modulus )/ (double) modulus;
	}
	
}

	