package presenter;

import io.ExchangeRateLoader;
import model.Currency;

public class MoneyCalculatorCommand implements Command {
    private final double amount;
    private final Currency from;
    private final Currency to;
    private final ExchangeRateLoader exchangeRateLoader;

    public MoneyCalculatorCommand(double amount,
                                  Currency from,
                                  Currency to,
                                  ExchangeRateLoader exchangeRateLoader) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.exchangeRateLoader = exchangeRateLoader;
    }

    @Override
    public Conversion execute() {
        double rate = exchangeRateLoader.load(from, to).rate();
        return Conversion.ok(amount * rate);
    }
}
