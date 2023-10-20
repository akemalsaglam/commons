package com.aks.commons.security.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountActivationRequest {

  @NotNull
  @NotBlank
  @Email
  String email;

  @NotNull
  @NotBlank
  String token;
}
