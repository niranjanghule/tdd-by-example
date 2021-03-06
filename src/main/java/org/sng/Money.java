package org.sng;

public class Money implements Expression {
    protected int amount;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression times(int multiplier){
        return new Money(amount * multiplier,currency);
    };

    public static Money dollar(int amount) {
        return new Money(amount,"USD");
    }

    public static Money franc(int amount) {
        return new Money(amount,"CHF");
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency() == money.currency();
    }

    protected String currency;
    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank,String to) {
        int rate = bank.rate(currency,to);
        return new Money(amount/rate, to);
    }
}
