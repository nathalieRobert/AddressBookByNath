package fr.nathalieSpring.addressBook.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;

/**
 * This class, create an unique ID
 * 
 * @author Nathalie
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractAddress  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public AbstractAddress() {
	super();
	
    }

    public Long getId() {
	return Id;
    }

    public void setId(Long id) {
	Id = id;
    }
}
