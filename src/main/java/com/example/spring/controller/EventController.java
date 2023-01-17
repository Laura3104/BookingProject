/*package com.example.spring.controller;

import com.example.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/users/{id}")
    public String users(@PathVariable("id") long id, Model model){
        model.addAttribute("users", this.bookingService.getUserById(id));
        return "user";
    }
}*/
