package com.example.user.service.impl;



import org.springframework.stereotype.Service;

import com.example.user.entity.UserEntity;
import com.example.user.exception.UserNotFoundException;
import com.example.user.repo.UserRepository;
import com.example.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository=userRepository;
		
	}

	@Override
	public String createUser(UserEntity user) {
		userRepository.save(user);
		return "new User created successsfully";
		
	}

	@Override
	public String updateUser(int id, UserEntity user) {
		UserEntity userDetails=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user is not found with id "+ id));
		if(user.getUsername()!=null)
		{
			userDetails.setUsername(user.getUsername());
		}
		if(user.getEmail()!=null)
		{
			userDetails.setEmail(user.getEmail());
		}
		userRepository.save(userDetails);
		return "User with Id "+id+" Details are updated";
		
	}

	@Override
	public UserEntity getUser(int id) {
		
		UserEntity user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" is not found"));
		return user;
		
		
		
	}

}
