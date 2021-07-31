package com.mannygram.urlShortner.valueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="URL_DETAILS")
public class URLDetails {
	
	@Column(name="URL")
	String url;
	@Id
	@Column(name="id")
	String id;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
