package app;

import control.MoneyCalculatorController;
import view.MoneyCalculatorView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MoneyCalculatorController controller = new MoneyCalculatorController();
        MoneyCalculatorView view = new MoneyCalculatorView(controller);
        view.setVisible(true);
    }
}
