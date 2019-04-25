package fr.nathalieSpring.addressBook.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import fr.nathalieSpring.addressBook.entities.City;

@SuppressWarnings("javadoc")
public interface CityJpaRepository extends JpaRepository<City, Long> {

    @Modifying
    @Query("DELETE FROM City")
    // Modifiying : Indicates a query method should be considered as modifying
    // query as that changes the way it needs to be executed
    // include INSERT, UPDATE, DELETE
  
    void removeAll();

   

   
}
