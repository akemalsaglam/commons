package com.aks.commons.security.authentication;

import lombok.Data;

@Data
public class ServiceErrorMessage {

  private final String message;
  private final boolean error = true;
}
