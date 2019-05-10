package fr.nathalieSpring.addressBook.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import fr.nathalieSpring.addressBook.dtos.CityDto;
import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
import fr.nathalieSpring.addressBook.dtos.SearchCityByZipCodeDto;
import fr.nathalieSpring.addressBook.entities.City;
import fr.nathalieSpring.addressBook.entities.ContactInfo;
import fr.nathalieSpring.addressBook.exceptions.InvalidFileNameException;

/**
 * this is an interface of Address Service
 * 
 * @author Nathalie
 */
public interface CityService {

    void loading();

    List<City> parse() throws InvalidFileNameException;

    List<SearchCityByZipCodeDto> findCityByZipCode(String zipCode);

    Page<City> getCitiesPagination(Integer page);



    
}
