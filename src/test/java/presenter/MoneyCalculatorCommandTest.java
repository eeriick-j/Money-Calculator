package presenter;

import model.Currency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorCommandTest {
    @Test
    void executeShouldReturnCorrectConversion() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        Command command = new MoneyCalculatorCommand(presenter, "10", from, to);

        double result = command.execute();
        assertTrue(result >= 0);
    }

    @Test
    void executeShouldFailIfInputIsInvalid() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        Command command = new MoneyCalculatorCommand(presenter, "abc", from, to);

        assertThrows(NumberFormatException.class, command::execute);
    }
}
