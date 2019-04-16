package fr.nathalieSpring.addressBook.exceptions;


public class InvalidFileNameException extends RuntimeException {
    
 public InvalidFileNameException(String error, Throwable why) {
	super( error, why);
    }
    
    
}
