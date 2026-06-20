package presenter;

import io.ExchangeRateLoader;
import model.Currency;

public class MoneyCalculatorCommand implements Command {
    String amountText;
    Currency from;
    Currency to;

    public MoneyCalculatorCommand(String amountText,
                                  Currency from,
                                  Currency to) {
        this.amountText = amountText;
        this.from = from;
        this.to = to;
    }

    @Override
    public double execute(ExchangeRateLoader exchangeRateLoader) {
        double amount = Double.parseDouble(amountText);
        double rate = exchangeRateLoader.load(from, to).rate();
        return amount * rate;
    }
}
