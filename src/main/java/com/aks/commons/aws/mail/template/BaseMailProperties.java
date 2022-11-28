package com.aks.commons.aws.mail.template;

import lombok.Data;

@Data
public class BaseMailProperties {
    private String fromEmail;
    private String subject;
}
