package com.aks.commons.jpa.auditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Configuration
public class AuditorAwareConfiguration {

    @Bean
    AuditorAware<String> auditorAware() {
        return new CustomAuditorAware();
    }

}
