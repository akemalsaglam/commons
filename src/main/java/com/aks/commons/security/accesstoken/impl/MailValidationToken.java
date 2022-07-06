package com.aks.commons.security.accesstoken.impl;

public class MailValidationToken extends BaseToken {

    public static final long TOKEN_VALIDITY_SECONDS = 1 * 24 * 60 * 60; //1 DAY

    public MailValidationToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
