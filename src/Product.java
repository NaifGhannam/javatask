package src;



import java.util.UUID;

public class Product {
    private UUID productId;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    public Product(String name, double price, int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void reduceStock(int quantity) {
        if (quantity > 0 && stockLevel >= quantity) {
            stockLevel -= quantity;
        }
    }

    public void restock(int quantity) {
        if (quantity > 0) {
            stockLevel += quantity;
        }
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                "\nName: " + name +
                "\nPrice: $" + price +
                "\nStock Level: " + stockLevel +
                "\nReorder Threshold: " + reorderThreshold + "\n";
    }
}
