package edu.example.schoolproject.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.repository.PersonRepository;

@RestController
@RequestMapping( "/people" )
public class PersonController
{

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<Person>> getPersonByNameAndAge(
        @RequestParam( value = "id", required = false ) Long id,
        @RequestParam( value = "name", required = false ) final String name,
        @RequestParam( value = "age", required = false ) Integer age )
    {
        if ( id == null && name == null && age == null )
        {
            return new ResponseEntity( personRepo.findAll(), HttpStatus.OK );
        }

        Collection<Person> person = personRepo.findByNameOrAgeOrId( name, age, id );

        if ( null != person )
        {
            return new ResponseEntity( person, HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<?> addPerson( @RequestBody Person person )
    {
        return new ResponseEntity<>( personRepo.save( person ), HttpStatus.CREATED );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> deletePerson( @PathVariable long id, Principal principal )
    {
        Person currentPerson = personRepo.findByUsername( principal.getName() );

        if ( currentPerson.getId() == id )
        {
            personRepo.deleteById( id );
            return new ResponseEntity<Void>( HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<Void>( HttpStatus.UNAUTHORIZED );
        }
    }
}
