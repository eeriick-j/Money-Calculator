package view.dialog;

import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CurrencyDialog extends JPanel {
    private final JComboBox<Currency> fromBox = new JComboBox<>();
    private final JComboBox<Currency> toBox = new JComboBox<>();

    public CurrencyDialog(List<Currency> currencies) {
        setLayout(new FlowLayout());

        for (Currency c : currencies) {
            fromBox.addItem(c);
            toBox.addItem(c);
        }

        add(new JLabel("From:"));
        add(fromBox);
        add(new JLabel("To:"));
        add(toBox);
    }

    public Currency getFrom() { return (Currency) fromBox.getSelectedItem(); }
    public Currency getTo() { return (Currency) toBox.getSelectedItem(); }
}