package com.devcalc;

public class CalculatorService {

    /**
     * Realiza a operação de adição.
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O resultado da adição.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Realiza a operação de subtração.
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O resultado da subtração.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Realiza a operação de multiplicação.
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O resultado da multiplicação.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Realiza a operação de divisão.
     * @param a O numerador.
     * @param b O denominador.
     * @return O resultado da divisão.
     * @throws IllegalArgumentException Se o denominador for zero.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}
