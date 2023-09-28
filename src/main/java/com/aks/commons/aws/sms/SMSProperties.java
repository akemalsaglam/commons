package com.aks.commons.aws.sms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SMSProperties {

    private final String message;
    private final String phoneNumber;
}
