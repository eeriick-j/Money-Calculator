package control;

import model.Currency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCalculatorCommandTest {
    @Test
    void executeShouldReturnCorrectConversion() throws Exception {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        List<Currency> currencies = controller.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        Command command = new MoneyCalculatorCommand(controller, "10", from, to);

        double result = command.execute();
        assertTrue(result >= 0);
    }

    @Test
    void executeShouldFailIfInputIsInvalid() throws Exception {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        List<Currency> currencies = controller.getCurrencies();
        Currency from = currencies.get(0);
        Currency to = currencies.get(1);
        Command command = new MoneyCalculatorCommand(controller, "abc", from, to);

        assertThrows(NumberFormatException.class, command::execute);
    }
}
