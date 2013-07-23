package com.hmkcode;


import com.hmkcode.vo.Article;
import com.thoughtworks.xstream.XStream;


public class App 
{
    public static void main( String[] args )
    {

    	XStream xs = new XStream();
    	xs.autodetectAnnotations(true);
    	
    	// <com.hmkcode.vo.Article> --> <article>
    	//xs.alias("article", Article.class);
    	// <url> --> <address>
    	// xs.aliasField("address", Article.class, "url");
    	
    	// OBJECT --> XML
        String xml = xs.toXML(createArticle());
        
        System.out.println("OBJECT --> XML");
        System.out.println(xml);
        
        System.out.println("\n--------------------------------\n");

    	// XML --> OBJECT
        Article article = (Article) xs.fromXML(xml);
        
        System.out.println("XML --> OBJECT");
        System.out.println(article);
    }
    
  private static Article createArticle(){
    	
    	Article article = new Article();
    	
    	article.setTitle("XStream - Java Object to XML & XML to Object Mapping");
    	article.setUrl("http://hmkcode.com/xstream-java-object-xml");
    	article.setPublished(true);
    
    	article.addCategory("Java");
    	article.addTag("Java");
    	article.addTag("Xstream");
    	article.addTag("XML");
    	article.addTag("Marshalling");
    	article.addTag("Unmarshalling");
    	
    	return article;
    }
}
