package org.toby.tobyspring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {

        ObjectFactory objectFactory = new ObjectFactory();
        PaymentService paymentService = objectFactory.paymentService("simple");
        Payment payment = paymentService.prepare(100L, "USD", new BigDecimal("50.7"));
        System.out.println(payment);
    }
}
