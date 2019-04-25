package fr.nathalieSpring.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nathalieSpring.addressBook.entities.Address;


public interface AddressJpaRepository extends JpaRepository<Address, Long> {
}
