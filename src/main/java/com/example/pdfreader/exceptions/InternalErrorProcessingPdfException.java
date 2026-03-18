package com.example.pdfreader.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error Processing PDF")
public class InternalErrorProcessingPdfException extends RuntimeException{

    public InternalErrorProcessingPdfException(){
        super("Internal Server Error Processing Your PDF, Please Try Again");
    }

}
