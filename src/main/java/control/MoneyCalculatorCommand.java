package control;

import model.Currency;

public class MoneyCalculatorCommand implements Command {
    MoneyCalculatorController controller;
    String amountText;
    Currency from;
    Currency to;

    public MoneyCalculatorCommand(MoneyCalculatorController controller,
                                  String amountText,
                                  Currency from,
                                  Currency to) {
        this.controller = controller;
        this.amountText = amountText;
        this.from = from;
        this.to = to;
    }

    @Override
    public double execute() {
        return this.controller.convert(this.amountText, this.from, this.to);
    }
}
