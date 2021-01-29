//***********************************************************************************
// BagTester.java
// CS 272 Section M01
// Written by Antonio Maldonado
// Date: February 12, 2018
//***********************************************************************************

import java.util.*;

public class BagTester {

    public static void main(String[] args) {
    
        //creating two new IntArrayBags
        IntArrayBag b1 = new IntArrayBag(); 
        IntArrayBag b2 = new IntArrayBag();
        
        //Setting up a scanner
        Scanner scan = new Scanner(System.in);
        
        int input; //int to store the user input to decide action
        int element; //int to store the element that the user wants to add to/ remove from the bag
        
        //Prompts user to enter values
        System.out.println("Bags b1 and b2 are created.");
        System.out.println("You may do the following actions: "
                + "\n0 - quit;"
                + "\n1 - add an element to b1"
                + "\n2 - remove an element from b1"
                + "\n3 - add an element to b2"
                + "\n4 - remove an element from b2"
                + "\n5 - check if b1 equals b2"
                + "\n6 - remove all elements of b2 from b1"
                + "\n7 - find intersection(b1, b2)");
        
        System.out.println("b1 = " + b1 + " b2 = " + b2);
        System.out.println("Enter an integer from 0 to 7: ");
        input = scan.nextInt(); //get user input
        
        //runs until user enters zero
        while( input != 0 ) {
            //checks for invalid input
            if( input < 0 || input > 7)
                System.out.println( "Invalid input.");
            
            //adds an element to b1
            if( input == 1 ) {
                  System.out.println( "Please enter the element: " );
                  element = scan.nextInt();
                b1.add( element );
                System.out.println( element + " added to b1.");
            }
            
            //removes an element from b1
            if( input == 2 ) {
                  System.out.println( "Please enter the element: " );
                  element = scan.nextInt();
                  
                if(b1.remove( element ) == true)
                    System.out.println( element + " removed from b1.");
                else
                    System.out.println( element + " is not in b1.");
            }
            
            //adds an element to b2
            if( input == 3 ) {
                  System.out.println( "Please enter the element: " );
                  element = scan.nextInt();
                  
                b2.add( element );
                System.out.println( element + " has been added to b2.");
            }
            
            //removes an element from b2
            if( input == 4 ) {
                  System.out.println( "Please enter the element: " );
                  element = scan.nextInt();
                  
                if(b2.remove( element ) == true)
                    System.out.println( element + " removed from b2.");
                else
                    System.out.println( element + " is not in b2.");
            }
            
            //checks b1 and b2 for equality
            if( input == 5 ) {
                if( b1.equals( b2 ) )
                    System.out.println( "b1 and b2 are equal" );
                else if( !b1.equals( b2 ))
                    System.out.println( "b1 and b2 are not equal" );
            }
            
            //Removes all elements of b2 from b1
            if( input == 6 ) {
                b1.removeAll(b2);
                System.out.println( "Elements of b2 removed from b1" );
            }
            
            //Finds the intersection of b1 and b2
            if( input == 7 ) {
                System.out.println( "Intersection of b1 and b2 is: " + IntArrayBag.intersection( b1, b2 ));
            }
            
            //after performing an action, the program prompts the user for input again
            System.out.println("b1 = " + b1 + " b2 = " + b2);
               System.out.println("Enter an integer from 0 to 7: ");
               input = scan.nextInt();
        }
        
    }

}