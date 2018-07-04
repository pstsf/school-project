package edu.example.schoolproject.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.repository.PersonRepository;

@RestController
@RequestMapping( "/person" )
public class PersonController
{

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<Person>> getPeople()
    {
        return new ResponseEntity<>( personRepo.findAll(), HttpStatus.OK );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<Person> getPerson( @PathVariable long id )
    {
        final Optional<Person> personOptional = personRepo.findById( id );

        if ( personOptional.isPresent() )
        {
            return new ResponseEntity<>( personOptional.get(), HttpStatus.OK );
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
