package com.webtoeic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "article")
public class Article {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
   
    @Column(columnDefinition = "TEXT")
    private String content;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String url;

	public Article() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public Article(Long id, String title, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Article(String title, String author, String content) {
		super();
		this.title = title;
		this.content = content;
	}
    
    
	
}
