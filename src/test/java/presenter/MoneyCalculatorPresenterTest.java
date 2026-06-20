package presenter;

import model.Currency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorPresenterTest {
    @Test
    void convertShouldReturnCorrectConversion() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        double result = presenter.convert("10", from, to);
        assertTrue(result >= 0);
    }

    @Test
    void convertShouldFailIfInputIsEmpty() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        assertThrows(NumberFormatException.class, () -> {
            presenter.convert("", from, to);
        });
    }

    @Test
    void convertShouldFailIfInputIsNotANumber() throws Exception {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        List<Currency> currencies = presenter.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        assertThrows(NumberFormatException.class, () -> {
            presenter.convert("abc", from, to);
        });
    }
}
