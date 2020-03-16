package mpgcalculator;

/******************************************************************************
* MPGCalculator.java 
* Programmer: @author jcboyd
* Version: 1.0
* Course: SDEV 2210
* This program uses a simple Miles Per Gallon calculator to practice unit 
* testing
******************************************************************************/


public class MPGCalculator {

    public static void main(String[] args) {

        System.out.println("Ch 7 MPG project by JC Boyd\n");
        
        MPG trip1 = new MPG(320, 29);
        MPG trip2 = new MPG(325.8, 32.1);
        MPG trip3 = new MPG(412.5, 35);
        MPG trip4 = new MPG(345, 32.6);
        
        trip1.displayCurrentMPG();
        trip2.displayCurrentMPG();
        trip3.displayCurrentMPG();
        trip4.displayCurrentMPG();
        
        MPG.displayTotalMPG();
        
    } //end main
    
} //end class MPGCalculator
