package fr.nathalieSpring.addressBook.servicesImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.nathalieSpring.addressBook.entities.Address;
import fr.nathalieSpring.addressBook.exceptions.InvalidFileNameException;
import fr.nathalieSpring.addressBook.repository.AddressJpaRepository;
import fr.nathalieSpring.addressBook.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    AddressJpaRepository addressRepository;

    @Value("${file.csv}")
    public String url;

    public AddressServiceImpl(AddressJpaRepository addressRepository) {
	super();
	this.addressRepository = addressRepository;
    }

    // method to use and read a CSV file
    @Override
    public List<Address> parse() {
	List<Address> address = new ArrayList<>();
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
			    address.add(new Address(city, zipCode));
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
	return address;
    }

    /**
     * this method consist in remove all data and then save new data with parse()
     */
    @Override
    @Transactional
    public void loading() {
	addressRepository.removeAll();
	addressRepository.saveAll(parse());
    }
}
