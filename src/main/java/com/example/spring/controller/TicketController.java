package com.example.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.Context;

import com.example.spring.model.dto.Ticket;
import com.example.spring.service.BookingService;
import com.example.spring.service.GeneratePdfService;
import com.itextpdf.text.DocumentException;

@Controller
public class TicketController {

  @Autowired private BookingService bookingService;

  @Autowired private GeneratePdfService generatePdfService;

  @GetMapping(
      value = "/getBookedTickets/{userId}",
      produces = {"application/pdf; charset=utf-8"},
      headers = {"Accept=application/pdf"})
  public ResponseEntity<byte[]> getBookedTicketsByUser(@PathVariable String userId)
      throws DocumentException, IOException {

    List<Ticket> bookedTicketsList = bookingService.getBookedTicketsByUserId(userId);

    Context model = new Context();
    model.setVariable("tickets", bookedTicketsList);

    return generatePdfService.createPdfAndGenerateResponse(model, "ticket", "bookedTickets.pdf");
  }
}
