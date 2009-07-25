package com.gu.api.parser.client;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@SuppressWarnings("serial")
public class Content implements Serializable{

	private Integer id;
	private String type;
	private String apiUrl;
	private String webUrl;
	private String publication;
	private String headline;
	private String byline;
	private String sectionName;
	private String trailText;
	private String linkText;
	private Date publicationDate;
	private List<Tag> taggedWith;
	private String standfirst;
	private String trailImage;
	private String body;
	private Integer pictureCount;
	private Integer durationMinutes;
	private Integer durationSeconds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getByline() {
		return byline;
	}
	public void setByline(String byline) {
		this.byline = byline;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getTrailText() {
		return trailText;
	}
	public void setTrailText(String trailText) {
		this.trailText = trailText;
	}
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public List<Tag> getTaggedWith() {
		return taggedWith;
	}
	public void setTaggedWith(List<Tag> taggedWith) {
		this.taggedWith = taggedWith;
	}
	public String getStandfirst() {
		return standfirst;
	}
	public void setStandfirst(String standfirst) {
		this.standfirst = standfirst;
	}
	public String getTrailImage() {
		return trailImage;
	}
	public void setTrailImage(String trailImage) {
		this.trailImage = trailImage;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Integer getPictureCount() {
		return pictureCount;
	}
	public void setPictureCount(Integer pictureCount) {
		this.pictureCount = pictureCount;
	}
	public Integer getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	public Integer getDurationSeconds() {
		return durationSeconds;
	}
	public void setDurationSeconds(Integer durationSeconds) {
		this.durationSeconds = durationSeconds;
	}
}
