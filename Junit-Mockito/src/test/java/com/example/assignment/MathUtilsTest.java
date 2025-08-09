package com.example.assignment;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testFactorialWithValidInput() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(2, MathUtils.factorial(2));
        assertEquals(6, MathUtils.factorial(3));
        assertEquals(120, MathUtils.factorial(5));
    }

    @Test
    void testFactorialWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-1);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-5);
        });
    }
}