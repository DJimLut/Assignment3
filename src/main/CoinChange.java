/*
 * David Jimenez
 * Mason Richardson
 * CSC-445 Assignment 3
 */

package main;
import static java.util.Arrays.*;

public class CoinChange {
    public static int coinChangeDP( int[] coinValues, int change ) {
        // TODO: Implement method
        throw new UnsupportedOperationException();
    }

    /**
     * @param coinValues is the coin denominations
     * @param change is the amount of change needed
     * @return the number of coins needed to give correct change
     */
    public static int coinChangeGreedy( int[] coinValues, int change ) {
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