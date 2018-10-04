package org.zuhlke;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BasketTest {

    @Test
    public void addProduct() {
        //given
        Basket basket = new Basket();
        Product product = new Product("123", 0.00, "");
        //when
        basket.addProduct(product);
        //then
        assertTrue(basket.containsProduct(product));
    }

    @Test
    public void printReceiptForSingleProduct() {
        //given
        Basket basket = new Basket();
        Product product = new Product("123", 20.00, "Wine");
        //when
        basket.addProduct(product);
        //then

        assertEquals("Wine: 20\nTotal: 20", basket.printReceipt());
    }

    @Test
    public void printReceiptForMultipleProducts() {
        //given
        Basket basket = new Basket();
        Product wine = new Product("1", 20.00, "Wine");
        Product bread = new Product("2", 2, "Bread");

        //when
        basket.addProduct(wine);
        basket.addProduct(bread);
        //then

        assertEquals("Wine: 20\nBread: 2\nTotal: 22", basket.printReceipt());
    }
}
