package com.example.assignment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testDivideValidInput() {
        assertEquals(2, Calculator.divide(10, 5));
        assertEquals(-2, Calculator.divide(-10, 5));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
