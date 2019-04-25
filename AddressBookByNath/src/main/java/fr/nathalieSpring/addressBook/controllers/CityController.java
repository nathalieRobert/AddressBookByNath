package fr.nathalieSpring.addressBook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nathalieSpring.addressBook.dtos.CityDto;
import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
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

    public CityController(CityService cityService) {
	super();
	this.cityService = cityService;
    }

    @GetMapping("/loading")
    protected void loading() {
	cityService.loading();
    }
    
  
}
