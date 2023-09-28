package com.aks.commons.aws.sms;

import com.aks.commons.aws.sms.sender.SMSSender;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ObjectUtils;

public class AmazonSMSSender implements SMSSender {

  public static final String CHAR_SET_UTF_8 = "UTF-8";
  private static final String SENDER_ID = "Davetino";
  private static final String SMS_TYPE = "Transactional";
  private final Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
  private final AmazonSNS amazonSMSClient;

  public AmazonSMSSender(AmazonSNS amazonSMSClient) {
    this.amazonSMSClient = amazonSMSClient;
    smsAttributes.put("AWS.SNS.SMS.SenderID",
        new MessageAttributeValue().withStringValue(SENDER_ID).withDataType("String"));
    smsAttributes.put("AWS.SNS.SMS.SMSType",
        new MessageAttributeValue().withStringValue(SMS_TYPE).withDataType("String"));
  }

  public PublishResult sendSms(SMSProperties smsProperties) {
    try {
      if (ObjectUtils.isEmpty(smsProperties.getPhoneNumber()) || ObjectUtils.isEmpty(smsProperties.getMessage())) {
        throw new Exception("phoneNumber and message are required.");
      }
      return this.amazonSMSClient.publish(createPublishRequest(smsProperties));
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  private PublishRequest createPublishRequest(SMSProperties smsProperties) {
    return new PublishRequest()
        .withSubject(smsProperties.getSubject())
        .withMessage(smsProperties.getMessage())
        .withPhoneNumber(smsProperties.getPhoneNumber())
        .withMessageAttributes(smsAttributes);
  }
}

