package com.example.pdfreader.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus httpStatus, String message) {
}
