package com.sada.LibraryManagement.Eceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(userAllreadyExist.class)
    public ResponseEntity<RessponseModel> userAllreadyExist(Exception ex) {
      RessponseModel resp = new RessponseModel();
      resp.setSuccess(false);
      resp.setMessage(ex.getMessage());
      resp.setStatus(HttpStatus.ALREADY_REPORTED);
        return new ResponseEntity<>(resp, HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(objectNootFound.class)
    public ResponseEntity<RessponseModel> objectnotFound(Exception e){
        RessponseModel resp = new RessponseModel();
        resp.setSuccess(false);
        resp.setMessage(e.getMessage());
        resp.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LimitExcced.class)
    public ResponseEntity<RessponseModel> limitExcced(Exception e){
        RessponseModel resp = new RessponseModel();
        resp.setSuccess(false);
        resp.setMessage(e.getMessage());
        resp.setStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
        return new ResponseEntity<>(resp, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }
}
