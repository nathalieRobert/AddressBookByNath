package fr.nathalieSpring.addressBook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * this class represents a city, defined by its Id, name and zipcode.
 * 
 * @author Nathalie
 */
@Entity
public class City extends AbstractAddress {

    private static final long serialVersionUID = -7837054969575536149L;

    // Address'fields
    @Column(length = 100, nullable = false)
    private String cityName;

    @Column(length = 5, nullable = false)
    private String zipCode;

    // getters and setters
    public String getCity() {
	return cityName;
    }

    public void setCity(String city) {
	this.cityName = city;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	zipCode = zipCode;
    }

    @Override
    public String toString() {
	return "Locality [city=" + cityName + ", ZipCode=" + zipCode + "]";
    }

    public City(String cityName, String zipCode) {
	super();
	this.cityName = cityName;
	this.zipCode = zipCode;
    }
}
