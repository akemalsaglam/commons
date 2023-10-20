package com.aks.commons.security.authentication;

public class UserAlreadyActivatedException extends RuntimeException {

  public UserAlreadyActivatedException(String message) {
    super(message, null, false, false);
  }

}
