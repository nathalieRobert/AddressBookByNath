package fr.nathalieSpring.addressBook.dtos;

public class SearchCityByZipCodeDto {

    private Long id;

    private String cityName;

    public SearchCityByZipCodeDto(Long id, String cityName) {
	super();
	this.id = id;
	this.cityName = cityName;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCityName() {
	return cityName;
    }

    public void setCityName(String cityName) {
	this.cityName = cityName;
    }
}
