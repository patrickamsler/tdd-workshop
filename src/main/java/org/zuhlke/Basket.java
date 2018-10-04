package org.zuhlke;

import java.util.*;

public class Basket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean containsProduct(Product product) {
        return products.contains(product);
    }

    public String printReceipt() {
        double sum = products.stream().mapToDouble(Product::getPrice).sum();
        Map<Product, Integer> productMap = new HashMap<>();
        for (Product product : products) {
            if (!productMap.containsKey(product)) {
                productMap.put(product, 1);
            }
            else {
                productMap.put(product, productMap.get(product) + 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Product product : products) {
            if (!productMap.containsKey(product)) {
                continue;
            }
            int multiple = productMap.get(product);
            double total = multiple * product.getPrice();
            if (multiple == 1) {
                sb.append(product.getDescription() + ": " + String.format("%.0f", total) + "\n");
            }
            else {
                sb.append(multiple + " " + product.getDescription() + ": " + String.format("%.0f", total) + "\n");
            }
            productMap.remove(product);
        }
        sb.append("Total: " + String.format("%.0f", sum));
        return sb.toString();
    }
}
