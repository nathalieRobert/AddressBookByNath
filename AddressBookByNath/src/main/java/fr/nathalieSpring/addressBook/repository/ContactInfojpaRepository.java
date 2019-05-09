package fr.nathalieSpring.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.nathalieSpring.addressBook.dtos.CreateContactInfoDto;
import fr.nathalieSpring.addressBook.entities.ContactInfo;

public interface ContactInfojpaRepository
	extends JpaRepository<ContactInfo, Long> {

    boolean existsByEmailIgnoreCase(String email);

    @Query("select a from ContactInfo where a.firstname = :firstname and a.lastname = :lastname")
    CreateContactInfoDto findByCriteria(@Param("firstname") String firstname,
	    @Param("lastname") String lastname);
}
