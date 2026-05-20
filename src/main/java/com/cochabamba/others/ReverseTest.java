package com.cochabamba.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.cochabamba.others.Reverse.reverseString;
import static com.cochabamba.others.Reverse.reverseNumber;

/**
 * @author aralco
 */
public class ReverseTest {

    @Test
    public void testReverseNumber() throws Exception {
        assertEquals(25431, reverseNumber(13452));
        assertEquals(3237289, reverseNumber(9827323));
    }

    @Test
    public void testReverseString() throws Exception {
        assertEquals("sanozama", reverseString("amazonas"));
        assertEquals("emadam", reverseString("madame"));
        assertEquals("aisenilop", reverseString("polinesia"));
    }
}