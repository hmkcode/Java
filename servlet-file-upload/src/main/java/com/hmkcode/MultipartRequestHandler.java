package com.hmkcode;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hmkcode.vo.FileMeta;

public class MultipartRequestHandler {

	

	public static List<FileMeta> uploadByJavaServletAPI(HttpServletRequest request) throws IOException, ServletException{
		
		List<FileMeta> files = new LinkedList<FileMeta>();
		
		// 1. Get all parts
		Collection<Part> parts = request.getParts();
		
		// 2. Get paramter "twitter"
		String twitter = request.getParameter("twitter");

		// 3. Go over each part
		FileMeta temp = null;
		for(Part part:parts){	

			// 3.1 if part is multiparts "file"
			if(part.getContentType() != null){
				
				// 3.2 Create a new FileMeta object
				temp = new FileMeta();
				temp.setFileName(getFilename(part));
				temp.setFileSize(part.getSize()/1024 +" Kb");
				temp.setFileType(part.getContentType());
				temp.setContent(part.getInputStream());
				temp.setTwitter(twitter);
				
				// 3.3 Add created FileMeta object to List<FileMeta> files
				files.add(temp);
				
			}
		}
		return files;
	}
	
	public static List<FileMeta> uploadByApacheFileUpload(HttpServletRequest request) throws IOException, ServletException{
				
		List<FileMeta> files = new LinkedList<FileMeta>();
		
		// 1. Check request has multipart content
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileMeta temp = null;
		
		// 2. If yes (it has multipart "files")
		if(isMultipart){

			// 2.1 instantiate Apache FileUpload classes
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			

			// 2.2 Parse the request
			try {
				
				// 2.3 Get all uploaded FileItem
				List<FileItem> items = upload.parseRequest(request);
				String twitter = "";
				
				// 2.4 Go over each FileItem
				for(FileItem item:items){
					
					// 2.5 if FileItem is not of type "file"
				    if (item.isFormField()) {

				    	// 2.6 Search for "twitter" parameter
				        if(item.getFieldName().equals("twitter"))
				        	twitter = item.getString();
				        
				    } else {
				       
				    	// 2.7 Create FileMeta object
				    	temp = new FileMeta();
						temp.setFileName(item.getName());
						temp.setContent(item.getInputStream());
						temp.setFileType(item.getContentType());
						temp.setFileSize(item.getSize()/1024+ "Kb");
						
				    	// 2.7 Add created FileMeta object to List<FileMeta> files
						files.add(temp);
				       
				    }
				}
				
				// 2.8 Set "twitter" parameter 
				for(FileMeta fm:files){
					fm.setTwitter(twitter);
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return files;
	}

	
	// this method is used to get file name out of request headers
	// 
	private static String getFilename(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
}
