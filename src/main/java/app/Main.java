package app;

import models.Currency;
import models.Money;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(new Currency("EUR", "Euro"), 1);
        System.out.println(money);
    }
}
