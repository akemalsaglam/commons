package com.aks.commons.exception;


import java.util.Arrays;
import java.util.List;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

  private HttpStatus status;
  private int errorCode;
  private String message;
  private List<String> errors;

  public ApiError(HttpStatus status, int errorCode, String message, List<String> errors) {
    super();
    this.status = status;
    this.message = message;
    this.errors = errors;
    this.errorCode = errorCode;
  }

  public ApiError(HttpStatus status, int errorCode, String message, String error) {
    super();
    this.status = status;
    this.message = message;
    errors = Arrays.asList(error);
    this.errorCode = errorCode;
  }
}


