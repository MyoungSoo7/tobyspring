package org.toby.tobyspring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


abstract public class PaymentService {

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusHours(1);
        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    abstract BigDecimal getExRate(String currency) throws IOException;

}
