package fr.nathalieSpring.addressBook.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.nathalieSpring.addressBook.services.ContactInfoService;

public class UniqueEmailValidator
	implements ConstraintValidator<UniqueEmail, String> {

    private final ContactInfoService userService;

    public UniqueEmailValidator(ContactInfoService userService) {
	super();
	this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
	if (email == null || email.isEmpty()) {
	    return true;
	}
	return userService.emailUnique(email);
    }
}
