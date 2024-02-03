package com.rk.pbook.controllers;

import com.rk.pbook.entity.Contact;
import com.rk.pbook.errors.ResourceNotFoundException;
import com.rk.pbook.modal.ContactDTO;
import com.rk.pbook.service.ContactService;
import com.rk.pbook.util.EntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pbook")
public class PBookController {


    private final ContactService contactService;

    @Autowired
    public PBookController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping("/save/contact")
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contactDTO) {
        Contact contact = EntityDTOMapper.convertContactDTOtoEntity(contactDTO);

        Contact savedContact = contactService.saveContact(contact);
        ContactDTO response = EntityDTOMapper.convertContactEntitytoDTO(savedContact);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/contact/all")
    public ResponseEntity<List<ContactDTO>> findAll(){
        List<Contact> contactList = contactService.fetchContacts();
        List<ContactDTO> contactDTOS = contactList.stream().parallel().map(EntityDTOMapper::convertContactEntitytoDTO).toList();
        return new ResponseEntity<>(contactDTOS, HttpStatus.FOUND);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<ContactDTO> findContactById(@PathVariable Integer id) throws ResourceNotFoundException {
        Optional<Contact> contact = contactService.fetchContactById(id);
        if(contact.isPresent()){
            ContactDTO contactDTO = EntityDTOMapper.convertContactEntitytoDTO(contact.get());
            return new ResponseEntity<>(contactDTO, HttpStatus.FOUND);
        }else {
            throw new ResourceNotFoundException("Contact is not Found. please provide valid id.");
        }

    }

    @GetMapping("/contact/{gender}")
    public ResponseEntity<List<ContactDTO>> findContactByGender(@PathVariable Character gender){
        List<Contact> contacts = contactService.fetchContactsByGender(gender);
        List<ContactDTO> contactDTOS = contacts.stream().parallel().map(EntityDTOMapper::convertContactEntitytoDTO).toList();
        return new ResponseEntity<>(contactDTOS, HttpStatus.FOUND);
    }

    @GetMapping("/contact/{country}")
    public ResponseEntity<List<ContactDTO>> findContactByCountry(@PathVariable  String country) {
        List<Contact> contacts = contactService.fetchContactsByCountry(country);
        List<ContactDTO> contactDTOS = contacts.stream().parallel().map(EntityDTOMapper::convertContactEntitytoDTO).toList();
        return new ResponseEntity<>(contactDTOS, HttpStatus.FOUND);
    }

    @PutMapping("/contact/update")
    public ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO contactDTO){
        Contact contact = EntityDTOMapper.convertContactDTOtoEntity(contactDTO);
        Contact contactEntity = contactService.updateContact(contact);
        ContactDTO response = EntityDTOMapper.convertContactEntitytoDTO(contactEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer id) throws ResourceNotFoundException {
        contactService.deleteContact(id);
        return new ResponseEntity<>("contact is deleted", HttpStatus.OK);
    }
}
