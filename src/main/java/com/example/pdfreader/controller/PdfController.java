package com.example.pdfreader.controller;

import com.example.pdfreader.dto.ContentResponseDto;
import com.example.pdfreader.service.AssistantAiService;
import com.example.pdfreader.service.PdfExtractorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private final PdfExtractorService pdfService;

    public PdfController(PdfExtractorService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/extract")
    public ResponseEntity<ContentResponseDto> extractPdf(@RequestParam("file")MultipartFile file){
        String extractedText = pdfService.extractContent(file);
        return ResponseEntity.ok(new ContentResponseDto(extractedText));
    }

}
