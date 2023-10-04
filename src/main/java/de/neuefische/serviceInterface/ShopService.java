package de.neuefische.serviceInterface;
import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.model.ProductOrder;
import de.neuefische.Repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order addOrder(List<String> productIds) {
        List<ProductOrder> productOrders = new ArrayList<>();

        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId);
            if (productToOrder == null) {
                System.out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                return null;
            }
            productOrders.add(new ProductOrder(productToOrder, 1));  // hier wird für jedes Produkt eine Menge von 1 angenommen
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), productOrders);

        return orderRepo.addOrder(newOrder);
    }
}
