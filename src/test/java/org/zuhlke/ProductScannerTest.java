package org.zuhlke;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ProductScannerTest {
    @Test
    public void printReceiptAfterScanningProducts() {
        //given
        Basket basket = new Basket();
        Product wine = new Product("1", 20.00, "Wine");
        Product bread = new Product("2", 2, "Bread");
        //when
        ProductScanner.scanProduct(basket, wine);
        ProductScanner.scanProduct(basket, bread);
        //then

        assertEquals("Wine: 20\nBread: 2\nTotal: 22", basket.printReceipt());
    }

    @Test
    public void printReceiptAfterScanningTwoOfTheSameProduct() {
        //given
        Basket basket = new Basket();
        Product wine = new Product("1", 20.00, "Wine");
        //when
        ProductScanner.scanProduct(basket, wine);
        ProductScanner.scanProduct(basket, wine);
        //then

        assertEquals("2 Wine: 40\nTotal: 40", basket.printReceipt());
    }

    @Test
    public void printReceiptForWinePromotion() {
        //given
        Basket basket = new Basket();
        Product wine = new Product("1", 20.00, "Wine");

        //when
        ProductScanner.scanProduct(basket, wine);
        ProductScanner.scanProduct(basket, wine);
        //then

        assertEquals("2 Wine: 35\nTotal: 35", basket.printReceipt());
    }
}
