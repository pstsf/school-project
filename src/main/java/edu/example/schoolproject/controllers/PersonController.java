package edu.example.schoolproject.controllers;

import java.util.Collection;

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
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getPeople() {
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable String username) {
        final Person personOptional = personRepo.findByUsername(username);

        if (null != personOptional) {
            return new ResponseEntity<>(personOptional, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        long id = person.getId();
        Person person1 = personRepo.getById(id);
        person1.setPostalCode(person.getPostalCode());
        person1.setTown(person.getTown());
        person1.setAddress(person.getAddress());
        person1.setDate(person.getDate());
        person1.setUsername(person.getUsername());
        person1.setUser(person.getUser());
        person1.setName(person.getName());
        person1.setBirthDate(person.getBirthDate());
        return new ResponseEntity<>(personRepo.save(person1), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable String username) {
        Person byUsername = personRepo.findByUsername(username);

        personRepo.delete(byUsername);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
