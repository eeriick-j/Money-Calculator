package view.display;

import javax.swing.*;

public class ResultDisplay extends JPanel {
    private final JLabel resultLabel = new JLabel();

    public ResultDisplay() {
        add(resultLabel);
    }

    public void setResult(String text, String to) {
        resultLabel.setText(text + " " + to);
    }
}
