package com.example.blog.service;

import java.util.List;

import com.example.blog.dto.PostCommentResponseDto;
import com.example.blog.entity.CommentEntity;
import com.example.blog.entity.PostEntity;

public interface BlogService {
	
	public String createBlogPost(PostEntity post);
	
	public String addComment(int id,CommentEntity comment);
	
	public PostCommentResponseDto getComments(int id);

}
