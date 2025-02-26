package src;
import java.util.*;
import java.util.concurrent.*;

public class OrderManager {
    private List<Order> orders = Collections.synchronizedList(new ArrayList<>());
    private Map<UUID, Product> inventory;
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public OrderManager(Map<UUID, Product> inventory) {
        this.inventory = inventory;
    }

    public synchronized void placeOrder(String customerName, UUID productId, int quantity) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (product.getStockLevel() >= quantity) {
            product.reduceStock(quantity);
            Order order = new Order(customerName, productId, quantity);
            orders.add(order);
            System.out.println("Order placed: " + order);

            executorService.submit(() -> processOrder(order));
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    private void processOrder(Order order) {
        try {
            Thread.sleep(3000); // Simulate processing time
            order.setOrderStatus(OrderStatus.SHIPPED);
            System.out.println("Order shipped: " + order);

            Thread.sleep(3000);
            order.setOrderStatus(OrderStatus.DELIVERED);
            System.out.println("Order delivered: " + order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
