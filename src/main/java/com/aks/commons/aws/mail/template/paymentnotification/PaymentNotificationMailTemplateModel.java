package com.aks.commons.aws.mail.template.paymentnotification;

import com.aks.commons.aws.mail.template.BaseMailTemplateModel;
import lombok.Builder;

@Builder
public class PaymentNotificationMailTemplateModel extends BaseMailTemplateModel {

    public String invitationUrl;
    public String host1Name;
    public String host2Name;
}
