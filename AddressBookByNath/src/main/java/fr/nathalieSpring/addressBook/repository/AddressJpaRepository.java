package fr.nathalieSpring.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.nathalieSpring.addressBook.entities.Address;

@SuppressWarnings("javadoc")
public interface AddressJpaRepository extends JpaRepository<Address, Long> {

    @Modifying
    @Query("DELETE FROM Address")
    // Modifiying : Indicates a query method should be considered as modifying
    // query as that changes the way it needs to be executed
    // include INSERT, UPDATE, DELETE
  
    void removeAll();
}
