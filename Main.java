import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel counterLabel; 

  JTextField countDownArea; 

  JButton countButton;

  JButton resetButton;

  JPanel mainPanel;



  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

     // initialize the main panel 
     mainPanel = new JPanel();
     // tell the main we will do a manual layout 
     mainPanel.setLayout(null);

     // initialize the first label 
     counterLabel = new JLabel("Counter:");
     // set bounds for the label 
     counterLabel.setBounds(100,100,100,50);


     // initialize the text area 
     countDownArea = new JTextField("10");
     // set bounds for the countdown area 
     countDownArea.setBounds(170, 105, 150,40);
    

     // initialize the count down button 
     countButton = new JButton("Count Down");
     // set bounds for the button 
     countButton.setBounds(100, 180,120,20);

     // initialize the reset button 
     resetButton = new JButton("Reset");
     // set bounds for the button 
     resetButton.setBounds(240,180,75,20); 


     // set the action command so we know which button was  pressed
     countButton.setActionCommand("Count Down");
     resetButton.setActionCommand("Reset");

     // add the action listener 
     countButton.addActionListener(this);
     resetButton.addActionListener(this);

     // make it so they cant type in areas 
     countDownArea.setEnabled(false);
  

     // add the label to the main panel
     mainPanel.add(counterLabel);

    // add the text field to the main panel
    mainPanel.add(countDownArea);

    // add the buttons to the main panel 
    mainPanel.add(countButton);
    mainPanel.add(resetButton);



    // add the main panel to the frame 
    frame.add(mainPanel);
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

     
    
    // get the number on the text area and make a string
    String countTen = countDownArea.getText();
    // convert the string into integer
    int countDown =  Integer.parseInt(countTen);
      
       
    // create a variable to start at 10
    int i = 10;
    // make an if statement to see if the button was pressed
    if(command.equals("Count Down")){
    // Count Down button was pressed 
    // make an accumulator that decreases the count down
    int total = countDown - 1;
    // print it out into the text area
    countDownArea.setText("" + total);
    // if the count down is 0 then the count down will stop there
    if(countDown == 0){
      countDownArea.setText("0");
      
    }
    }

    // which button was pressed
    if(command.equals("Reset")){
      // Reset button was pressed 
      // reset the count down and start from 10 again
      countDownArea.setText("" + i);
          
      
    }
        
        
  }
       
      
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
