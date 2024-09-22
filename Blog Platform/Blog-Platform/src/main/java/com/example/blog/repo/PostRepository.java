package com.example.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
