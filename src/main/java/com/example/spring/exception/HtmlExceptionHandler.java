package com.example.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class HtmlExceptionHandler {
    @ExceptionHandler(NonExistentUserException.class)
    public String handleNoExistentUserException(NonExistentUserException e, Model model){
        log.warn(e.toString());
        model.addAttribute("message", "No User Found");
        return "error";
    }
}
