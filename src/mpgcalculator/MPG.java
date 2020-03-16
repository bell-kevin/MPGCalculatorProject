package mpgcalculator;

/******************************************************************************
* MPG.java 
* Programmer: @author jcboyd
* Version: 1.0
* Course: SDEV 2210
* This program is associated with MPGCalculator.java 
******************************************************************************/

public class MPG {
    
    private static double totalMiles, totalGallons, totalMPG;
    private static int numTrips = 0;
    private double miles, gallons, mpg;
    
    public MPG(double miles, double gallons) {
        this.miles = miles;
        this.gallons = gallons;
        totalMiles += miles;
        totalGallons += gallons;
        numTrips =+ 1;
        this.mpg = this.miles / this.gallons;
    } //end MPG constructor
    
    public void displayCurrentMPG() {
        System.out.printf("This trip = %-5.2f MPG\n", this.mpg);
    } //end displayCurrentMPG
    
    public static void displayTotalMPG() {
        totalMPG = totalMiles / totalGallons;
        System.out.printf("For %-1d trips, total MPG = %-6.2f\n",
                numTrips, totalMPG);
    } //end displayTotalMPG
    
} //end class MPG
