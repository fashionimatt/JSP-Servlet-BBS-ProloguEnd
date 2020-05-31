package com.pe.dao;

import java.sql.Timestamp;

public class Notice {
	private int id;
	private String title;
	private Timestamp regdate;
	private String author;
	private int cnt;
	private String content;
	private String files;
	
	public Notice() {
	}
	
	public Notice(int id, String title, String author, int cnt, String content, String files, Timestamp regdate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.cnt = cnt;
		this.content = content;
		this.files = files;
		this.regdate = regdate;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", author=" + author + ", cnt=" + cnt
				+ ", content=" + content + ", files=" + files + ", regdate=" + regdate + "]";
	}
	
}
