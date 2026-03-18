package com.example.pdfreader.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE, reason = "File Format Invalid")
public class FormatInvalidException extends RuntimeException{

    public FormatInvalidException(){
        super("Format Invalid, Please Just Upload PDFs");
    }

}
