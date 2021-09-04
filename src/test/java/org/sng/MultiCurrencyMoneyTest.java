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
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15),five.times(3));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        //Triangulation
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD",Money.dollar(5).currency());
        assertEquals("CHF",Money.franc(5).currency());
    }

    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        assertEquals(Money.dollar(10), bank.reduce(sum,"USD"));
    }

    @Test
    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum(){
        Expression sum  = new Sum(Money.dollar(5), Money.dollar(4));
        Bank bank = new Bank();
        assertEquals(Money.dollar(9), bank.reduce(sum, "USD"));
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);

    }

}
