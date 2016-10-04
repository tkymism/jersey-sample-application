package com.fujitsu.hope.labs.messages;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private Integer id;
	private String title;
	private String author;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}