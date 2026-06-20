package presenter;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;

import java.io.IOException;
import java.util.List;

public class MoneyCalculatorPresenter {
    private final List<Currency> currencies;

    public MoneyCalculatorPresenter() throws IOException {
        this.currencies = new CurrencyLoader().loadAll();
    }

    public List<Currency> getCurrencies() {
        return this.currencies;
    }

    public double convert(String amountText, Currency from, Currency to) {
        double amount = Double.parseDouble(amountText);
        double rate = new ExchangeRateLoader().load(from, to).rate();
        return new ExchangeRate(from, to, rate).convert(amount);
    }
}