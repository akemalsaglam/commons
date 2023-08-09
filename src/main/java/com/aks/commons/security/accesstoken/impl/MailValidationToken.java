package com.aks.commons.security.accesstoken.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailValidationToken extends BaseToken {

    public static final long TOKEN_VALIDITY_SECONDS = 7 * 24 * 60 * 60; //7 DAY

    @Autowired
    public MailValidationToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
