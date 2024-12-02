package org.toby.tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
