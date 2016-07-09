package com.example.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import org.codehaus.jackson.annotate.JsonIgnore;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "feed")
public class Feed implements Serializable, BaseEntity<Long> {

	@Id
	@Column(nullable = false)
	@SequenceGenerator(name = "FEED_ID_GENERATOR", sequenceName = "FEED_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEED_ID_GENERATOR")
	private Long id;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feed")
	private java.util.List<FeedEntry> entries;

	@Column
	private String url;

	public Feed() {

	}

	public void addEntry() {

	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof Feed){
			Feed ptr = (Feed) o;
			retVal = ptr.id.equals(id);
		}
		return retVal;
	}
}
