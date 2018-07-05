package edu.example.schoolproject;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.example.schoolproject.controllers.PersonController;
import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.model.User;
import edu.example.schoolproject.repository.PersonRepository;
import edu.example.schoolproject.repository.UserRepository;

@RunWith( SpringRunner.class )
@SpringBootTest
public class UserPersonTest
{

    @Autowired
    PersonController pc;

    @Autowired
    PersonRepository personRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    @Test
    @Transactional
    public void addPersonTest()
    {
        final String username = "asdfjkl";

        //User one = userRepository.getOne(user.getId());
        Person person1 = new Person();
        person1.setName( "Klaus Kleber" );
        person1.setUsername( username );
        person1.setDate( new java.sql.Date( 1999 ) );
        person1.setAddress( "Lebertranweg 4" );
        person1.setTown( "Kleinbüttlingen" );
        person1.setPostal_code( "12345" );
        personRepository.save( person1 );
        //pc.addPerson(person1);

        User user = new User();
        user.setUsername( username );
        user.setPassword( "qwrt" );
        user.setPerson( person1 );
        userRepository.save( user );
        person1.setUser( user );
        final User theOneUser = userRepository.getOne( user.getId() );
        final Person theOnePerson = personRepository.findByUsername( username );
        Assert.assertEquals( theOneUser.getId(), theOnePerson.getUser()
                                                             .getId() );
        Assert.assertEquals( theOnePerson.getId(), theOneUser.getPerson()
                                                             .getId() );
    }

}
