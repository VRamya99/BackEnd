package com.example.blog.dto;

import java.util.List;



public class PostCommentResponseDto {
	
	private int post_id;
	List<CommentResponseDto> comments;
	public PostCommentResponseDto(List<CommentResponseDto> comments) {
		super();
		this.comments = comments;
	}
	public PostCommentResponseDto() {
		super();
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public List<CommentResponseDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentResponseDto> comments) {
		this.comments = comments;
	}
	public PostCommentResponseDto(int post_id, List<CommentResponseDto> comments) {
		super();
		this.post_id = post_id;
		this.comments = comments;
	}
	

}
