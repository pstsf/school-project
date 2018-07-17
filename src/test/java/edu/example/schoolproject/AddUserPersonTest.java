package edu.example.schoolproject;

import javax.transaction.Transactional;

import edu.example.schoolproject.controllers.UserController;
import org.junit.Assert;
import org.junit.After;
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

@RunWith( SpringRunner.class )
@SpringBootTest
public class AddUserPersonTest
{

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

    Person person1 = new Person();

    @Test
    @Transactional
    public void addPersonTest()
    {
        final String username = "asdfjkl";

        person1.setName( "Klaus Kleber" );
        person1.setUsername( username );
        person1.setDate( new java.sql.Date( 1999 ) );
        person1.setAddress( "Lebertranweg 4" );
        person1.setTown( "Kleinbüttlingen" );
        person1.setPostalCode( "12345" );
        pc.addPerson( person1 );

        User user = new User();
        user.setUsername( username );
        user.setPassword( "qwrt" );
        user.setPerson( person1 );
        uc.addUser( user );
        //person1.setUser( user );
        final User theOneUser = userRepository.getOne( user.getId() );
        final Person theOnePerson = personRepository.findByUsername( username );
        //Assert.assertEquals( theOneUser.getId(), theOnePerson.getUser()
          //                                                   .getId() );
        Assert.assertEquals( theOnePerson.getId(), theOneUser.getPerson()
                                                             .getId() );
    }

    @After
    @Transactional
    public void tearDown() {
        //ResponseEntity<Void> del1 = uc.deleteUser( person1.getUser().getId() );
        ResponseEntity<Void> del2 = pc.deletePerson( person1.getUsername() );
    }
}
