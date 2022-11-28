package com.aks.commons.aws.mail.template.register;

import com.aks.commons.aws.mail.template.BaseMailProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.register")
public class RegisterMailProperties extends BaseMailProperties {
    private String redirectionUrl;
}
