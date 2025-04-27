package com.prueba2.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {
    AuthService authService = new AuthService();

    @Test
    void testLoginCorrecto() {
        assertTrue(authService.autenticar("juanperez", "1234"));
    }

    @Test
    void testLoginIncorrecto() {
        assertFalse(authService.autenticar("juanperez", "12345"));
    }

    @Test
    void testLoginVacio() {
        assertFalse(authService.autenticar("", ""));
    }
}