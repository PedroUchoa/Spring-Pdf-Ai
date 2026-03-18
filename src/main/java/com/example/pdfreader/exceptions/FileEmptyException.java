package com.example.pdfreader.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "File Empty")
public class FileEmptyException extends RuntimeException{

    public FileEmptyException(){
        super("The File Is Empty");
    }

}
