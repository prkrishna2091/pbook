package com.rk.pbook.repo;

import com.rk.pbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    public List<Contact> findByGender(Character gender);

    public List<Contact> findByCountry(String country);




}
