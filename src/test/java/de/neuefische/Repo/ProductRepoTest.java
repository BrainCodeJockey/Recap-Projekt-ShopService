package de.neuefische.Repo;

import de.neuefische.model.Product;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @org.junit.jupiter.api.Test
    void whenRepoIsInitialized_thenProductsAreSetCorrectly() {
        //GIVEN
        ProductRepo repo = new ProductRepo(List.of(new Product("1", "Apfel", 0.50)));

        //WHEN
        List<Product> actual = repo.getProducts();

        //THEN
        assertEquals(List.of(new Product("1", "Apfel", 0.50)), actual);
    }

    @org.junit.jupiter.api.Test
    void whenGetProductById1_thenReturnApfel() {
        //GIVEN
        ProductRepo repo = new ProductRepo(List.of(new Product("1", "Apfel", 0.50)));

        //WHEN
        Product actual = repo.getProductById("1");

        //THEN
        assertEquals(new Product("1", "Apfel", 0.50), actual);
    }

    @org.junit.jupiter.api.Test
    void whenAddBanane_thenRepoContainsBanane() {
        //GIVEN
        ProductRepo repo = new ProductRepo(List.of(new Product("1", "Apfel", 0.50)));
        Product newProduct = new Product("2", "Banane", 0.40);

        //WHEN
        Product actual = repo.addProduct(newProduct);

        //THEN
        assertEquals(new Product("2", "Banane", 0.40), actual);
        assertEquals(new Product("2", "Banane", 0.40), repo.getProductById("2"));
    }

    @org.junit.jupiter.api.Test
    void whenRemoveApfel_thenApfelIsNotFoundInRepo() {
        //GIVEN
        ProductRepo repo = new ProductRepo(List.of(new Product("1", "Apfel", 0.50)));

        //WHEN
        repo.removeProduct("1");

        //THEN
        assertNull(repo.getProductById("1"));
    }
}
