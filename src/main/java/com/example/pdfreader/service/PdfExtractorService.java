package com.example.pdfreader.service;

import com.example.pdfreader.exceptions.FileEmptyException;
import com.example.pdfreader.exceptions.FormatInvalidException;
import com.example.pdfreader.exceptions.InternalErrorProcessingPdfException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PdfExtractorService {

    private final AssistantAiService aiService;

    public PdfExtractorService(AssistantAiService aiService) {
        this.aiService = aiService;
    }


    public String extractContent(MultipartFile file) {
        System.out.println("teste");
        if (file == null || file.isEmpty()) throw new FileEmptyException();
        if (!"application/pdf".equals(file.getContentType())) throw new FormatInvalidException();

        try (PDDocument document = Loader.loadPDF(file.getBytes())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return aiService.handleRequest(stripper.getText(document)).content();
        } catch (IOException e) {
            throw new InternalErrorProcessingPdfException();
        }
    }

}
