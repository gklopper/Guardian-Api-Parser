package com.gu.api.parser.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tag implements Serializable{

	private String apiUrl;
	private String filter;
	private String name;
	private String type;
	private String webUrl;
	private Integer count;
	private String filterUrl;
	
	public Tag() {
		
	}
	
	public Tag(String name, String type, String filter, String apiUrl,
			String webUrl, Integer count, String filterUrl) {
				this.name = name;
				this.type = type;
				this.filter = filter;
				this.apiUrl = apiUrl;
				this.webUrl = webUrl;
				this.count = count;
				this.filterUrl = filterUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getFilter() {
		return filter;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getWebUrl() {
		return webUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiUrl == null) ? 0 : apiUrl.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((filter == null) ? 0 : filter.hashCode());
		result = prime * result
				+ ((filterUrl == null) ? 0 : filterUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((webUrl == null) ? 0 : webUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (apiUrl == null) {
			if (other.apiUrl != null)
				return false;
		} else if (!apiUrl.equals(other.apiUrl))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (filter == null) {
			if (other.filter != null)
				return false;
		} else if (!filter.equals(other.filter))
			return false;
		if (filterUrl == null) {
			if (other.filterUrl != null)
				return false;
		} else if (!filterUrl.equals(other.filterUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (webUrl == null) {
			if (other.webUrl != null)
				return false;
		} else if (!webUrl.equals(other.webUrl))
			return false;
		return true;
	}

	public Integer getCount() {
		return count;
	}

	public String getFilterUrl() {
		return filterUrl;
	}
	
	
}
