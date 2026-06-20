package app;

import io.CurrencyLoader;
import io.ExchangeRateLoader;
import presenter.MoneyCalculatorPresenter;
import view.MoneyCalculatorView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter(
                new CurrencyLoader().loadAll(),
                new ExchangeRateLoader()
        );
        MoneyCalculatorView view = new MoneyCalculatorView(presenter);
        view.setVisible(true);
    }
}
