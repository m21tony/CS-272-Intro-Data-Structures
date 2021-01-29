//***********************************************************************************
// PseudoRandom.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: February 06, 2018
//***********************************************************************************

public class PseudoRandom {
	private double multiplier;
	private double increment;
	private double modulus;
	private int seed;
	
	/**
	 * Constructor for the Pseudorandom class
	 * @param:
	 * 	multi - used to feed multiplier into the class
	 * 	i - used to feed increment into the class
	 *	mod - used to feed modulus into the class
	 *	s - used to feed seed into the class
	 * @precondition:
	 * 	mod != 0
	 * @return:
	 * 	nonw
	 * @throws:
	 * 	none
	 **/
	PseudoRandom(double multi, double i, double mod, int s){
		multiplier = multi;
		increment = i;
		modulus = mod;
		seed = s;
	}
	
	/**
	 * Used to change the seed
	 * @param:
	 * 	newSeed - the new seed for the class
	 * @precondition:
	 * 	none
	 * @return:
	 * 	The new seed will be the seed for the new calculations
	 * @throws:
	 * 	none
	 **/
	void changeSeed (int newSeed) {
		seed = newSeed;
	}
	
	/**
	 * Produces a random integer
	 * @param:
	 * 	none
	 * @precondition:
	 * 	modulus != 0
	 * @return:
	 * 	A new random int will be produced and the seed will be changed
	 * @throws:
	 * 	none
	 **/
	int nextInt() {
		int answer = 0;
		if (modulus != 0.0) {
			answer = ((int)multiplier * seed + (int)increment) % (int)modulus;
			seed = answer;
		}
		else 
			System.out.println("Choose a new number for modulus that does not = 0");
		return answer;
	}
	
	/**
	 * Produces a new random double value
	 * @param:
	 * 	none
	 * @precondition:
	 * 	modulus != 0
	 * @return:
	 * 	A new random double will be produced and seed will change
	 * @throws:
	 * 	none
	 **/
	double nextDouble() {
		double mod1 = modulus;
		double number;
		double temp = 0;
		
		if (modulus != 0) {
			for (int i = 0; i < 1; i++) {
				number = (multiplier * seed + increment) % mod1;
				seed = (int)number;
				temp = number / modulus;
			}
		}
		else
			System.out.println("Choose a new number for modulus that does not = 0");
		return temp;
	}
}
