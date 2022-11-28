package com.aks.commons.aws.mail.template.passwordreset;

import com.aks.commons.aws.mail.template.BaseMailProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.reset.password")
public class ResetPasswordMailProperties extends BaseMailProperties {
    private String redirectionUrl;
}
