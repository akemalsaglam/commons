package com.aks.commons.security.authentication;

import lombok.Data;

@Data
public class SuccessMessage {

  private final String message;
  private final boolean error = false;
}
