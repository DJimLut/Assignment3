/*
 * David Jimenez
 * Mason Richardson
 * CSC-445 Assignment 3
 */

package main;

import java.util.Arrays;

import static java.util.Arrays.*;

public class CoinChange {

    /**
     * @param coinValues is the coin denominations
     * @param change is the amount of change needed
     * @return the number of coins needed to give correct change
     */
    public static int coinChangeDP(int[] coinValues, int change) {
        //Check if change is negative or 0
        if (change <= 0) {
            return 0;
        }
        //Check for negative values in coinValues
        for (int i = 0; i < coinValues.length; i++) {
            if (coinValues[i] < 0) {
                return 0;
            }
        }

        //Calculate problem
        int stored[] = new int[change + 1]; //Create array to store already found values
        Arrays.fill(stored, Integer.MAX_VALUE); //Set array values as infinite
        stored[0] = 0; //Base case

        for (int i = 1; i <= change; i++) {
            for (int j = 0; j < coinValues.length; j++) {
                if (coinValues[j] <= i) {
                    int temp = stored[i - coinValues[j]];
                    if(temp != Integer.MAX_VALUE && (temp + 1) < stored[i]){
                        stored[i] = temp + 1;
                    }
                }
            }
        }
        return stored[change];
    }


    /**
     * @param coinValues is the coin denominations
     * @param change is the amount of change needed
     * @return the number of coins needed to give correct change
     */
    public static int coinChangeGreedy (int[] coinValues, int change ) {
        int coins = 0;
        sort( coinValues );
        for( int i = coinValues.length - 1; i >= 0; i-- ) {
            if( change < 1 || coinValues[i] < 1 ) return 0; // Check for negatives
            while( change >= coinValues[i] ) { // if the amount of change is still greater than i's denomination
                change -= coinValues[i]; // subtract that amount
                coins++; // add to the number of coins needed
            }
        }
        return coins;
    }

    public void Main( String[] args ) {
        // TODO: Implement main method
    }
}