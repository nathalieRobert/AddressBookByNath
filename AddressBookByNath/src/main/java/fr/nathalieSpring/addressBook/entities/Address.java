package fr.nathalieSpring.addressBook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * this class represents an address, defined by its Id, city name and zipcode.
 * 
 * @author Nathalie
 */

@Entity
public class Address extends AbstractAddress {

    private static final long serialVersionUID = -7837054969575536149L;

    // Address'fields
    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 10, nullable = false)
    private String ZipCode;

    // getters and setters
    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getZipCode() {
	return ZipCode;
    }

    public void setZipCode(String zipCode) {
	ZipCode = zipCode;
    }

    // constructor using fields
    public Address(String city, String zipCode) {
	super();
	this.city = city;
	ZipCode = zipCode;
    }

    @Override
    public String toString() {
	return "Address [city=" + city + ", ZipCode=" + ZipCode + "]";
    }
}
