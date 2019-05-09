package fr.nathalieSpring.addressBook.servicesImpl;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nathalieSpring.addressBook.dtos.CreateContactInfoDto;
import fr.nathalieSpring.addressBook.entities.ContactInfo;
import fr.nathalieSpring.addressBook.repository.ContactInfojpaRepository;
import fr.nathalieSpring.addressBook.services.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    @Autowired
    private ModelMapper mapper;

    private final ContactInfojpaRepository contactInfoRepo;

    public ContactInfoServiceImpl(ContactInfojpaRepository contactInfoRepo) {
	super();
	this.contactInfoRepo = contactInfoRepo;
    }

    @Override
    public void createContact(@Valid CreateContactInfoDto contactDto) {
	ContactInfo contact = mapper.map(contactDto, ContactInfo.class);
	contactInfoRepo.save(contact);
    }

    @Override
    public boolean emailUnique(String email) {
	return contactInfoRepo.existsByEmailIgnoreCase(email);
    }

    @Override
    public void deleteContact(Long id) {
	contactInfoRepo.deleteById(id);
    }

    @Override
    public CreateContactInfoDto getContact(String firstname, String lastname) {
	return contactInfoRepo.findByCriteria(firstname, lastname);
    }
}
