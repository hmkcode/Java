package com.hmkcode.vo;

import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

@XStreamAlias("article")
public class Article {

	@XStreamAsAttribute
	private String title;
	
	@XStreamAlias("address")
	private String url;
	
	@XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
	private boolean published;
	
	@XStreamOmitField
	private List<String> categories;
	
	@XStreamImplicit(itemFieldName="tag")
	private List<String> tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
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
		return "Article [title=" + title + ",\nurl=" + url + ",\npublished="
				+ published + ",\ncategories=" + categories + ",\ntags=" + tags
				+ "]";
	}
	
	
	
	
}
