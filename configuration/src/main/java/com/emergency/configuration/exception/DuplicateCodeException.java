package com.emergency.configuration.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuplicateCodeException extends RuntimeException {
   public DuplicateCodeException(String message){
      super(message);
    }

}
