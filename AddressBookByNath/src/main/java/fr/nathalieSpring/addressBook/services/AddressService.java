package fr.nathalieSpring.addressBook.services;

import java.util.List;

import fr.nathalieSpring.addressBook.entities.Address;
import fr.nathalieSpring.addressBook.exceptions.InvalidFileNameException;

/**
 * this is an interface of Address Service
 * @author Nathalie
 *
 */
public interface AddressService {

    void loading();

    List<Address> parse() throws InvalidFileNameException;

}
