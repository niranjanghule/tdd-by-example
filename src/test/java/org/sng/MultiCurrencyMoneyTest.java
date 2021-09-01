package org.sng;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//$5 + 10CHF = $10 if rate is 2:1
//$5 * 2 = $10
//Make amount private
//Dollar side effects?
//Money rounding?
public class MultiCurrencyMoneyTest {

    @Test
    public void testMuliplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10,product.amount);
        product = five.times(3);
        assertEquals(15,product.amount);
    }
}
