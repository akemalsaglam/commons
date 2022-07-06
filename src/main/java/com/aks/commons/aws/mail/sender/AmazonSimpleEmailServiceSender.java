package com.aks.commons.aws.mail.sender;

import com.aks.commons.aws.mail.MailProperties;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.util.ObjectUtils;

public class AmazonSimpleEmailServiceSender implements MailSender {

    public static final String CHAR_SET_UTF_8 = "UTF-8";
    private final AmazonSimpleEmailService amazonSimpleEmailServiceClient;

    public AmazonSimpleEmailServiceSender(AmazonSimpleEmailService amazonSimpleEmailServiceClient) {
        this.amazonSimpleEmailServiceClient = amazonSimpleEmailServiceClient;
    }

    public void sendMail(MailProperties mailProperties) {
        try {
            if (ObjectUtils.isEmpty(mailProperties.getFromEmail()) || ObjectUtils.isEmpty(mailProperties.getToEmail())) {
                throw new Exception("fromEmail and toEmail is required.");
            }
            SendEmailRequest request = createSendEmailRequest(mailProperties);
            this.amazonSimpleEmailServiceClient.sendEmail(request);
        } catch (Exception ex) {
            new RuntimeException(ex);
        }
    }

    private SendEmailRequest createSendEmailRequest(MailProperties mailProperties) {
        return new SendEmailRequest()
                .withSource(mailProperties.getFromEmail())
                .withDestination(new Destination().withToAddresses(mailProperties.getToEmail()))
                .withMessage(
                        new Message()
                                .withBody(getHtmlBody(mailProperties))
                                .withSubject(getSubject(mailProperties)));
    }

    private Body getHtmlBody(MailProperties mailProperties) {
        return new Body().withHtml(new Content().withData(mailProperties.getHtmlMailBody()).withCharset(CHAR_SET_UTF_8));
    }

    private Content getSubject(MailProperties mailProperties) {
        return new Content().withData(mailProperties.getMailSubject()).withCharset(CHAR_SET_UTF_8);
    }
}

