package com.aks.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RsvpFormReplyDeniedException extends RuntimeException {

  private static final String DEFAULT_EXCEPTION_MESSAGE = "RsvpFormReplyDeniedException!";

  public RsvpFormReplyDeniedException() {
    super(DEFAULT_EXCEPTION_MESSAGE);
  }

  public RsvpFormReplyDeniedException(String message) {
    super(message);
  }


}