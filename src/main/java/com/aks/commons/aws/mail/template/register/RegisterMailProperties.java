package com.aks.commons.aws.mail.template.register;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.register")
public class RegisterMailProperties {

    private String redirectionUrl;
    private String fromEmail;
    private String subject;
}
