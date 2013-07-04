package com.hmkcode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.hmkcode.vo.Article;

public class App 
{
    public static void main( String[] args )
    {
        
    	try {
			
	    	//( 1 ) OBJECT --> XML
    		FileWriter writer = new FileWriter("article.xml");
			Marshaller.marshal(createArticle(), writer);
			writer.close();
			
			
	    	//( 2 ) XML --> OBJECT
			FileReader reader = new FileReader("article.xml");
			Article article = (Article) Unmarshaller.unmarshal(Article.class, reader);
			
			System.out.println(article);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}

    }
    
    public static Article createArticle(){
    	Article article = new Article();
    	
    	article.setTitle("Castor - Java Object to XML & XML to Object Mapping");
    	article.setUrl("http://hmkcode.com/castor-java-object-xml");
    	article.addCategory("Java");
    	article.addTag("Java");
    	article.addTag("Castor");
    	article.addTag("XML");
    	article.addTag("Marshalling");
    	article.addTag("Unmarshalling");
    	
    	return article;
    }
}
