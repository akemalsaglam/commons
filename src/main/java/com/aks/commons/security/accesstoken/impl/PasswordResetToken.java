package com.aks.commons.security.accesstoken.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetToken extends BaseToken {
    public static final long TOKEN_VALIDITY_SECONDS = 24 * 60 * 60; //24 HOURS

    @Autowired
    public PasswordResetToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
