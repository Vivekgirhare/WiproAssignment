package com.example.assignment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void testReverseWithRegularString() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("dlrow olleh", StringUtils.reverse("hello world"));
    }

    @Test
    void testReverseWithEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void testReverseWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.reverse(null);
        });
    }
}