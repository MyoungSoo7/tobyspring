package org.toby.tobyspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {

        BeanFactory objectFactory =  new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = objectFactory.getBean(PaymentService.class);

        Payment payment = paymentService.prepare(100L, "USD", new BigDecimal("50.7"));
        System.out.println(payment);
    }
}
