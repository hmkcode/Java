package com.hmkcode;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class TableBuilder {
	 // create table
    public static PdfPTable createTable() throws DocumentException {
    	

        // create 6 column table
        PdfPTable table = new PdfPTable(6);
        
        // set the width of the table to 100% of page
        table.setWidthPercentage(100);
        
        // set relative columns width
        table.setWidths(new float[]{0.6f, 1.4f, 0.8f,0.8f,1.8f,2.6f});

        
        // ----------------Table Header "Title"----------------
        // font
        Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
        // create header cell
        PdfPCell cell = new PdfPCell(new Phrase("HMKCODE.com - iText PDFTable Example",font));
        // set Column span "1 cell = 6 cells width"
        cell.setColspan(6);
        // set style
        Style.headerCellStyle(cell);
        // add to table
        table.addCell(cell);
        
        //-----------------Table Cells Label/Value------------------
        
        // 1st Row
        table.addCell(createLabelCell("Label 1"));
        table.addCell(createValueCell("Value 1"));
        table.addCell(createLabelCell("Label 2"));
        table.addCell(createValueCell("Value 2"));
        table.addCell(createLabelCell("Label 3"));
        table.addCell(createValueCell("Value 3"));

        // 2nd Row
        table.addCell(createLabelCell("Label 4"));
        table.addCell(createValueCell("Value 4"));
        table.addCell(createLabelCell("Label 5"));
        table.addCell(createValueCell("Value 5"));
        table.addCell(createLabelCell("Label 6"));
        table.addCell(createValueCell("Value 6"));

        return table;
    }
    
    // create cells
    private static PdfPCell createLabelCell(String text){
    	// font
    	Font font = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.DARK_GRAY);
    	
    	// create cell
    	PdfPCell cell = new PdfPCell(new Phrase(text,font));

    	// set style
    	Style.labelCellStyle(cell);
        return cell;
    }
    
    // create cells
    private static PdfPCell createValueCell(String text){
    	// font
    	Font font = new Font(FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
    	
    	// create cell
    	PdfPCell cell = new PdfPCell(new Phrase(text,font));
    	
    	// set style
    	Style.valueCellStyle(cell);
        return cell;
    }
}
