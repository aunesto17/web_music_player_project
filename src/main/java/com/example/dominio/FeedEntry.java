package com.example.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "feedentry")
public class FeedEntry implements Serializable, BaseEntity<Long> {

	@Id
	@Column(nullable = false)
	@SequenceGenerator(name = "FEEDENTRY_ID_GENERATOR", sequenceName = "FEEDENTRY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEEDENTRY_ID_GENERATOR")
	private Long id;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Timestamp timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feed_id", nullable = false)
	private Feed feed;
	
	protected FeedEntry()
	{
	}
	
	public FeedEntry(Feed feed, String content, Timestamp timestamp)
	{
		this.content = content;
		this.feed = feed;
		this.timestamp = timestamp;
	}
	
	public Long getId()
	{
		return id;
	}
	
	public  String GetContent()
	{
		return content;
	}
	
	public Timestamp GetTimestamp()
	{
		return timestamp;
	}
	
	public void SetContent(String content)
	{
		this.content=content;
	}
	
	public void SetTimestamp(Timestamp timestamp)
	{
		this.timestamp=timestamp;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}
}
 
