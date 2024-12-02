package org.toby.tobyspring;



import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRatePaymentService implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency)  throws IOException  {
        if(currency.equals("USD")) return new BigDecimal("1000");

        throw new IllegalArgumentException("지원되지 않는 통화입니다.");
    }
}
