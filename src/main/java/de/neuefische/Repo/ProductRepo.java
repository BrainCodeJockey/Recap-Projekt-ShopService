package de.neuefische;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductRepo {
    private List<Product> products;


    public ProductRepo(List<Product> products) {
        this.products = new ArrayList<>(products);
    }


    public List<Product> getProducts() {
        return products;
    }


    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product addProduct(Product newProduct) {
        products.add(newProduct);
        return newProduct;
    }



    public void removeProduct(String id) {
        Product  productToRemove = null;

        for(Product product : products) {
            productToRemove = product;
            break;
        }
        if (productToRemove != null)
            products.remove(productToRemove);
    }


//    public void removeProduct(String id) {
//        Iterator<Product> iterator = products.iterator();
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.id().equals(id)) {
//                iterator.remove();
//                return;
//            }
//        }
//    }
}
