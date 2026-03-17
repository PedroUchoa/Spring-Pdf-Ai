package com.example.pdfreader.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class PdfExtractorService {

    private final AssistantAiService aiService;

    public PdfExtractorService(AssistantAiService aiService) {
        this.aiService = aiService;
    }


    public String extractContent(MultipartFile file){
        if (file == null || file.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The File Is Empty");

        if (!"application/pdf".equals(file.getContentType()))
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Format Invalid, Please Just Upload PDFs");

        try (PDDocument document = Loader.loadPDF(file.getBytes())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return aiService.handleRequest(stripper.getText(document)).content();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Processing Your PDF, Please Try Again");
        }
    }

}
