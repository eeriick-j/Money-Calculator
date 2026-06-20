package presenter;

import io.ExchangeRateLoader;
import model.Currency;

public class MoneyCalculatorCommand implements Command {
    double amount;
    Currency from;
    Currency to;

    public MoneyCalculatorCommand(double amount,
                                  Currency from,
                                  Currency to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    @Override
    public Conversion execute(ExchangeRateLoader exchangeRateLoader) {
        double rate = exchangeRateLoader.load(from, to).rate();
        return Conversion.ok(amount * rate);
    }
}
