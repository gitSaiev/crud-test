package ru.saiev.crudtest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReaderNotFoundException extends RuntimeException {
    public ReaderNotFoundException(String msg) {
        super(msg);
    }
}
