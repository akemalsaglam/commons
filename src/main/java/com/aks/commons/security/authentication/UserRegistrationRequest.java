package com.aks.commons.security.authentication;

import com.aks.commons.controller.BaseRequest;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegistrationRequest extends BaseRequest {

  @NotNull
  @NotBlank(message = "name is required.")
  private String name;

  @NotNull
  @NotBlank(message = "surname is required.")
  private String surname;

  @NotNull
  @NotBlank(message = "email is required.")
  @Email
  private String email;

  private String birthDate;

  private String address;

  @NotNull
  @NotBlank(message = "password is required.")
  @Length(min = 5, message = "password length should be >=5")
  private String password;

  @NotNull
  @NotBlank(message = "repassword is required.")
  @Length(min = 5, message = "repassword length should be >=5")
  private String repassword;

  @NotNull
  @NotBlank(message = "phone is required.")
  private String phone;

  private boolean termsAndConditionsAccepted;

  private String utm_campaign;
  private String utm_source;
  private String utm_medium;
  private String utm_term;
  private String utm_content;
}
