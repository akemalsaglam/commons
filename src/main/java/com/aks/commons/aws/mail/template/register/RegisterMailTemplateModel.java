package com.aks.commons.aws.mail.template.register;

import com.aks.commons.aws.mail.template.BaseMailTemplateModel;
import lombok.Builder;

@Builder
public class RegisterMailTemplateModel extends BaseMailTemplateModel {

    public String activationRedirectUrl;
}
