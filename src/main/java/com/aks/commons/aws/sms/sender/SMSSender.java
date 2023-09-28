package com.aks.commons.aws.sms.sender;

import com.aks.commons.aws.sms.SMSProperties;
import com.amazonaws.services.sns.model.PublishResult;

public interface SMSSender {

    PublishResult sendSms(SMSProperties smsProperties) throws Exception;
}
