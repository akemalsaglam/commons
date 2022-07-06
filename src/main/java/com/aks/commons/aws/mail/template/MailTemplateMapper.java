package com.aks.commons.aws.mail.template;

import java.util.Map;

public interface MailTemplateMapper {

    String map(Map<String, Object> templateModel);
}
