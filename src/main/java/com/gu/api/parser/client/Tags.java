package com.gu.api.parser.client;

import java.util.List;

public class Tags {
	
	private Integer count;
	private Integer startIndex;
	private List<Tag> tags;
	private String xml;

	public Tags(Integer count, Integer startIndex, List<Tag> tags) {
		this.count = count;
		this.startIndex = startIndex;
		this.tags = tags;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getXml() {
		return xml;
	}
}
