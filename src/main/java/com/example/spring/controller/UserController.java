package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.exception.HtmlExceptionHandler;
import com.example.spring.service.BookingService;

@Controller
public class UserController extends HtmlExceptionHandler {

  @Autowired private BookingService bookingService;

  @GetMapping("/users/{id}")
  public String getUsersById(@PathVariable("id") long id, Model model) {
    model.addAttribute("users", this.bookingService.getUserById(id));
    return "user";
  }

  @GetMapping("/users")
  public String getUsers(Model model) {
    model.addAttribute("users", this.bookingService.getUsers());
    return "user";
  }
}
