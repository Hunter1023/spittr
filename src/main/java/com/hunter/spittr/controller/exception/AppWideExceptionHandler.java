package com.hunter.spittr.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
    //处理spittle重复的异常
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(){
        return "error/duplicate";
    }
}
