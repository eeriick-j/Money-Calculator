package view;

import control.MoneyCalculatorController;
import io.CurrencyLoader;
import io.ExchangeRateLoader;
import model.Currency;
import model.ExchangeRate;
import view.dialog.CurrencyDialog;
import view.dialog.MoneyDialog;
import view.display.ResultDisplay;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class MoneyCalculatorView extends JFrame {

    public MoneyCalculatorView() throws IOException {
        MoneyCalculatorController controller = new MoneyCalculatorController();

        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        List<Currency> currencies = controller.getCurrencies();
        CurrencyDialog selector = new CurrencyDialog(currencies);
        MoneyDialog input = new MoneyDialog();
        ResultDisplay display = new ResultDisplay();

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> {
            try {
                double conversion = controller.convert(input.getAmount(), selector.getFrom(), selector.getTo());
                display.setResult(String.valueOf(conversion));
            } catch (Exception ex) {
                display.setResult("Error en la conversión");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(selector);
        panel.add(input);
        panel.add(convertButton);
        panel.add(display);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MoneyCalculatorView().setVisible(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}