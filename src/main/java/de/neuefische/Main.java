package de.neuefische;
import de.neuefische.model.Product;
import de.neuefische.Repo.ProductRepo;
import de.neuefische.Repo.OrderListRepo;
import de.neuefische.Repo.OrderMapRepo;
import de.neuefische.serviceInterface.OrderRepo;
import de.neuefische.serviceInterface.ShopService;
import java.util.List;




public class Main {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        List<Product> initialProducts = List.of(
                new Product("1", "Katze", 12.45),
                new Product("2", "Kuh", 50.90),
                new Product("3", "Huhn", 99.99)
        );

        ProductRepo productRepo = new ProductRepo(initialProducts);
        OrderRepo orderListRepo = new OrderListRepo();
        OrderRepo orderMapRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderMapRepo);

        // Produkte testen

        System.out.println("Initial products:");
        productRepo.getProducts().forEach(product -> {
            System.out.println(ANSI_GREEN + "- " + product + ANSI_RESET);
        });

        productRepo.addProduct(new Product("4", "Hund", 1.50));
        System.out.println("\nAfter adding Hund:");
        productRepo.getProducts().forEach(product -> {
            System.out.println("- " + product);
        });

        productRepo.removeProduct("2");
        System.out.println("\nAfter removing Kuh:");
        productRepo.getProducts().forEach(product -> {
            System.out.println("- " + product);
        });
    }
}
