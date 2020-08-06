package br.uff.ihs.ss.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.uff.ihs.ss.dto.ErrorMsg;
import br.uff.ihs.ss.exception.ConflictException;
import br.uff.ihs.ss.exception.NotFoundException;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMsg> notFoundHandler(NotFoundException e) {
        return ResponseEntity //
                .status(HttpStatus.NOT_FOUND) //
                .body(new ErrorMsg(e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorMsg> notFoundHandlerx(ConflictException e) {
        return ResponseEntity //
                .status(HttpStatus.CONFLICT) //
                .body(new ErrorMsg(e.getMessage()));
    }
}