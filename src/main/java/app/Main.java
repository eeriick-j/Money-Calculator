package app;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import models.Currency;
import models.ExchangeRate;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = new CurrencyLoader().loadAll();
        ExchangeRate exchangeRate = new ExchangeRateLoader().load(currencies.getFirst(), currencies.getLast());
        ExchangeRate hardcodedExchangeRate = new ExchangeRateLoader().load(new Currency("EUR", "Euro"), new Currency("USD", "Dólar Estadounidense"));

        System.out.println(exchangeRate);
        System.out.println(hardcodedExchangeRate);
    }
}
