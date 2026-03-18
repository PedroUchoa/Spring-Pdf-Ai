package com.example.pdfreader.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileEmptyException.class)
    public ResponseEntity<ErrorMessage> handleFileEmptyException(FileEmptyException ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(FormatInvalidException.class)
    public ResponseEntity<ErrorMessage> handleFormatInvalidException(FileEmptyException ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE,ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(threatResponse);
    }

    @ExceptionHandler(InternalErrorProcessingPdfException.class)
    public ResponseEntity<ErrorMessage> handleInternalErrorProcessingPdfException(FileEmptyException ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }

}
