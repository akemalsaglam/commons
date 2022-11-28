package com.aks.commons.aws.mail.template.paymentnotification;

import com.aks.commons.aws.mail.template.BaseMailProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.payment.notification")
public class PaymentNotificationMailProperties extends BaseMailProperties {
    private String invitationUrl;
    private String invitationLink;
    private String host1Name;
    private String host2Name;
}
