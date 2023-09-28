package com.aks.commons.aws.sms;

import com.amazonaws.services.sns.model.PublishResult;

public interface SMSSender {

    PublishResult sendSms(SMSProperties smsProperties) throws Exception;
}
