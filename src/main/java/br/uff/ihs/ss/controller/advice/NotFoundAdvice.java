package br.uff.ihs.ss.controller.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.uff.ihs.ss.exception.NotFoundException;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFoundHandler(NotFoundException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}