 package com.github.apiCep.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@Log4j2
@ControllerAdvice
public class GlobalExpectionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(AddressNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AddressBadRequestException.class)
    public final ResponseEntity<Object> handleAllExceptions(AddressBadRequestException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }


}
