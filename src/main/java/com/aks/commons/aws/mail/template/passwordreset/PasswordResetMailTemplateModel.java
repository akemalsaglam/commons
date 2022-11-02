package com.aks.commons.aws.mail.template.passwordreset;

import com.aks.commons.aws.mail.template.BaseMailTemplateModel;
import lombok.Builder;

@Builder
public class PasswordResetMailTemplateModel extends BaseMailTemplateModel {

    public String passwordResetRedirectUrl;
}
