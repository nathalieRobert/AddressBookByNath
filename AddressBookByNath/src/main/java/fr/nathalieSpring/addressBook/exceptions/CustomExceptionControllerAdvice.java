package fr.nathalieSpring.addressBook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(InvalidFileNameException.class)
    public ResponseEntity<Object> invaliFiledNameException(InvalidFileNameException e){
	return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("File not found! Please, check your config");
    }
}
