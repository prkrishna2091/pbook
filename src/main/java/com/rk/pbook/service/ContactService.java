package com.rk.pbook.service;

import com.rk.pbook.entity.Contact;
import com.rk.pbook.errors.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    public Contact saveContact(Contact contact);

    public List<Contact> fetchContacts();

    public Optional<Contact> fetchContactById(Integer id);

    public List<Contact> fetchContactsByGender(Character gender);

    public List<Contact> fetchContactsByCountry(String country);

    public Contact updateContact(Contact contact);

    public void deleteContact(Integer id) throws ResourceNotFoundException;

}
