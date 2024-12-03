package org.toby.tobyspring.payment;

import org.junit.jupiter.api.Test;
import org.toby.tobyspring.exrate.WebApiExRateProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    // 제어할 수 없는 외부시스템 문제
    // ExRateProvider 가 제공하는 환율 값으로 계산?
    // 환율 유효시간 계산 정확도?

    @Test
    void prepare() throws IOException {
        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());

        Payment usd = paymentService.prepare(1L, "USD", BigDecimal.valueOf(100));

        assertThat(usd.getCurrency()).isNotNull();
        assertThat(usd.getConvertedAmount()).isEqualTo(usd.getExRate().multiply(usd.getForeignCurrencyAmount()));
        assertThat(usd.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(usd.getValidUntil()).isBefore(LocalDateTime.now().plusHours(1));
    }


}