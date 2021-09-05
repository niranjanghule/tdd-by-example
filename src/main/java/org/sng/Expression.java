package org.sng;

public interface Expression {
    Money reduce(Bank bank,String to);
}
