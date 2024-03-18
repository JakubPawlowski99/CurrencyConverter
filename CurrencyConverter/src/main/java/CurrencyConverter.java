public class CurrencyConverter {
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return amount * 0.85;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            return amount * 0.72;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return amount * 1.18;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            return amount * 0.85;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            return amount * 1.39;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            return amount * 1.18;
        } else {
            return -1;
        }
    }
}