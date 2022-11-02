package com.aks.commons.aws.s3;

import com.aks.commons.aws.AmazonSDKProperties;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3ClientConfiguration {

    private static final Regions clientRegion = Regions.EU_CENTRAL_1;

    private final AmazonSDKProperties amazonSDKProperties;

    public AmazonS3ClientConfiguration(AmazonSDKProperties amazonSDKProperties) {
        this.amazonSDKProperties = amazonSDKProperties;
    }

    @Bean
    public AmazonS3 s3Client() {
        AWSCredentials credentials =
                new BasicAWSCredentials(
                        amazonSDKProperties.getAccessKeyId(),
                        amazonSDKProperties.getSecretAccessKey());
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(clientRegion)
                .build();
    }
}
