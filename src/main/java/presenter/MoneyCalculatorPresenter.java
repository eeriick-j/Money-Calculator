package presenter;

import io.ExchangeRateLoader;
import model.Currency;

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

    public Conversion convert(String amountText, Currency from, Currency to) {
        if (amountText == null || amountText.isBlank()) return Conversion.error("Empty amount");

        final double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            return Conversion.error("Invalid amount");
        }
        Command command = new MoneyCalculatorCommand(amount, from, to);
        return command.execute(rateLoader);
    }
}