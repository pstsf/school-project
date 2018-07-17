package edu.example.schoolproject.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import edu.example.schoolproject.model.Person;

@Repository
public interface PersonRepository
    extends CrudRepository<Person, Long>
{
	
	Collection<Person> findAll();

	Person findByUsername( String username );

	Collection<Person> findByUsernameIgnoreCaseContaining( String username );

	Person getById( long id );

}
