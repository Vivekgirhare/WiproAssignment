package com.example.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    @Test
    public void testValidLogin() {
        assertTrue(Loginvalidator.validate("admin", "password123"));
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(Loginvalidator.validate("admin", "wrongpass"));
        assertFalse(Loginvalidator.validate("user", "password123"));
    }

    @Test
    public void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Loginvalidator.validate("", "password123");
        });
        assertEquals("Username or password cannot be empty", exception.getMessage());
    }

    @Test
    public void testEmptyPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Loginvalidator.validate("admin", "");
        });
        assertEquals("Username or password cannot be empty", exception.getMessage());
    }

    @Test
    public void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Loginvalidator.validate(null, "password123");
        });
        assertEquals("Username or password cannot be null", exception.getMessage());
    }

    @Test
    public void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Loginvalidator.validate("admin", null);
        });
        assertEquals("Username or password cannot be null", exception.getMessage());
    }
}