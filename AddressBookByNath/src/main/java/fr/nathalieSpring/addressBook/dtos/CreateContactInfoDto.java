package fr.nathalieSpring.addressBook.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @Size(min = 1, max = 12)
    private String phoneNumber;

    @NotBlank
    @Size(min = 5, max = 255)
    @UniqueEmail
    private String email;

    
    private Long cityId;

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

    public Long getCityId() {
	return cityId;
    }

    public void setCityId(Long cityId) {
	this.cityId = cityId;
    }

    @Override
    public String toString() {
	return "CreateContactInfoDto [firstname=" + firstname + ", lastname="
		+ lastname + ", phoneNumber=" + phoneNumber + ", email=" + email
		+ ", cityId=" + cityId + "]";
    }
}
