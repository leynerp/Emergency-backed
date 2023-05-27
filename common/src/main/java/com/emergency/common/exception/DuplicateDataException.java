package com.emergency.common.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuplicateDataException extends RuntimeException {
   public DuplicateDataException(String message){
      super(message);
    }

}
