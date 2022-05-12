package com.gk.service;

import java.util.List;

import com.gk.entity.Contact;

public interface ContactService {

	public List<Contact> getContactsOfUser(Long userId);

}
