package control;

import model.Currency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorControllerTest {
    @Test
    void convertShouldReturnCorrectConversion() throws Exception {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        List<Currency> currencies = controller.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        double result = controller.convert("10", from, to);
        assertTrue(result >= 0);
    }

    @Test
    void convertShouldFailIfInputIsEmpty() throws Exception {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        List<Currency> currencies = controller.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        assertThrows(NumberFormatException.class, () -> {
            controller.convert("", from, to);
        });
    }

    @Test
    void convertShouldFailIfInputIsNotANumber() throws Exception {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        List<Currency> currencies = controller.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);

        assertThrows(NumberFormatException.class, () -> {
            controller.convert("abc", from, to);
        });
    }
}
