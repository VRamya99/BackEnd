package com.example.blog.dto;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private int id;

	private int authorId;
	
	private String content;

	private LocalDateTime createdAt;

	public CommentResponseDto(int authorId, String content, LocalDateTime createdAt) {
		super();
		this.authorId = authorId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public CommentResponseDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentResponseDto(int id, int authorId, String content, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
