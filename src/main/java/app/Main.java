package app;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import control.MoneyCalculatorController;
import view.MoneyCalculatorView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MoneyCalculatorController controller = new MoneyCalculatorController(
                new CurrencyLoader().loadAll(),
                new ExchangeRateLoader()
        );
        MoneyCalculatorView view = new MoneyCalculatorView(controller);
        view.setVisible(true);
    }
}
