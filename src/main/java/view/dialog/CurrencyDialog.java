package view.dialog;

import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CurrencyDialog extends JPanel {
    private final JComboBox<Currency> fromBox = new JComboBox<>();
    private final JComboBox<Currency> toBox = new JComboBox<>();

    public CurrencyDialog(List<Currency> currencies) {
        for (Currency c : currencies) {
            fromBox.addItem(c);
            toBox.addItem(c);
        }

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,25,5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("From:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(fromBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("To:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(toBox, gbc);
    }
    public Currency getFrom() { return (Currency) fromBox.getSelectedItem(); }
    public Currency getTo() { return (Currency) toBox.getSelectedItem(); }
}