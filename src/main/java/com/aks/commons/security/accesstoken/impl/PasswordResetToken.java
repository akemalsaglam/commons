package com.aks.commons.security.accesstoken.impl;

public class PasswordResetToken extends BaseToken {
    public static final long TOKEN_VALIDITY_SECONDS = 2 * 60 * 60; //2 HOURS

    public PasswordResetToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
