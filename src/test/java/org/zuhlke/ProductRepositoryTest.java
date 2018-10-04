package org.zuhlke;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryTest {
    @Test
    public void queryProductRepository() {
        //given
        ProductRepository pr = new ProductRepository();
        pr.insertProduct(new Product("1", 20.00, "Wine"));
        //when then
        assertEquals("1", pr.queryProduct("1").getProductId());
    }

    @Test(expected = NoSuchElementException.class)
    public void queryMissingProductRepository() {
        //given
        ProductRepository pr = new ProductRepository();
        pr.insertProduct(new Product("1", 20.00, "Wine"));
        //when then
        pr.queryProduct("2");
    }
}
