package fr.nathalieSpring.addressBook.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import fr.nathalieSpring.addressBook.entities.City;
import fr.nathalieSpring.addressBook.validation.UniqueEmail;

public class CreateContactInfoDto {

    @NotBlank
    @Size(max = 100)
    private String firstname;

    @NotBlank
    @Size(max = 100)
    private String lastname;

    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotBlank
    @Size(min = 5, max = 255)
    @UniqueEmail
    private String email;

    @Valid
    private City city;

    public CreateContactInfoDto() {
	super();
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public City getCity() {
	return city;
    }

    public void setCity(City city) {
	this.city = city;
    }

    @Override
    public String toString() {
	return "CreateContactInfoDto [firstname=" + firstname + ", lastname="
		+ lastname + ", phoneNumber=" + phoneNumber + ", email=" + email
		+ ", city=" + city + "]";
    }
}
