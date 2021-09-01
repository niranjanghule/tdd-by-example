package org.sng;

import org.junit.Test;

import static org.junit.Assert.*;

//$5 + 10CHF = $10 if rate is 2:1
//$5 * 2 = $10
//Make amount private
//Dollar side effects?
//Money rounding?
public class MultiCurrencyMoneyTest {

    @Test
    public void testMuliplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15),five.times(3));
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        //Triangulation
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

    @Test
    public void testFrancMuliplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15),five.times(3));
    }
}
