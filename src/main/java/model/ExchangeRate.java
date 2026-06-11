package model;

public record ExchangeRate(Currency from, Currency to, double rate) {
    public double convert(double amount){
        return amount * rate;
    }
}
