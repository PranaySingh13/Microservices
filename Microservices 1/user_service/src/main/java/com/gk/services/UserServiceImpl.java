package com.gk.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gk.entity.User;

@Service
public class UserServiceImpl implements UserService {

	// fake user list
	List<User> list = List.of(new User(100L, "Pranay Singh", "9988776655"), new User(110L, "Dipti Singh", "9988776644"),
			new User(130L, "Apoorva Singh", "9988776633"));

	@Override
	public User getUser(Long id) {
		User userResult = list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
		return userResult;
	}

}
