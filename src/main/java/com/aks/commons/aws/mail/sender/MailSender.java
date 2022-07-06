package com.aks.commons.aws.mail.sender;

import com.aks.commons.aws.mail.MailProperties;

public interface MailSender {

    void sendMail(MailProperties mailProperties) throws Exception;
}
