package fr.nathalieSpring.addressBook.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CityDto {

    @NotBlank
    private String cityName;

    @NotNull
    private String zipCode;

    public CityDto() {
	super();
    }

    @Override
    public String toString() {
	return "CityDto [cityName=" + cityName + ", zipCode=" + zipCode + "]";
    }

    
    public String getCityName() {
        return cityName;
    }

    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    
    public String getZipCode() {
        return zipCode;
    }

    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
