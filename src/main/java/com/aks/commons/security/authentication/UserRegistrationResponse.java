package com.aks.commons.security.authentication;

import com.aks.commons.controller.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegistrationResponse extends BaseResponse {

  private String name;
  private String surname;
  private String email;
  private String birthDate;
  private String address;
  private String role;
}
