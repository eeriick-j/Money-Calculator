package view;

import presenter.MoneyCalculatorPresenter;
import model.Currency;
import view.dialog.CurrencyDialog;
import view.dialog.MoneyDialog;
import view.display.ResultDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MoneyCalculatorView extends JFrame {

    public MoneyCalculatorView(MoneyCalculatorPresenter presenter) {
        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 320);
        setLocationRelativeTo(null);

        List<Currency> currencies = presenter.getCurrencies();
        CurrencyDialog selector = new CurrencyDialog(currencies);
        MoneyDialog input = new MoneyDialog();

        ResultDisplay display = new ResultDisplay();
        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(e -> {
            String amountText = input.getAmount();
            if (amountText == null || amountText.isBlank()) {
                display.setResult("Enter an amount", "");
                return;
            }

            double conversion = presenter.convert(amountText, selector.getFrom(), selector.getTo());

            try {
                display.setResult(
                        String.valueOf(conversion),
                        String.valueOf(selector.getTo().code())
                );
            } catch (NumberFormatException ex) {
                display.setResult("Invalid amount format", "");
            } catch (Exception ex) {
                display.setResult("Verify amount", "");
            }
        });

        JPanel panel = buildPanel(selector, input, convertButton, display);
        add(panel);
    }

    private JPanel buildPanel(
            CurrencyDialog selector,
            MoneyDialog input,
            JButton button,
            ResultDisplay display
    ) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        addRow(panel, selector);
        addRow(panel, input);
        addRow(panel, button);
        addRow(panel, display);
        return panel;
    }

    private void addRow(JPanel parent, JComponent component) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row.add(component);
        parent.add(row);
    }
}