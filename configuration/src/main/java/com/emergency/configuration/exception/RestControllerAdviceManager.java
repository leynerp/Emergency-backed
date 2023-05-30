package com.emergency.configuration.exception;


import com.emergency.common.config.ErrorFormat;
import com.emergency.common.exception.DuplicateDataException;
import com.emergency.common.exception.RecourseNotFound;
import com.emergency.configuration.person.exception.DuplicateMedicalRegistryException;
import com.emergency.configuration.person.exception.DuplicateShipperRegistryException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice(annotations = RestController.class)
public class RestControllerAdviceManager {
    @Autowired
    private MessageSource messageSource;
    private final Locale locate=Locale.getDefault();
   /* @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorFormat> handleException(RuntimeException ex) {
        return new ResponseEntity(messageSource.getMessage("api.error.notfound", null, Locale.getDefault()), HttpStatus.NOT_FOUND);
    }*/

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorFormat> handleException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName,getMessageBody("api.error.notBlank"));
        });
        return new ResponseEntity<>(new ErrorFormat(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorFormat> handleExceptionIntegrity(DataIntegrityViolationException ex) {
        return new ResponseEntity(getError("api.error.integrityError", ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorFormat> handleExceptionIntegrity(NoSuchElementException ex) {
        return new ResponseEntity(getError("api.error.notSuchElement", getMessageBody("api.response.nomenclator.update.exception.notSuch"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateData(DuplicateDataException ex) {
        return new ResponseEntity<>(getError("api.error.duplicated", getMessageBody("api.error.duplicated"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorFormat> handleExceptionRecourseNotFound(RecourseNotFound ex) {

        return new ResponseEntity<>(getError("api.error.notfound",getMessageBody("api.error.notfound"), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorFormat> handleExceptionConstraintViolation(ConstraintViolationException ex) {

        return new ResponseEntity<>(getError("api.error.notfound",getMessageBody("api.error.notfound"), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateCodeException.class)
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateCode(DuplicateCodeException ex) {

        return new ResponseEntity<>(getError("api.error.integrityError",getMessageBody("api.error.duplicateCode"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateMedicalRegistryException.class)
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateCode(DuplicateMedicalRegistryException ex) {

        return new ResponseEntity<>(getError("api.error.duplicated",getMessageBody("api.response.doctor.creation.exception.duplicateRegistry"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateShipperRegistryException.class)
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateCode(DuplicateShipperRegistryException ex) {

        return new ResponseEntity<>(getError("api.error.duplicated",getMessageBody("api.response.shipper.creation.exception.duplicateRegistry"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    private ErrorFormat getError(String message, String error, int status) {
        return new ErrorFormat(status, error, getMessageBody(message));
    }

    private String getMessageBody(String message){
      return   messageSource.getMessage(message, null, locate);
    }

}
