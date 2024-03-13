package com.example.pdf_element_recognition.BackEnd;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class pdfParser {

    public static void main(String[] args) {
        pdfParser pdf = new pdfParser();
        PDDocument docs = null;
        docs = pdf.LoadnProcess("\\C:\\Users\\moham\\OneDrive\\Desktop\\PdfTest\\Alesya.pdf\\");
        pdf.getContent(docs);
        try {
            docs.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public PDDocument LoadnProcess(String path){
        File file = new File(path);
        PDDocument document = null;
        try {
            //load the document
            document = Loader.loadPDF(file);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return document;
    }

    public String getContent(PDDocument document){
        PDFTextStripper pdfStripper = new PDFTextStripper();

        String text = null;
        //get text from document
        try {
            text = pdfStripper.getText(document);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(text);
        return text;
    }
}