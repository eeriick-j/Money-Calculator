package control;

import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;
import model.Money;

public class MoneyCalculatorCommand implements Command {
    private final Money input;          // ← en lugar de double amount + Currency from
    private final Currency to;
    private final ExchangeRateLoader exchangeRateLoader;

    public MoneyCalculatorCommand(Money input, Currency to, ExchangeRateLoader loader) {
        this.input = input;
        this.to = to;
        this.exchangeRateLoader = loader;
    }

    @Override
    public Conversion execute() {
        ExchangeRate rate = exchangeRateLoader.load(input.currency(), to);
        double converted = rate.convert(input.amount()); // ← ahora sí usas ExchangeRate.convert()
        return Conversion.ok(new Money(to, converted));  // ← devuelves Money, no un double suelto
    }
}
