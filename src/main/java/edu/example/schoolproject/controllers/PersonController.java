package edu.example.schoolproject.controllers;

import java.util.Collection;
import java.util.Map;

import edu.example.schoolproject.model.Klassenbuch;
import edu.example.schoolproject.repository.KlassenbuchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    /*@Autowired
    private KlassenbuchRepository klassenbuchRepo;*/

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getPeople(@RequestParam Map<String,String> requestParams) {
        String search=requestParams.get("search");
        if(search!=null&&!search.equals("")) {
            return new ResponseEntity<>(personRepo.findByUsernameIgnoreCaseContaining(search), HttpStatus.OK);
        }
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        long id = person.getId();
        Person person1 = personRepo.getById(id);
        if(person1==null) {
            return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
        }else {
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
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        long id = person.getId();
        Person person1 = personRepo.getById(id);
        if(person1==null) {
            return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
        }else {
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
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable String username) {
        Person byUsername = personRepo.findByUsername(username);

        personRepo.delete(byUsername);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
