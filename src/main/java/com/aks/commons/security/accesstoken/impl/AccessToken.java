package com.aks.commons.security.accesstoken.impl;

public class AccessToken extends BaseToken {

    public static final long TOKEN_VALIDITY_SECONDS = 15 * 24 * 60 * 60; //15 DAYs

    public AccessToken() {
        super(TOKEN_VALIDITY_SECONDS);
    }
}
