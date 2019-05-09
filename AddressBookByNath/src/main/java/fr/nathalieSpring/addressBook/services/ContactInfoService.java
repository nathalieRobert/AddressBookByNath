package fr.nathalieSpring.addressBook.services;

import javax.validation.Valid;

import fr.nathalieSpring.addressBook.dtos.CreateContactInfoDto;

public interface ContactInfoService {

    void createContact(@Valid CreateContactInfoDto contactDto);

    boolean emailUnique(String email);

    void deleteContact(Long id);

    CreateContactInfoDto getContact(String firstname, String lastname);
}
