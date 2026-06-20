package app;

import presenter.MoneyCalculatorPresenter;
import view.MoneyCalculatorView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MoneyCalculatorPresenter presenter = new MoneyCalculatorPresenter();
        MoneyCalculatorView view = new MoneyCalculatorView(presenter);
        view.setVisible(true);
    }
}
