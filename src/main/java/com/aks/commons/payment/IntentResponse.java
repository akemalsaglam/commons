package com.aks.commons.payment;

import com.aks.commons.controller.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class IntentResponse extends BaseResponse {
    String id;
    String clientSecret;
    Long amount;
    String currency;
    String status;
    String orderId;
}
