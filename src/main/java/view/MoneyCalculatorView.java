package view;

import control.MoneyCalculatorController;
import model.Currency;
import view.dialog.CurrencyDialog;
import view.dialog.MoneyDialog;
import view.display.ResultDisplay;

import javax.swing.*;
import java.util.List;

public class MoneyCalculatorView extends JFrame {

    public MoneyCalculatorView(MoneyCalculatorController controller) {
        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        List<Currency> currencies = controller.getCurrencies();
        CurrencyDialog selector = new CurrencyDialog(currencies);
        MoneyDialog input = new MoneyDialog();
        ResultDisplay display = new ResultDisplay();
        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(e ->
                onConvert(controller, input, selector, display)
        );

        JPanel panel = buildPanel(selector, input, convertButton, display);
        add(panel);
    }

    private void onConvert(
            MoneyCalculatorController controller,
            MoneyDialog input,
            CurrencyDialog selector,
            ResultDisplay display
    ) {
        try {
            double conversion = controller.convert(
                    input.getAmount(),
                    selector.getFrom(),
                    selector.getTo());

            display.setResult(String.valueOf(conversion));
        }
        catch (Exception e) {
            display.setResult("Error en la conversión");
        }
    }

    private JPanel buildPanel(
            CurrencyDialog selector,
            MoneyDialog input,
            JButton button,
            ResultDisplay display
    ) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(selector);
        panel.add(input);
        panel.add(button);
        panel.add(display);
        return panel;
    }
}