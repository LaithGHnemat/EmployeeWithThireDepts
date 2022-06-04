package com.example.springwithpostgrsql.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoutFoundEmployeeException extends Exception{
    public NoutFoundEmployeeException(String msge) {
        super(msge);
    }
}
