package com.example.InventoryManagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@ControllerAdvice(annotations = Controller.class)
public class ExceptionHandleController {

    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception exception, Model model) {
        model.addAttribute("errorMessage", "存在しない品番です。");
        return "items/error";
//        return new ResponseEntity<>("この値は存在しません" + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        return ResponseEntity.internalServerError().body("入力が間違っている、あるいは対象の製品は存在しません。");
    }
}
