package com.hmkcode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class HelloWorld 
{
    public static void main( String[] args )
    {
        try {
        	
        	// 1. create the document
        	Document document = new Document();
			document.addAuthor("vanshajpahwa07");
			document.addCreationDate();
			document.addCreator("https://github.com/vanshajpahwa07");
        	// 2. get PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("helloworld.pdf"));
			// 3. open the document
	        document.open();
	        // 4. add the content
	        document.add(new Paragraph("Hello World!"));
	        document.add(new Paragraph(new java.util.Date()));
	        // 5. close the document
	        document.close();
	        
	        System.out.println("Document created!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}      
    }
}
