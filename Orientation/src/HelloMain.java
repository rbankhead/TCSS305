
/*
 * TCSS 305 - Winter 2020
 * Assignment 0 - Orientation 
 */

import java.awt.Color;

/**
 * This program displays a single line of output to the console
 * It also demonstrates a proper setup of the JDK and Eclipse
 * 
 * The extra credit assignment was implemented in the averageRedValue method
 * 
 * @author Richard Bankhead
 * @version 01/07/2020
 */
public class HelloMain {
	
    /** 
     * Takes in any number of Color objects and returns the mean red value of all of the parameters
     * 
     * @param color takes any number of Color objects
     * @return a double containing the average red value of the color objects
     */
	static double averageRedValue(Color ... color) {
	    
		double red=0;
		
		for (Color c : color) {
			red+=c.getRed();
		}
		
		return red/color.length;
	}

    /**
     * Main method calls the printToConsole method from the Hello class
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        Hello.printToConsole();
        
    }

}
