package com.hmkcode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;


public class PageSettings 
{
    public static void main( String[] args )
    {
        try {
        	
        	// 1. create the document page size: A4, margins: left:20 right:20 top:40 bottom:40
        	Document document = new Document(PageSize.A4, 20f,20f,40f,40);
        	
        	//for custom pagesize 
        	//Rectangle pagesize = new Rectangle(216f, 720f);
        	
        	// 2. get PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("pagesettings.pdf"));
			// 3. open the document
	        document.open();
	        // 4. add the content
	        document.add(new Paragraph("Hello World!"));
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
