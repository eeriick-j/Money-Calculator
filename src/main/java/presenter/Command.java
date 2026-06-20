package presenter;

import io.ExchangeRateLoader;

public interface Command {
    double execute(ExchangeRateLoader rateLoader);
}
