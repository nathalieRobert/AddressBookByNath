package fr.nathalieSpring.addressBook.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.nathalieSpring.addressBook.entities.City;

public class CreateAddressDto {

    @NotNull
    @Size(max = 38)
    private String receiver;

    @NotNull
    @Size(max = 38)
    private String deliveryPoint;

    @NotNull
    @Size(max = 38)
    private String road;

    @NotNull
    @Size(max = 38)
    private String distributionService;

    @NotNull
    public City city;

    public String getReceiver() {
	return receiver;
    }

    public void setReceiver(String receiver) {
	this.receiver = receiver;
    }

    public String getDeliveryPoint() {
	return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
	this.deliveryPoint = deliveryPoint;
    }

    public String getRoad() {
	return road;
    }

    public void setRoad(String road) {
	this.road = road;
    }

    public String getDistributionService() {
	return distributionService;
    }

    public void setDistributionService(String distributionService) {
	this.distributionService = distributionService;
    }

    public CreateAddressDto() {
	super();
    }

    @Override
    public String toString() {
	return "CreateAddressDto [receiver=" + receiver + ", deliveryPoint="
		+ deliveryPoint + ", road=" + road + ", distributionService="
		+ distributionService + ", city=" + city + "]";
    }
}
