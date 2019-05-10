package fr.nathalieSpring.addressBook.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
import fr.nathalieSpring.addressBook.services.AddressService;

@RestController
@CrossOrigin("*")
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
	super();
	this.addressService = addressService;
    }

    @PostMapping
    protected void createAddress(
	    @Valid @RequestBody CreateAddressDto addressDto) {
	addressService.createAddress(addressDto);
    }
    
    protected void deleteAddressById(@PathVariable(value = "id", required = true) Long id) {
	addressService.deleteAddress(id);
    }
}
