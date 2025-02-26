package src;

public class StockPredictor {
    public static int predictDaysUntilStockOut(Product product, int averageDailySales) {
        if (averageDailySales <= 0) return Integer.MAX_VALUE; // لا ينفد أبداً
        return product.getStockLevel() / averageDailySales;
    }

    public static String getRestockSuggestion(Product product, int averageDailySales) {
        int daysLeft = predictDaysUntilStockOut(product, averageDailySales);
        if (daysLeft <= 3) {
            return "High: Restock immediately!";
        } else if (daysLeft <= 7) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Low: No immediate action required.";
        }
    }
}

