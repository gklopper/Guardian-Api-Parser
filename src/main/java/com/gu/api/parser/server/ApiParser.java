package com.gu.api.parser.server;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gu.api.parser.client.Content;
import com.gu.api.parser.client.Search;
import com.gu.api.parser.client.Tag;
import com.gu.api.parser.client.Tags;


public class ApiParser {
    private static final SimpleDateFormat PUBLICATION_DATE_FORMAT = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.UK);

    public static Search parseSearch(InputStream xml) throws SAXException, IOException, ParserConfigurationException, ParseException {
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
		
		Element searchElement = document.getDocumentElement();

		return buildSearch(searchElement);
	}
	
	public static Tags parseTags(InputStream xml) throws SAXException, IOException, ParserConfigurationException, ParseException {
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
		
		Element tagsElement = document.getDocumentElement();
		
		return buildTags(tagsElement);
	}
	
	public static Content parseContent(InputStream xml) throws SAXException, IOException, ParserConfigurationException, ParseException {
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
		
		Element contentElement = document.getDocumentElement();
		
		return buildContent(contentElement);
	}
	
	private static Content buildContent(Element item) throws ParseException {
		
		Content content = new Content();
		
		content.setId(integerOrNull(item.getAttribute("id")));
		content.setType(item.getAttribute("type"));
		content.setApiUrl(item.getAttribute("api-url"));
		content.setWebUrl(item.getAttribute("web-url"));
		
	    content.setPublication(elementValueOrNull(item, "publication"));
	    content.setHeadline(elementValueOrNull(item, "headline"));
	    
	    content.setStandfirst(elementValueOrNull(item, "standfirst"));
	    
	    content.setByline(elementValueOrNull(item, "byline"));
	    content.setSectionName(elementValueOrNull(item, "section-name"));
	    content.setTrailText(elementValueOrNull(item, "trail-text"));
	    content.setLinkText(elementValueOrNull(item, "link-text"));
	    content.setTrailImage(elementValueOrNull(item, "trail-image"));
	    
	   
	    content.setPublicationDate(PUBLICATION_DATE_FORMAT.parse(item.getElementsByTagName("publication-date").item(0).getTextContent().replace("T", " ")));
	    
	    Element tags = (Element) item.getElementsByTagName("tagged-with").item(0);
		NodeList tagList = tags.getElementsByTagName("tag");
		List<Tag> taggedWith = new ArrayList<Tag>();
		for (int i = 0; i < tagList.getLength(); i++) {
			taggedWith.add(buildTag((Element)tagList.item(i)));
		}
		content.setTaggedWith(taggedWith);
		
		if ("article".equals(content.getType())) {
			Element typeSpecific = (Element) item.getElementsByTagName("type-specific").item(0);
			content.setBody(elementValueOrNull(typeSpecific, "body"));
		}
		
		
		if ("gallery".equals(content.getType())) {
			Element typeSpecific = (Element) item.getElementsByTagName("type-specific").item(0);
			content.setPictureCount(integerOrNull(typeSpecific.getElementsByTagName("picture-count").item(0).getTextContent()));
		}
		
		//these two currently have the same fields
		if ("video".equals(content.getType()) || "audio".equals(content.getType())) {
			Element typeSpecific = (Element) item.getElementsByTagName("type-specific").item(0);
			content.setDurationMinutes(Integer.parseInt(typeSpecific.getElementsByTagName("duration-minutes").item(0).getTextContent()));
			content.setDurationSeconds(Integer.parseInt(typeSpecific.getElementsByTagName("duration-seconds").item(0).getTextContent()));
			
		}
		
		return content;
	}

	private static Tags buildTags(Element tagsElement) {
		Integer count = integerOrNull(tagsElement.getAttribute("count"));
		Integer startIndex = integerOrNull(tagsElement.getAttribute("start-index"));
		
		NodeList tags = tagsElement.getElementsByTagName("tag");
		List<Tag> tagList = new ArrayList<Tag>();
		for (int i = 0; i < tags.getLength(); i++) {
			tagList.add(buildTag((Element)tags.item(i)));
		}
		return new Tags(count, startIndex, tagList);
	}

	private static Search buildSearch(Element searchElement) throws ParseException {
		int count = integerOrNull(searchElement.getAttribute("count"));
		int startIndex = Integer.parseInt(searchElement.getAttribute("start-index"));
		
		Element results = (Element) searchElement.getElementsByTagName("results").item(0);
		NodeList contentList = results.getElementsByTagName("content");
		List<Content> resultList = new ArrayList<Content>();
		for (int i = 0; i < contentList.getLength(); i++) {
			resultList.add(buildContent((Element)contentList.item(i)));
		}
		
		Element filters = (Element) searchElement.getElementsByTagName("filters").item(0);
		NodeList tagList = filters.getElementsByTagName("tag");
		List<Tag> filterList = new ArrayList<Tag>();
		for (int i = 0; i < tagList.getLength(); i++) {
			filterList.add(buildTag((Element)tagList.item(i)));
		}
		
		return new Search(count, startIndex, resultList, filterList);
	}

	private static Integer integerOrNull(String value) {
		
		if (value == null || value.equals("")) {
			return null;
		}
		return Integer.parseInt(value);
	}

	private static Tag buildTag(Element item) {
		String name = item.getAttribute("name");
		String type = item.getAttribute("type");
		String filter = item.getAttribute("filter");
		String apiUrl = item.getAttribute("api-url");
		String webUrl = item.getAttribute("web-url");
		Integer count = integerOrNull(item.getAttribute("count"));
		String filterUrl = item.getAttribute("filter-url");
		return new Tag(name, type, filter, apiUrl, webUrl, count, filterUrl);
	}

	private static String elementValueOrNull(Element item, String elementName) {
		Node standFastNode = item.getElementsByTagName(elementName).item(0);
		if (standFastNode != null) {
	    	return standFastNode.getTextContent();
	    }
		return null;
	}
}
