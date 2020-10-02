package com.hmkcode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, DocumentException
    {
    	// step 1
    	Document document = new Document();
    	document.addAuthor("vanshajpahwa07");
    	document.addCreationDate();
    	document.addCreator("https://github.com/vanshajpahwa07");
    	document.setPageSize(PageSize.A4);
        
    	// step 2
    	PdfWriter.getInstance(document, new FileOutputStream("Table.pdf"));
        
    	// step 3
        document.open();
        
        // step 4 create PDF contents
        document.add(TableBuilder.createTable());
        document.add(new Paragraph(new java.util.Date()));
        
        //step 5
        document.close();

        System.out.println( "PDF Created!" );
    }  
}
