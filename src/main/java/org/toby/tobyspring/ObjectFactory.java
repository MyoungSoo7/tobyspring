package org.toby.tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toby.tobyspring.exrate.CachedExRateProvider;
import org.toby.tobyspring.payment.ExRateProvider;
import org.toby.tobyspring.payment.PaymentService;
import org.toby.tobyspring.exrate.WebApiExRateProvider;

@Configuration
public class ObjectFactory {


    @Bean
    public PaymentService paymentService() {
        return new PaymentService(CachedExRateProvider());
    }

    @Bean
    public ExRateProvider CachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        // DI를 통해 WebApiExRateProvider를 사용하도록 변경
        return new WebApiExRateProvider();
    }

}
