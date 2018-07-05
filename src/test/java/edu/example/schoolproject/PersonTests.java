
package edu.example.schoolproject;

import edu.example.schoolproject.repository.PersonRepository;
import edu.example.schoolproject.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import edu.example.schoolproject.controllers.*;
import edu.example.schoolproject.model.*;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTests {

    @Autowired
    PersonController pc;

    @Autowired
    PersonRepository personRepo;

    @Autowired
    UserRepository userRepository;

    private Person person1;
    private Person person2;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("asdfjkl");
        user.setPassword("qwrt");
        userRepository.save(user);
        userRepository.flush();
        User one = userRepository.getOne(user.getId());
        person1 = new Person();
        person1.setId(1);
        person1.setName("Klaus Kleber");
        person1.setUsername("asdfjkl");
        person1.setDate(new java.sql.Date(1999));
        person1.setAddress("Lebertranweg 4");
        person1.setTown("Kleinbüttlingen");
        person1.setPostal_code("12345");
        pc.addPerson(person1);
    }

    @Test
    public void getPeopleTest() {
        ResponseEntity<Collection<Person>> prsn = pc.getPeople();
    }

    @Test
    public void getPersonTest() {

    }

    @Test
    public void addPersonTest() {
        person2 = new Person();
        personRepo.save( person2 );
    }

    @After
    public void tearDown() throws Exception {
        userRepository.delete(user);
        pc.deletePerson(person1.getId());
    }

}
