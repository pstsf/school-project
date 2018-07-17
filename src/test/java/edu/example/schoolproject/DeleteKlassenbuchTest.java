package edu.example.schoolproject;

import edu.example.schoolproject.controllers.KlassenbuchController;
import edu.example.schoolproject.controllers.PersonController;
import edu.example.schoolproject.controllers.UserController;
import edu.example.schoolproject.model.Klassenbuch;
import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.model.User;
import edu.example.schoolproject.repository.PersonRepository;
import edu.example.schoolproject.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteKlassenbuchTest {

    @Autowired
    UserController uc;

    @Autowired
    PersonController pc;

    @Autowired
    KlassenbuchController kbc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;


    private Person person1 = new Person();
    private Klassenbuch kbI = new Klassenbuch();
    private User user = new User();

    @Before
    @Transactional
    public void setUp() throws Exception {
        final String username = "asdfjkl";

        person1.setName( "Klaus Kleber" );
        person1.setUsername( username );
        person1.setDate( new java.sql.Date( 1999 ) );
        person1.setAddress( "Lebertranweg 4" );
        person1.setTown( "Kleinbüttlingen" );
        person1.setPostalCode( "12345" );
        personRepository.save( person1 );

        user.setUsername( username );
        user.setPassword( "qwrt" );
        user.setPerson( person1 );
        userRepository.save( user );
        //person1.setUser( user );

        //kbI.setOwner_id(person1.getId());
        kbc.addKlassenbuch(kbI);
    }

    @Test
    public void deleteKlassenbuchTest() {
        ResponseEntity<Void> del3 = kbc.deleteKlassenbuch(kbI.getId());
    }

    @After
    @Transactional
    public void tearDown() throws Exception {
        ResponseEntity<Void> del1 = uc.deleteUser(user.getId());
        ResponseEntity<Void> del2 = pc.deletePerson(person1.getUsername());
    }
}
