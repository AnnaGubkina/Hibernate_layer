package com.gubkina.hibernate.homework.hibernate_dao_layer.exception_handling.handler;


import com.gubkina.hibernate.homework.hibernate_dao_layer.exception_handling.exceptions.NoSuchPersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PersonIncorrectData> handleException(NoSuchPersonException exception) {
        PersonIncorrectData data = new PersonIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
