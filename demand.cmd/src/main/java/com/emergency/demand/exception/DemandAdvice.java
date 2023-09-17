package com.emergency.demand.exception;

import com.emergency.common.config.ErrorFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice(annotations = RestController.class)
public class DemandAdvice {
    @Autowired
    private MessageSource messageSource;
    private final Locale locate=Locale.getDefault();
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorFormat> handleException(RuntimeException ex) {
        return new ResponseEntity<>(getError("api.error.notfound",getMessageBody(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateDemandException.class)
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateCode() {

        return new ResponseEntity<>(getError("api.error.duplicated",getMessageBody("api.response.demand.creation.exception.duplicateRegistry"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
    private ErrorFormat getError(String message, String error, int status) {
        return new ErrorFormat(status, error, getMessageBody(message));
    }
    private String getMessageBody(String message){
        return   messageSource.getMessage(message, null, locate);
    }


}
