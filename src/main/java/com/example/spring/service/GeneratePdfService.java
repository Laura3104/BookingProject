package com.example.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;

@Component
public class GeneratePdfService {

  @Autowired SpringTemplateEngine springTemplateEngine;

  private byte[] generatePdfFromHtmlTemplate(Context context, String view)
      throws DocumentException, IOException {

    String html = springTemplateEngine.process(view, context);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocumentFromString(html);
    renderer.layout();
    renderer.createPDF(outputStream);
    return outputStream.toByteArray();
  }

  private ResponseEntity<byte[]> generatePdfResponse(byte[] contentsByte, String fileName) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData(fileName, fileName);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    return new ResponseEntity<>(contentsByte, headers, HttpStatus.OK);
  }

  public ResponseEntity<byte[]> createPdfAndGenerateResponse(
      Context context, String view, String fileName) throws DocumentException, IOException {
    return generatePdfResponse(generatePdfFromHtmlTemplate(context, view), fileName);
  }
}
