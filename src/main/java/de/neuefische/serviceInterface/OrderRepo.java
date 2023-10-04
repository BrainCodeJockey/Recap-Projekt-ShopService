package de.neuefische.serviceInterface;
import de.neuefische.model.Order;
import java.util.List;

public interface OrderRepo {
    List<Order> getOrders();
    Order getOrderById(String id);
    Order addOrder(Order newOrder);
    void removeOrder(String id);
}
