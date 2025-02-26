package src;

import java.util.*;

public class InventorySystem {
    public static void main(String[] args) {
        // إنشاء المنتجات
        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);

        // تخزين المنتجات في المخزون
        Map<UUID, Product> inventory = new HashMap<>();
        inventory.put(laptop.getProductId(), laptop);
        inventory.put(smartphone.getProductId(), smartphone);

        // إنشاء مدير الطلبات
        OrderManager orderManager = new OrderManager(inventory);

        // طباعة المخزون
        System.out.println(laptop);
        System.out.println(smartphone);

        // توقع نفاد المخزون
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter average daily sales for Laptop: ");
        int laptopSales = scanner.nextInt();
        System.out.print("Enter average daily sales for Smartphone: ");
        int smartphoneSales = scanner.nextInt();

        System.out.println("\nStock Prediction for Laptop:");
        System.out.println("Days until stock out: " + StockPredictor.predictDaysUntilStockOut(laptop, laptopSales));
        System.out.println("Restock Suggestion: " + StockPredictor.getRestockSuggestion(laptop, laptopSales));

        System.out.println("\nStock Prediction for Smartphone:");
        System.out.println("Days until stock out: " + StockPredictor.predictDaysUntilStockOut(smartphone, smartphoneSales));
        System.out.println("Restock Suggestion: " + StockPredictor.getRestockSuggestion(smartphone, smartphoneSales));

        // إنشاء طلبات شراء
        orderManager.placeOrder("John Doe", laptop.getProductId(), 3);
        orderManager.placeOrder("Jane Smith", smartphone.getProductId(), 2);

        // انتظار إنهاء العمليات
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
