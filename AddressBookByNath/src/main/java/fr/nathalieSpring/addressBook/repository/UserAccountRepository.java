package fr.nathalieSpring.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nathalieSpring.addressBook.entities.UserAccount;

public interface UserAccountRepository
	extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
