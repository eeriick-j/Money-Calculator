package presenter;

import io.ExchangeRateLoader;

public interface Command {
    Conversion execute(ExchangeRateLoader rateLoader);
}
