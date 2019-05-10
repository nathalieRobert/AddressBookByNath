package fr.nathalieSpring.addressBook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.nathalieSpring.addressBook.dtos.CityDto;
import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
import fr.nathalieSpring.addressBook.dtos.SearchCityByZipCodeDto;
import fr.nathalieSpring.addressBook.entities.City;
import fr.nathalieSpring.addressBook.entities.ContactInfo;
import fr.nathalieSpring.addressBook.services.CityService;

/**
 * 
 * 
 * @author Nathalie
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(@RequestBody CityService cityService) {
	super();
	this.cityService = cityService;
    }

    @GetMapping("/loading")
    protected void loading() {
	cityService.loading();
    }
    
    /*
     * <URL> ?zipcode= </URL>
     */
    @GetMapping("/")
    protected List<SearchCityByZipCodeDto> findCityByZipCode(@RequestParam(value = "zipcode", required = true) String zipCode) {
	return cityService.findCityByZipCode(zipCode);
	
    }
    
    
    
    /*
     * Endpoint to paginate the cities
    * @param page 
    * 		<URL>?page= <URL>
    * @return 20 cities per page 
    * */
    @GetMapping
    protected Page<City> getCitiesPagination(@RequestParam(value = "page", required = true) Integer page) {
	return cityService.getCitiesPagination(page);
	
    }
    
  
  
}
