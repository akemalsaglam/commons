package com.aks.commons.security.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ResetPasswordRequest {

  @NotNull @Email String email;

  @NotNull String token;

  @NotNull
  @NotBlank(message = "password is required.")
  @Length(min = 5, message = "password length should be >=5")
  String password;

  @NotNull
  @NotBlank(message = "password is required.")
  @Length(min = 5, message = "password length should be >=5")
  String repassword;
}
