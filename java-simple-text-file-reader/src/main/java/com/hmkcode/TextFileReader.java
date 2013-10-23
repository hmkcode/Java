package com.hmkcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	private BufferedReader buffer;
	private String currentLine = "";
	public TextFileReader(){ 
		
	}
	
	public void open(String file){
		
		try {
			close();
			
			buffer = new BufferedReader(new FileReader(file));
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
	
		}
		
	}
	
	public void close(){
		
		try {
			if(buffer != null){
				buffer.close();
				buffer = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String readLine() throws Exception{
		if(buffer != null){
			currentLine = buffer.readLine();
			
			if(currentLine == null)
				close();
			
			return currentLine;
		}
		else
			throw new Exception("No file to read...");
	}
	
	public String getCurrent(){
		return this.currentLine;
	}
	
	public boolean isReadable(){
		return (buffer != null && this.currentLine != null);
	}
}
