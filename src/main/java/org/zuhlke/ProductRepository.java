package org.zuhlke;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
    }

    public void insertProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product queryProduct(String id) {
        return products.stream().filter(Product -> Product.getProductId().equals(id)).findFirst().get();
    }
}
