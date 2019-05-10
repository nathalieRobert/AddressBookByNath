package fr.nathalieSpring.addressBook.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nathalieSpring.addressBook.dtos.UserAccountCreateDto;
import fr.nathalieSpring.addressBook.services.UserAccountService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    
    private UserAccountService service;

    protected UserController(UserAccountService service) {
	this.service = service;
    }

    @PostMapping
    protected void create(@RequestBody UserAccountCreateDto dto) {
	service.create(dto);
    }
    
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    protected void deleteById(@PathVariable(value="id", required = true) Long id) {
	service.deleteById(id);
    }
}
