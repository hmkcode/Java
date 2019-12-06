package com.hmkcode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

public class App 
{
	public static final String HTML = "<h1>Hello</h1>"
			+ "<p>This was created using iText</p>"
			+ "<a href='hmkcode.com'>hmkcode.com</a>";
	
	
    public static void main( String[] args ) throws FileNotFoundException, IOException  
    {
    	
    	// String to PDF
    	HtmlConverter.convertToPdf(HTML, new FileOutputStream("string-to-pdf.pdf"));
    	
    	
    	// HTML file to PDF
    	HtmlConverter.convertToPdf(new FileInputStream("index.html"), 
    			new FileOutputStream("index-to-pdf.pdf"));
    	
    	
        System.out.println( "PDF Created!" );
    }
}
