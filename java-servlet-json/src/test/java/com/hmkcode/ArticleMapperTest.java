package com.hmkcode;/**
 * Author: wge
 * Date: 22/11/2013
 * Time: 18:09
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmkcode.vo.Article;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ArticleMapperTest
{
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(ArticleMapperTest.class.getName());


    @Test
    public void testValidJson() throws Exception
    {
        String json = readlineFromResourceFile("/valid.json");

        ObjectMapper mapper = new ObjectMapper();
       	Article article = mapper.readValue(json, Article.class);

        assert(article.url.equals("news.bbc.co.uk"));
        assert(article.categories.contains("news"));
        assert(article.categories.size() == 1);
        assert(article.tags.size() == 1);
        assert(article.tags.contains("uk news"));

        List<Article> articles = new ArrayList<Article>();
   		articles.add(article);

        Article extra = new Article();
        extra.url = "www.google.co.uk";
        List categoryList = new ArrayList<String>();
        categoryList.add("youtube");
        categoryList.add("gmail");
        categoryList.add("gdrive");

        extra.categories =  categoryList;
        extra.addTag("search");

        articles.add(extra);

        //this will appear in the root of your project.
       	mapper.writeValue(new File("modified.json"), articles);
    }

    @Test (expected=com.fasterxml.jackson.core.JsonParseException.class)
    public void testBadInput() throws Exception
    {
        String json = readlineFromResourceFile("/malformed.json");
        ObjectMapper mapper = new ObjectMapper();
       	Article article = mapper.readValue(json, Article.class);
   }

    @Test
    public void missingUrl() throws Exception
    {
        String json = readlineFromResourceFile("/missingUrl.json");
        ObjectMapper mapper = new ObjectMapper();
       	Article article = mapper.readValue(json, Article.class);
        assert(article.url == null);
        assert(article.categories.contains("news"));
        assert(article.categories.size() == 1);
        assert(article.tags.size() == 1);
        assert(article.tags.contains("uk news"));


    }

    String readlineFromResourceFile(String filename) throws IOException
    {
        InputStream is = getClass().getResourceAsStream(filename);
        byte[] buff = new byte[1000];
        is.read(buff);
        return new String(buff);
    }
}
