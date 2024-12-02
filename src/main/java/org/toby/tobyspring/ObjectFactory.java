package org.toby.tobyspring;

public class ObjectFactory {

    public PaymentService paymentService(String type) {
        return new PaymentService(exRateProvider(type));
    }

    public ExRateProvider exRateProvider(String type) {
        if(type.equals("simple")) return new SimpleExRatePaymentService();
        else if(type.equals("api")) return new WebApiExRateProvider();
        else throw new IllegalArgumentException("지원되지 않는 타입입니다.");

    }


}
