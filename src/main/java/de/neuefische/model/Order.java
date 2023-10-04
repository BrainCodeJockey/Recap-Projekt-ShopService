package de.neuefische.model;

import java.util.List;

public record Order(
        String id,
        List<ProductOrder> products
) {
    public double getTotalPrice() {  // <-- HINZUGEFÜGT
        return products.stream()
                .mapToDouble(productOrder -> productOrder.getProduct().price() * productOrder.getQuantity())
                .sum();
    }
}
