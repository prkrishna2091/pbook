package com.rk.pbook.service.impl;

import com.rk.pbook.entity.Contact;
import com.rk.pbook.errors.ResourceNotFoundException;
import com.rk.pbook.repo.ContactRepository;
import com.rk.pbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {


    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository=contactRepository;
    }
    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> fetchContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> fetchContactById(Integer id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> fetchContactsByGender(Character gender) {
        return contactRepository.findByGender(gender);
    }

    @Override
    public List<Contact> fetchContactsByCountry(String country) {
        return contactRepository.findByCountry(country);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Integer id) throws ResourceNotFoundException {
        Optional<Contact> contact = contactRepository.findById(id);

        if(contact.isPresent())
            contactRepository.deleteById(Math.toIntExact(contact.get().getId()));
        else
            throw new ResourceNotFoundException("contact is not found.please provide valid id");

    }

}
