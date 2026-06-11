package view.dialog;

import javax.swing.*;
import java.awt.*;

public class MoneyDialog extends JPanel {
    private final JTextField amountField = new JTextField(10);

    public MoneyDialog() {
        setLayout(new FlowLayout());
        add(new JLabel("Amount:"));
        add(amountField);
    }

    public String getAmount() {
        return amountField.getText();
    }
}
