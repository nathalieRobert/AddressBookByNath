package fr.nathalieSpring.addressBook.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import fr.nathalieSpring.addressBook.dtos.CreateContactInfoDto;
import fr.nathalieSpring.addressBook.entities.ContactInfo;

public interface ContactInfoService {

    void createContact(CreateContactInfoDto contactDto);

    boolean emailUnique(String email);

    void deleteContact(Long id);

    Object getContact(String firstname, String lastname);

    Page<ContactInfo> getContactPagination(Integer page);
}
