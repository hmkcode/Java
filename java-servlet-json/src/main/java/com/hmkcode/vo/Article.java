package com.hmkcode.vo;

import java.util.LinkedList;
import java.util.List;

public class Article {

	public String title;
	public String url;
	public List<String> categories;
	public List<String> tags;
	
	public void addCategory(String category){
		if(this.categories == null)
			this.categories = new LinkedList<String>();
		this.categories.add(category);
	}
	public void addTag(String tag){
		if(this.tags == null)
			this.tags = new LinkedList<String>();
		
		this.tags.add(tag);
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", url=" + url + ", categories="
				+ categories + ", tags=" + tags + "]";
	}
	
	
	
}
