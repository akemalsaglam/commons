package com.aks.commons.aws.mail;

import com.aks.commons.aws.AmazonSDKProperties;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSimpleEmailServiceClientConfiguration {

    private static final Regions CLIENT_REGION = Regions.EU_CENTRAL_1;

    private final AmazonSDKProperties amazonSDKProperties;

    public AmazonSimpleEmailServiceClientConfiguration(AmazonSDKProperties amazonSDKProperties) {
        this.amazonSDKProperties = amazonSDKProperties;
    }

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailServiceClient() {
        AWSCredentials credentials = new BasicAWSCredentials(amazonSDKProperties.getAccessKeyId(),
                amazonSDKProperties.getSecretAccessKey());
        return AmazonSimpleEmailServiceClientBuilder
                .standard()
                .withRegion(CLIENT_REGION)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

}
