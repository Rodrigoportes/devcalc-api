package com.devcalc;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Application {

    private static final CalculatorService calculatorService = new CalculatorService();
    private static final int PORT = 7000;

    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .start(PORT);

        // Define os endpoints da calculadora
        app.get("/add", Application::add);
        app.get("/subtract", Application::subtract);
        app.get("/multiply", Application::multiply);
        app.get("/divide", Application::divide);

        System.out.println("DevCalc API iniciada na porta " + PORT);
    }

    // Helper para extrair e validar os parâmetros
    private static double getParam(Context ctx, String paramName) {
        return ctx.queryParamAsClass(paramName, Double.class)
                .check(it -> !it.isNaN(), "O parâmetro " + paramName + " deve ser um número válido.")
                .get();
    }

    // Handlers dos Endpoints

    private static void add(Context ctx) {
        double a = getParam(ctx, "a");
        double b = getParam(ctx, "b");
        double result = calculatorService.add(a, b);
        ctx.result(String.valueOf(result));
    }

    private static void subtract(Context ctx) {
        double a = getParam(ctx, "a");
        double b = getParam(ctx, "b");
        double result = calculatorService.subtract(a, b);
        ctx.result(String.valueOf(result));
    }

    private static void multiply(Context ctx) {
        double a = getParam(ctx, "a");
        double b = getParam(ctx, "b");
        double result = calculatorService.multiply(a, b);
        ctx.result(String.valueOf(result));
    }

    private static void divide(Context ctx) {
        try {
            double a = getParam(ctx, "a");
            double b = getParam(ctx, "b");
            double result = calculatorService.divide(a, b);
            ctx.result(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            ctx.status(400).result(e.getMessage()); // Retorna Bad Request em caso de divisão por zero
        }
    }
}