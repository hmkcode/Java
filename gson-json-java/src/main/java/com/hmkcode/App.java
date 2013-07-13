package com.hmkcode;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hmkcode.vo.Article;


public class App 
{
    public static void main( String[] args )
    {
    	Gson gson = new Gson();
    	

    	List<Article> articles = new LinkedList<Article>();
    	
    	articles.add(createArticle());
    	articles.add(createArticle());
    	
    	// Java --> JSON
    	String json = gson.toJson(articles);
    	System.out.println("toJson: "+json);
    	
    	
    	// JSON --> Java
    	List list = gson.fromJson(json, List.class);
    	System.out.println("fromJson: "+list);
    	System.out.println("Class Type: "+list.get(0).getClass());

    	// JSON --> Java "Get the actual type"
    	Type type = new TypeToken<List<Article>>(){}.getType();
    	list = gson.fromJson(json, type);
    	System.out.println("fromJson: "+list);
    	System.out.println("Class Type: "+list.get(0).getClass());


    }
    private static Article createArticle(){
    	
    	Article article = new Article();
    	
    	article.setTitle("GSON - Java JSON Library");
    	article.setUrl("http://hmkcode.com/gson-json-java");
    	article.addCategory("Java");
    	article.addTag("Java");
    	article.addTag("GSON");
    	article.addTag("JSON");
    	
    	return article;
    }
}