package com.aks.commons.security.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResetPasswordMailRequest {

  @NotNull
  @NotBlank
  @Email
  String email;
}
