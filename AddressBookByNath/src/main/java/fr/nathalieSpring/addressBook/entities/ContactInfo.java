package fr.nathalieSpring.addressBook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 10, nullable = true)
    private String phoneNumber;

    @Column(length = 255, nullable = true, unique = true)
    private String email;

    @ManyToOne
    private City city;

    public ContactInfo() {
	super();
    }

    public ContactInfo(Long id, String firstname, String lastname,
	    String phoneNumber, String email, City city) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.city = city;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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
	return "ContactInfo [id=" + id + ", firstname=" + firstname
		+ ", lastname=" + lastname + ", phoneNumber=" + phoneNumber
		+ ", email=" + email + ", city=" + city + "]";
    }
}
