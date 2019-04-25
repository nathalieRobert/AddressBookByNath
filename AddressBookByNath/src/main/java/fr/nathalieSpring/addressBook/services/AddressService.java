package fr.nathalieSpring.addressBook.services;

import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;

public interface AddressService {


    void createAddress(CreateAddressDto dto);
    
}
