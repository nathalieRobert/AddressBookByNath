package fr.nathalieSpring.addressBook.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.nathalieSpring.addressBook.dtos.CreateContactInfoDto;
import fr.nathalieSpring.addressBook.entities.ContactInfo;
import fr.nathalieSpring.addressBook.services.ContactInfoService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactInfoController {

    private final ContactInfoService contactService;

    public ContactInfoController(ContactInfoService contactService) {
	super();
	this.contactService = contactService;
    }

    @PostMapping("/create")
    public void createContact(
	    @Valid @RequestBody CreateContactInfoDto contactDto) {
	contactService.createContact(contactDto);
    }

    @GetMapping("/get/{firstname}/{lastname}")
    protected Object getContactInfo(@PathVariable("firstname") String firstname,
	    @PathVariable("lastname") String lastname) {
	return contactService.getContact(firstname, lastname);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
	contactService.deleteContact(id);
    }
    
    /**
     * Endpoint to paginate the contacts
     * @param page 
     * 		<URL>?page= <URL>
     * @return 20 contacts per page 
     */
    @GetMapping
    protected Page<ContactInfo> getContactPagination(@RequestParam(value = "page", required = true) Integer page) {
	return contactService.getContactPagination(page);
	
    }
}
