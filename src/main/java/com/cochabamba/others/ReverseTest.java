package com.cochabamba.others;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author aralco
 */
public class ReverseTest {

    @Test
    public void testReverseNumber() throws Exception {
        Assert.assertEquals(25431, Reverse.reverseNumber(13452));
        Assert.assertEquals(3237289, Reverse.reverseNumber(9827323));
    }

    @Test
    public void testReverseString() throws Exception {
        Assert.assertEquals("sanozama", Reverse.reverseString("amazonas"));
        Assert.assertEquals("emadam", Reverse.reverseString("madame"));
        Assert.assertEquals("aisenilop", Reverse.reverseString("polinesia"));
    }
}