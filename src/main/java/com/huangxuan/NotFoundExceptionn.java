package com.huangxuan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionn extends RuntimeException{
    public NotFoundExceptionn() {
    }

    public NotFoundExceptionn(String message) {
        super(message);
    }

    public NotFoundExceptionn(String message, Throwable cause) {
        super(message, cause);
    }
}
