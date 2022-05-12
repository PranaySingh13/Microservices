package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gk.entity.Contact;
import com.gk.entity.User;
import com.gk.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate template;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {

		User user = userService.getUser(userId);
		// http://localhost:9002/contact/user/{userId}
		List<Contact> contacts = template.getForObject("http://contact-service/contact/user/" + user.getUserId(),
				List.class);

		user.setContacts(contacts);
		return user;
	}
}
