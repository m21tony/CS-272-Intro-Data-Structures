//BagApplet, modified to satisfy assignment 
//Greg De La Torre
//CS272 - Lab 3

import java.applet.Applet;
import java.awt.*;          // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*;    // Imports ActionEvent, ActionListener


public class BagApplet extends Applet
{  
   // An IntArrayBag for this Applet to manipulate:
   private IntArrayBag b1 = new IntArrayBag( );
   private IntArrayBag b2 = new IntArrayBag( );


   // These are the interactive Components that will appear in the Applet.
   // We declare one Button for each IntArrayBag method that we want to be able to
   // test. If the method has an argument, then there is also a TextField
   // where the user can enter the value of the argument.
   // At the bottom, there is a TextArea to write messages.
   private Button    addButton1              = new Button("b1.add( )");
   private Button    addButton2              = new Button("b2.add( )");
   private Button    removeButton1           = new Button("b1.remove( )");
   private Button    removeButton2           = new Button("b2.remove( )");
   private Button    toStringButton1         = new Button("b1.toString( )");
   private Button    toStringButton2         = new Button("b2.toString( )");
   private Button    equalsButton           = new Button("b1.equals(b2)");
   private TextField elementText            = new TextField(10);
   private TextArea  feedback               = new TextArea(7, 60);
   

   public void init( )
   {      
      // Some messages for the top of the Applet:   
      add(new Label("This test program has created two bags: b1 and b2."));
      add(new Label("Press buttons to activate methods."));
      addHorizontalLine(Color.blue);
       

      
      // The Button and TextField for testing the add method on b1:
      add(addButton1);
 
      
      // The Button for testing the Remove method on b1
      add(removeButton1);
      add(elementText);
      
      // The Button and TextField for testing the add method on b2:
      add(addButton2);
  
      // The Button for testing the Remove method on b2
      add(removeButton2);
      addNewLine( );
      
      //The Button for testing the toString method on b1
      add(toStringButton1);
      
      //The Button for testing the toString method on b2
      add(toStringButton2);
      addNewLine( );
      
      //The Button for testing the equals method
      add(equalsButton);
      addNewLine( );
      
      // A TextArea at the bottom to write messages:
      addHorizontalLine(Color.blue);
      addNewLine( );
      feedback.setEditable(false);
      feedback.append("I am ready for your first action.\n");
      add(feedback);
      
      // Tell the Buttons what they should do when they are clicked:
      addButton1.addActionListener(new AddListener1( ));
      addButton2.addActionListener(new AddListener2( ));
      removeButton1.addActionListener(new RemoveListener1( ));
      removeButton2.addActionListener(new RemoveListener2( ));
      toStringButton1.addActionListener (new ToString1());
      toStringButton2.addActionListener (new ToString2());
      equalsButton.addActionListener (new Equals());

      

   }


  //Add a value to bag b1    
   class AddListener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b1.add(element);
            feedback.append(element + " has been added to the bag b1. \n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }

   //Add a value to bag b2
   class AddListener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b2.add(element);
            feedback.append(element + " has been added to the bag b2. \n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }

   
   
   //Remove a value from bag b1
   class RemoveListener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b1.remove(element);
            feedback.append(element + " has been removed from the bag b1. \n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }
   
   //Remove a value from bag b2
   class RemoveListener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b2.remove(element);
            feedback.append(element + " has been removed from the bag b2. \n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }
   
   //Print b1
   class ToString1 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {    
            feedback.append("b1: " + b1.toString() + "\n");
                           
      }
   }
   
   
   //Print b2
   class ToString2 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {    
            feedback.append("b2: " + b2.toString() + "\n");
                           
      }
   }
   
   
   //Equals method
   class Equals implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
    	  boolean eq = b1.equals(b2);
    	  if(eq == false)
    		  feedback.append("The bags are not equal. \n");
    	  else
    		  feedback.append("The bags are equal. \n");


      }                   
   }
   
   
   private void addHorizontalLine(Color c)
   {  
      // Add a Canvas 10000 pixels wide but only 1 pixel high, which acts as
      // a horizontal line to separate one group of components from the next.
      Canvas line = new Canvas( );
      line.setSize(10000,1);
      line.setBackground(c);
      add(line);
   }

 
   private void addNewLine( ) 
   {  
      // Add a horizontal line in the background color. The line itself is
      // invisible, but it serves to force the next Component onto a new line.
      addHorizontalLine(getBackground( ));
   }

      
}

