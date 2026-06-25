package control;

import model.Money;

public record Conversion(boolean success, Money money, String error) {
    public static Conversion ok(Money money) {
        return new Conversion(true, money, null);
    }

    public static Conversion error(String message) {
        return new Conversion(false, null, message);
    }
}