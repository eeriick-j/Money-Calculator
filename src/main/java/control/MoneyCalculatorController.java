package control;

import io.ExchangeRateLoader;
import model.Currency;
import model.Money;

import java.util.List;

public class MoneyCalculatorController {
    private final List<Currency> currencies;
    private final ExchangeRateLoader rateLoader;

    public MoneyCalculatorController(List<Currency> currencies, ExchangeRateLoader rateLoader) {
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

        Command command = new MoneyCalculatorCommand(new Money(from, amount), to, rateLoader);
        return command.execute();
    }
}