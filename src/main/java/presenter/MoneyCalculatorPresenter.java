package presenter;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;

import java.io.IOException;
import java.util.List;

public class MoneyCalculatorPresenter {
    private final List<Currency> currencies;
    private final ExchangeRateLoader rateLoader;

    public MoneyCalculatorPresenter(List<Currency> currencies, ExchangeRateLoader rateLoader) throws IOException {
        this.currencies = currencies;
        this.rateLoader = rateLoader;
    }

    public List<Currency> getCurrencies() {
        return this.currencies;
    }

    public double convert(String amountText, Currency from, Currency to) {
        Command command = new MoneyCalculatorCommand(amountText, from, to);
        return command.execute(rateLoader);
    }
}