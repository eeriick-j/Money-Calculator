package control;

import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MoneyCalculatorCommandTest {

    @Mock
    ExchangeRateLoader loader;
    Currency usd = new Currency("USD", "Dollar");
    Currency eur = new Currency("EUR", "Euro");

    @Test
    void convertsCorrectly() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 10), eur, loader);
        Conversion result = command.execute();

        assertTrue(result.success());
        assertEquals(20.0, result.money().amount());
    }

    @Test
    void zeroAmountReturnsZero() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 0), eur, loader);
        Conversion result = command.execute();

        assertEquals(0.0, result.money().amount());
    }

    @Test
    void decimalValuesWork() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 1.5));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 2.5), eur, loader);
        Conversion result = command.execute();

        assertEquals(3.75, result.money().amount());
    }

    @Test
    void very_large_values_work() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 1_000_000), eur, loader);
        Conversion result = command.execute();

        assertEquals(2_000_000, result.money().amount());
    }

    @Test
    void resultCarriesTargetCurrency() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 10), eur, loader);
        Conversion result = command.execute();

        assertEquals(eur, result.money().currency());
    }

    @Test
    void differentCurrenciesCallLoader() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        MoneyCalculatorCommand command = new MoneyCalculatorCommand(new Money(usd, 10), eur, loader);
        command.execute();

        verify(loader).load(usd, eur);
    }
}