package com.rk.pbook.util;

import com.rk.pbook.entity.Contact;
import com.rk.pbook.modal.ContactDTO;

public class EntityDTOMapper {

    private EntityDTOMapper(){

    }
    public static Contact convertContactDTOtoEntity(ContactDTO contactDTO){
               Contact contact = new Contact();
               contact.setAge(Integer.valueOf(contactDTO.getAge()));
               contact.setCity(contactDTO.getCity());
               contact.setState(contactDTO.getState());
               contact.setCountry(contactDTO.getCountry());
               contact.setEmail(contactDTO.getEmail());
               contact.setGender(contactDTO.getGender().charAt(0));
               contact.setFirstname(contactDTO.getFirstname());
               contact.setLastname(contactDTO.getLastname());
               contact.setMobile(Long.valueOf(contactDTO.getMobile()));

               return contact;
    }

    public static ContactDTO convertContactEntitytoDTO(Contact contact){
                    ContactDTO contactDTO = new ContactDTO();
                    contactDTO.setAge(String.valueOf(contact.getAge()));
                    contactDTO.setCity(contact.getCity());
                    contactDTO.setState(contact.getState());
                    contactDTO.setCountry(contact.getCountry());
                    contactDTO.setEmail(contact.getEmail());
                    contactDTO.setGender(String.valueOf(contact.getGender()));
                    contactDTO.setFirstname(contact.getFirstname());
                    contactDTO.setLastname(contact.getLastname());
                    contactDTO.setMobile(String.valueOf(contact.getMobile()));

                    return contactDTO;
    }
}
