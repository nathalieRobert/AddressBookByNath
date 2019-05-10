package fr.nathalieSpring.addressBook.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.nathalieSpring.addressBook.dtos.SearchCityByZipCodeDto;
import fr.nathalieSpring.addressBook.entities.City;

@SuppressWarnings("javadoc")
public interface CityJpaRepository extends JpaRepository<City, Long> {

    // Modifiying : Indicates a query method should be considered as modifying
    // query as that changes the way it needs to be executed
    // include INSERT, UPDATE, DELETE
    @Modifying
    @Query("DELETE FROM City")
    void removeAll();

    @Query("SELECT new fr.nathalieSpring.addressBook.dtos.SearchCityByZipCodeDto(id,cityName) FROM City WHERE zipCode= ?1")
    List<SearchCityByZipCodeDto> findByZipCode(String zipCode);
}
