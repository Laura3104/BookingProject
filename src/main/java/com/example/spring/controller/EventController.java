package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.exception.HtmlExceptionHandler;
import com.example.spring.service.BookingService;

@Controller
public class EventController extends HtmlExceptionHandler {

  @Autowired private BookingService bookingService;

  @GetMapping("/events/{id}")
  public String getEventsById(@PathVariable("id") long id, Model model) {
    model.addAttribute("events", this.bookingService.getEventById(id));
    return "event";
  }

  @GetMapping("/events")
  public String getEvents(Model model) {
    model.addAttribute("events", this.bookingService.getEvents());
    return "event";
  }
}
