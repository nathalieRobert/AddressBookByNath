package fr.nathalieSpring.addressBook.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
import fr.nathalieSpring.addressBook.entities.Address;
import fr.nathalieSpring.addressBook.repository.AddressJpaRepository;
import fr.nathalieSpring.addressBook.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    AddressJpaRepository addressRepository;



    @Override
    public void createAddress(CreateAddressDto addressDto) {
	Address address = mapper.map(addressDto, Address.class);
	addressRepository.save(address);
    }
}
