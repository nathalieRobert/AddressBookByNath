package fr.nathalieSpring.addressBook.servicesImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.nathalieSpring.addressBook.dtos.CreateAddressDto;
import fr.nathalieSpring.addressBook.entities.Address;
import fr.nathalieSpring.addressBook.entities.City;
import fr.nathalieSpring.addressBook.exceptions.InvalidFileNameException;
import fr.nathalieSpring.addressBook.repository.CityJpaRepository;
import fr.nathalieSpring.addressBook.services.CityService;

@Service
public class CityServiceImpl implements CityService {

    CityJpaRepository cityRepository;

    @Value("${file.csv}")
    public String url;

    public CityServiceImpl(CityJpaRepository cityRepository) {
	super();
	this.cityRepository = cityRepository;
    }

    // method to use and read a CSV file
    @Override
    public List<City> parse() {
	List<City> cities = new ArrayList<>();
	try (BufferedReader text = new BufferedReader(new FileReader(url))) {
	    String line;
	    while ((line = text.readLine()) != null) {
		String values[] = line.split(";");
		String zipCode = null;
		String city = null;
		for (int i = 0; i < values.length; i++) {
		    if (i == 1) {
			if (values[i].equals("Nom_commune")) {
			    break;
			}
			city = values[i];
		    } else if (i == 2) {
			zipCode = values[i];
		    } else {
			if (i == 3) {
			    cities.add(new City(city, zipCode));
			}
		    }
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	    if ("".equals(url) || url != "src/main/resources/poste.csv") {
		throw new InvalidFileNameException("File not found!", e);
	    }
	}
	return cities;
    }

    /**
     * this method consist in removing and saving data
     */
    @Override
    @Transactional
    public void loading() {
	cityRepository.removeAll();
	cityRepository.saveAll(parse());
    }
}
