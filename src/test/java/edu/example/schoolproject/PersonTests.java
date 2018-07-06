
package edu.example.schoolproject;

import java.util.Collection;

import edu.example.schoolproject.controllers.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import edu.example.schoolproject.controllers.PersonController;
import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.model.User;
import edu.example.schoolproject.repository.PersonRepository;
import edu.example.schoolproject.repository.UserRepository;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTests {

    @Autowired
    PersonController pc;

    @Autowired
    UserController uc;

    @Autowired
    PersonRepository personRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    private Person person1 = new Person();
    private Person person2 = new Person();
    private User user = new User();

    @Before
    public void setUp() throws Exception {
        final String username = "asdfjkl";

        person1.setUsername(username);
        personRepository.save( person1 );

        user.setUsername( username );
        user.setPassword( "qwrt" );
        user.setPerson( person1 );
        userRepository.save( user );
        person1.setUser( user );
    }

    @Test
    public void getPeopleTest() {
        ResponseEntity<Collection<Person>> prsn = pc.getPeople();
    }

    @Test
    public void getPersonTest() {
        ResponseEntity<Person> prsn = pc.getPerson( person1.getUsername() );
    }

    @Test
    public void updatePersonTest() {
        personRepo.save(person2);
        person2.setId(person1.getId());
        person2.setUsername((person1.getUsername()));
        person2.setUser(person1.getUser());
        pc.updatePerson(person2);
    }

    @After
    @Transactional
    public void tearDown() throws Exception {
        ResponseEntity<Void> del1 = uc.deleteUser(user.getId());
        ResponseEntity<Void> del2 = pc.deletePerson(person1.getUsername());
    }
}