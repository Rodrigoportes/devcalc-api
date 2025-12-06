package com.devcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
    }

    @Test
    void testAdd() {
        // Teste: 10 + 5 = 15
        assertEquals(15.0, service.add(10.0, 5.0), "A adição de 10 e 5 deve ser 15.");
        // Teste com números negativos
        assertEquals(5.0, service.add(10.0, -5.0), "A adição de 10 e -5 deve ser 5.");
    }

    @Test
    void testSubtract() {
        // Teste: 10 - 5 = 5
        assertEquals(5.0, service.subtract(10.0, 5.0), "A subtração de 10 por 5 deve ser 5.");
        // Teste com resultado negativo
        assertEquals(-5.0, service.subtract(5.0, 10.0), "A subtração de 5 por 10 deve ser -5.");
    }

    @Test
    void testMultiply() {
        // Teste: 10 * 5 = 50
        assertEquals(50.0, service.multiply(10.0, 5.0), "A multiplicação de 10 por 5 deve ser 50.");
        // Teste com zero
        assertEquals(0.0, service.multiply(10.0, 0.0), "A multiplicação por zero deve ser 0.");
    }

    @Test
    void testDivide() {
        // Teste: 10 / 5 = 2
        assertEquals(2.0, service.divide(10.0, 5.0), "A divisão de 10 por 5 deve ser 2.");
        // Teste com resultado decimal
        assertEquals(2.5, service.divide(5.0, 2.0), "A divisão de 5 por 2 deve ser 2.5.");
    }

    @Test
    void testDivideByZero() {
        // Teste: Garante que lança exceção em divisão por zero
        assertThrows(IllegalArgumentException.class, () -> {
            service.divide(10.0, 0.0);
        }, "Deve lançar IllegalArgumentException ao tentar dividir por zero.");
    }
}