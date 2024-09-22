package com.example.blog.controller;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.dto.PostCommentResponseDto;
import com.example.blog.entity.CommentEntity;
import com.example.blog.entity.PostEntity;
import com.example.blog.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {
	
	private BlogService blogService;
	BlogController(BlogService blogService)
	{
		this.blogService=blogService;
	}
	@PostMapping("/posts")
	public ResponseEntity<String> addPost(@RequestBody PostEntity post)
	{
		return new ResponseEntity<String>(blogService.createBlogPost(post),HttpStatus.CREATED);
	}
	@PostMapping("/posts/{id}/comment")
	public ResponseEntity<String> addPost(@PathVariable("id")int id,@RequestBody CommentEntity comment)
	{
		return new ResponseEntity<String>(blogService.addComment(id,comment),HttpStatus.CREATED);
	}
	@GetMapping("/posts/{id}/comments")
	public ResponseEntity<PostCommentResponseDto> addPost(@PathVariable("id")int id)
	{
		return new ResponseEntity<PostCommentResponseDto>(blogService.getComments(id),HttpStatus.OK);
	}

}
