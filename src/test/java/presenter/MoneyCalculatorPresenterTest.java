package presenter;

import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MoneyCalculatorPresenterTest {

    @Mock
    ExchangeRateLoader loader;
    MoneyCalculatorPresenter presenter;
    Currency usd = new Currency("USD", "Dollar");
    Currency eur = new Currency("EUR", "Euro");

    @BeforeEach
    void setUp() {
        presenter = new MoneyCalculatorPresenter(List.of(usd, eur), loader);
    }

    @Test
    void nullInputReturnsError() {
        Conversion result = presenter.convert(null, usd, eur);

        assertFalse(result.success());
        assertEquals("Empty amount", result.error());
    }

    @Test
    void emptyInputReturnsError() {
        Conversion result = presenter.convert("", usd, eur);

        assertFalse(result.success());
        assertEquals("Empty amount", result.error());
    }

    @Test
    void blankInputReturnsError() {
        Conversion result = presenter.convert("   ", usd, eur);
        assertFalse(result.success());
    }

    @Test
    void invalidInputReturnsError() {
        Conversion result = presenter.convert("abc", usd, eur);

        assertFalse(result.success());
        assertEquals("Invalid amount", result.error());
    }

    @Test
    void numberWithLettersReturnsError() {
        Conversion result = presenter.convert("10a", usd, eur);

        assertFalse(result.success());
    }

    @Test
    void validInputReturnsConversion() {
        when(loader.load(usd, eur))
                .thenReturn(new ExchangeRate(usd, eur, 2.0));

        Conversion result = presenter.convert("10", usd, eur);

        assertTrue(result.success());
        assertEquals(20.0, result.value());
    }

    @Test
    void decimalInputWorks() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 1.5));

        Conversion result = presenter.convert("2.5", usd, eur);
        assertEquals(3.75, result.value());
    }

    @Test
    void presenterCallsLoader() {
        when(loader.load(usd, eur)).thenReturn(new ExchangeRate(usd, eur, 2.0));

        presenter.convert("10", usd, eur);
        verify(loader).load(usd, eur);
    }
}
