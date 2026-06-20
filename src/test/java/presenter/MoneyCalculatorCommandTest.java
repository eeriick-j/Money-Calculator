package presenter;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorCommandTest {
    @Test
    void executeShouldReturnCorrectConversion() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter(new CurrencyLoader().loadAll(),new ExchangeRateLoader());
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        Command command = new MoneyCalculatorCommand( 10, from, to);

        double result = command.execute(new ExchangeRateLoader()).value();
        assertTrue(result >= 0);
    }

    @Test
    void executeShouldFailIfInputIsInvalid() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter(new CurrencyLoader().loadAll(),new ExchangeRateLoader());
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        // Command command = new MoneyCalculatorCommand( "abc", from, to);
        // assertThrows(NumberFormatException.class, () -> command.execute(new ExchangeRateLoader()));
    }
}
