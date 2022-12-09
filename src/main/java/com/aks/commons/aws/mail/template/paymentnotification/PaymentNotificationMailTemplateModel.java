package com.aks.commons.aws.mail.template.paymentnotification;

import com.aks.commons.aws.mail.template.BaseMailTemplateModel;
import lombok.Builder;

@Builder
public class PaymentNotificationMailTemplateModel extends BaseMailTemplateModel {

    private String invitationUrl;
    private String host1Name;
    private String host2Name;
}
