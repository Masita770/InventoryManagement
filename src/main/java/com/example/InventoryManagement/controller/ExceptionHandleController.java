package com.example.InventoryManagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handle() {
        return ResponseEntity.internalServerError().body("入力が間違っている、あるいは対象の製品は存在しません。");
    }
}
