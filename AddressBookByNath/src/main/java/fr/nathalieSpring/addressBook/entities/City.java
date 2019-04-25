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

    @Column(length = 10, nullable = false)
    private String ZipCode;

    // getters and setters
    public String getCity() {
	return cityName;
    }

    public void setCity(String city) {
	this.cityName = city;
    }

    public String getZipCode() {
	return ZipCode;
    }

    public void setZipCode(String zipCode) {
	ZipCode = zipCode;
    }

    @Override
    public String toString() {
	return "Address [city=" + cityName + ", ZipCode=" + ZipCode + "]";
    }

    public City(String cityName, String zipCode) {
	super();
	this.cityName = cityName;
	ZipCode = zipCode;
    }
}
