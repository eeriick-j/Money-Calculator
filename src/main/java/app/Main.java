package app;

import io.CurrencyLoader;
import models.Currency;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Currency> currencyLoader = new CurrencyLoader().loadAll();
        for (Currency currency : currencyLoader) System.out.println(currency);
    }
}
