package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateTest {
    @Test
    void convertShouldWorkCorrectly() {
        Currency usd = new Currency("USD", "United States Dollar");
        Currency eur = new Currency("EUR", "Euro");
        ExchangeRate rate = new ExchangeRate(usd, eur, 2.0);

        double result = rate.convert(10);
        assertEquals(20.0, result);
    }
}