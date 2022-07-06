package com.aks.commons.aws.mail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailProperties {

    private final String toEmail;
    private final String fromEmail;
    private final String mailSubject;
    private final String htmlMailBody;
}
