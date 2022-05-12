package com.gk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gk.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	// fake list of contacts
	List<Contact> contacts = List.of(new Contact(1L, "pranay@gmail.com", "Pranay", 110L),
			new Contact(2L, "raja@gmail.com", "Raja", 110L), new Contact(3L, "dipti@gmail.com", "Dipti", 120L),
			new Contact(4L, "apoorva@gmail.com", "Apoorva", 130L));

	@Override
	public List<Contact> getContactsOfUser(Long userId) {

		return contacts.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
