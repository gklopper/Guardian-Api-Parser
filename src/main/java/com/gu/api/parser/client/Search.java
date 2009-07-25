package com.gu.api.parser.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Search implements Serializable{
	
	private Integer count;
	private List<Tag> filters = new ArrayList<Tag>();
	private List<Content> results = new ArrayList<Content>(); 
	private Integer startIndex;
	private String apiUrl;
	private String xml;
	
	public Search() {
		
	}
	
	public Search(Integer count, Integer startIndex, List<Content> results, List<Tag> filters) {
		this.count = count;
		this.startIndex = startIndex;
		this.results = results;
		this.filters = filters;
	}

	public Integer getCount() {
		return count;
	}

	public List<Tag> getFilters() {
		return filters;
	}

	public List<Content> getResults() {
		return results;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getXml() {
		return xml;
	}

}
