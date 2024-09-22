package com.example.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
