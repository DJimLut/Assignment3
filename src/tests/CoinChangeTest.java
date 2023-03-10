package tests;

import static main.CoinChange.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void assertNoCoins() {
        int[] coinValues = { 25, 50, 10, 5 };
        int change = 1;
        int expected = 0;

        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertOneCoinGreedy() {
        int[] coinValues = { 50, 25, 10, 5, 1 };
        int change = 1;
        
        int expected = 1;
        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertOneCoinDP() {
        int[] coinValues = { 50, 25, 10, 5, 1 };
        int change = 1;

        int expected = 1;
        int actual = coinChangeDP( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertNegativeDenominationsReturnZero() {
        int[] coinValues = { -50, 25, -10, 5, 1 };
        int change = 30;

        int expected = 0;
        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertNegativeChangeReturnsZero() {
        int[] coinValues = { 50, 25, 10, 5, 1 };
        int change = -40;

        int expected = 0;
        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertDifferentNoCoins() {
        int[] coinValues = { 27, 38, 71, 96, 99, 5 };
        int change = 17;

        int expected = 3;
        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertCoinsSampleGreedy() {
        int[] coinValues = { 9, 6, 5, 1 };
        int change = 11;
        
        int expected = 3;
        int actual = coinChangeGreedy( coinValues, change );

        assertSame( expected, actual );
    }

    @Test
    public void assertCoinsSampleDP() {
        int[] coinValues = { 9, 6, 5, 1 };
        int change = 11;

        int expected = 2;
        int actual = coinChangeDP( coinValues, change );

        assertSame( expected, actual );
    }
}
