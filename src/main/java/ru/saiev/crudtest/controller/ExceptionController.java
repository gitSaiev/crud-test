package ru.saiev.crudtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.saiev.crudtest.exception.BookNotFoundException;
import ru.saiev.crudtest.exception.ReaderNotFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ReaderNotFoundException.class)
    public ResponseEntity<?> handleReaderNotFoundException(ReaderNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
