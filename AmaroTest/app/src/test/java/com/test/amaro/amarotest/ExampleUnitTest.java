package com.test.amaro.amarotest;

import com.test.amaro.amarotest.entity.Product;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /**
     * Adding a simple unit test as example. This one we check if conversion from
     * actual price string to float is ok`- its not useful because on this case, our get as float
     * only performs a single operation.
     *
     * Ideally, we would create unit tests to check for Payload information, to test more complex methods
     * and all of that to guarantee that our code is performing as expected.
     *
     * With that, we could also have better maintenance - every change done on code, we would have
     * unit tests to assert that they did not broke any important business rule and etc.
     */
    @Test
    public void priceConversionToFloat_isCorrect() throws Exception {
        Product product = new Product();
        product.setActual_price("R$ 199,00");
        assertEquals(199f, product.actualPriceAsFloat(), 0);
    }
}