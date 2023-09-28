package com.aks.commons.aws.sms;

import com.aks.commons.aws.AmazonSDKProperties;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSMSClientConfiguration {

  private static final Regions CLIENT_REGION = Regions.EU_CENTRAL_1;

  private final AmazonSDKProperties amazonSDKProperties;

  public AmazonSMSClientConfiguration(AmazonSDKProperties amazonSDKProperties) {
    this.amazonSDKProperties = amazonSDKProperties;
  }

  @Bean
  public AmazonSNS amazonSMSClient() {
    return AmazonSNSClient.builder().withRegion(CLIENT_REGION).build();
  }

}
