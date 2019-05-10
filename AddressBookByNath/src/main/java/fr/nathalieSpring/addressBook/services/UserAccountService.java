package fr.nathalieSpring.addressBook.services;

import fr.nathalieSpring.addressBook.dtos.UserAccountCreateDto;

public interface UserAccountService {

    void create(UserAccountCreateDto dto);

    void deleteById(Long id);
}
