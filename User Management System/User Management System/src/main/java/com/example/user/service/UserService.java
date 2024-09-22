package com.example.user.service;

import com.example.user.entity.UserEntity;

public interface UserService {
	
	public String createUser(UserEntity user);
	
	public String updateUser(int id,UserEntity user);
	
	public UserEntity getUser(int id);

}
