package fr.nathalieSpring.addressBook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * this class represents an address
 * 
 * @author Nathalie
 */

@Entity
public class Address extends AbstractAddress {

    private static final long serialVersionUID = -6987753756672704493L;

    @Column(length = 38, nullable = false)
    private String receiver;

    @Column(length = 38)
    private String deliveryPoint;

    @Column(length = 38, nullable = false)
    private String road;

    @Column(length = 38)
    private String distributionService;

    @ManyToOne
    @NotNull
    public City city;

    public Address() {
	super();
    }

    @Override
    public String toString() {
	return "Address [receiver=" + receiver + ", deliveryPoint="
		+ deliveryPoint + ", road=" + road + ", distributionService="
		+ distributionService + ", city=" + city + "]";
    }

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
}
