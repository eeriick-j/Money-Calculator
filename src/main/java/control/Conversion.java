package control;

public record Conversion(boolean success, double value, String error) {

    public static Conversion ok(double value) {
        return new Conversion(true, value, null);
    }

    public static Conversion error(String message) {
        return new Conversion(false, 0, message);
    }
}