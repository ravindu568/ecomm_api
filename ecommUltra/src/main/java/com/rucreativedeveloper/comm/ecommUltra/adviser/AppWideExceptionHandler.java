package com.rucreativedeveloper.comm.ecommUltra.adviser;

import com.rucreativedeveloper.comm.ecommUltra.exeption.EntryNotFoundException;
import com.rucreativedeveloper.comm.ecommUltra.util.StanderedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StanderedResponse> entryNotFoundException(EntryNotFoundException e) {
        return new ResponseEntity<>(
                new StanderedResponse(404,e.getMessage(),e),HttpStatus.NOT_FOUND
        );
    }
}
