package com.hmkcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmkcode.vo.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JSONServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// This will store all received articles
	List<Article> articles = new LinkedList<Article>();
	
	/***************************************************
	 * URL: /jsonservlet
	 * doPost(): receives JSON data, parse it, map it and send back as JSON
     * doGet(): receives all JSON data, because after reloading page all
     * data would clear
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. get received JSON data from request
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader br = new BufferedReader(request.getReader());
        while((line = br.readLine()) != null) {
            json.append(line);
        }
		
		// 2. initiate jackson mapper
    	ObjectMapper mapper = new ObjectMapper();
    	
    	// 3. Convert received JSON to Article
    	Article article = mapper.readValue(json.toString(), Article.class);

		// 4. Set response type to JSON
		response.setContentType("application/json; charset=utf-8");
    	
    	// 5. Add article to List<Article>
		articles.add(article);

		// 6. Send List<Article> as JSON to client
    	mapper.writeValue(response.getOutputStream(), articles);
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        mapper.writeValue(response.getOutputStream(), articles);
    }
}
