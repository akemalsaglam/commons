package com.aks.commons.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Service
public class StripePaymentService {

    @Value("${stripe.api.key}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public IntentResponse createPaymentIntent(BigDecimal amount, String currencyCode, String userEmail)
            throws StripeException {
        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", convertAmountToCents(amount));
        params.put("currency", currencyCode);
        params.put("payment_method_types", paymentMethodTypes);
        params.put("receipt_email", userEmail);
        params.put("customer", userEmail);

        Map<String, String> meta = new HashMap<>();
        meta.put("user_email", userEmail);
        meta.put("order_id", UUID.randomUUID().toString());
        params.put("metadata", meta);
        final PaymentIntent intent = PaymentIntent.create(params);
        return new IntentResponse.IntentResponseBuilder()
                .clientSecret(intent.getClientSecret())
                .id(intent.getId())
                .amount(intent.getAmount())
                .currency(intent.getCurrency())
                .status(intent.getStatus())
                .orderId(intent.getMetadata().get("order_id"))
                .build();
    }

    private static int convertAmountToCents(BigDecimal amount) {
        return amount.movePointRight(2).intValueExact();
    }
}
