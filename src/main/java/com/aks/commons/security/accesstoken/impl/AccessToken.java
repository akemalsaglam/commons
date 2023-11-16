package com.aks.commons.security.accesstoken.impl;

import org.springframework.stereotype.Component;

@Component
public class AccessToken extends BaseToken {

  public static final long TOKEN_VALIDITY_SECONDS = 30 * 24 * 60 * 60; //30 DAYs

  public AccessToken() {
    super(TOKEN_VALIDITY_SECONDS);
  }
}
