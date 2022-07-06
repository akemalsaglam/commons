package com.aks.commons.aws.mail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.sdk")
public class AmazonSDKProperties {

    private String accessKeyId;
    private String secretAccessKey;
    private String s3BucketName;

}
