package br.com.infnet;

import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .start(7000);

        app.get("/", ctx -> ctx.result("DevCalc API está no ar!"));

        System.out.println("Servidor iniciado na porta 7000...");
    }
}
