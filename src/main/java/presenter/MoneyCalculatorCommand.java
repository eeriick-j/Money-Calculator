package presenter;

import model.Currency;

public class MoneyCalculatorCommand implements Command {
    MoneyCalculatorPresenter presenter;
    String amountText;
    Currency from;
    Currency to;

    public MoneyCalculatorCommand(MoneyCalculatorPresenter presenter,
                                  String amountText,
                                  Currency from,
                                  Currency to) {
        this.presenter = presenter;
        this.amountText = amountText;
        this.from = from;
        this.to = to;
    }

    @Override
    public double execute() {
        return this.presenter.convert(this.amountText, this.from, this.to);
    }
}
