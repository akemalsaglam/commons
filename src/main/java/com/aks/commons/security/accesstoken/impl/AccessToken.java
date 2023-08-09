package com.aks.commons.security.accesstoken.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessToken extends BaseToken {

    public static final long TOKEN_VALIDITY_SECONDS = 30 * 24 * 60 * 60; //30 DAYs

    @Autowired
    public AccessToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
