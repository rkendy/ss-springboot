package br.uff.ihs.ss.controller.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.uff.ihs.ss.dto.ErrorMsg;
import br.uff.ihs.ss.exception.NotFoundException;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMsg> notFoundHandler(NotFoundException e) {
        return ResponseEntity //
                .status(HttpStatus.NOT_FOUND) //
                .body(new ErrorMsg(e.getMessage()));
    }
}