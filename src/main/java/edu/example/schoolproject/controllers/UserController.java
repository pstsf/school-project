package edu.example.schoolproject.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import edu.example.schoolproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.repository.UserRepository;

@RestController
@RequestMapping( "/users" )
public class UserController
{

    @Autowired
    private UserRepository userRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<User>> getUser()
    {
        return new ResponseEntity( userRepo.findAll(), HttpStatus.OK );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<User> getUser( @PathVariable long id )
    {
        final Optional<User> userOptional = userRepo.findById( id );

        if ( userOptional.isPresent() )
        {
            return new ResponseEntity<>( userOptional.get(), HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<User> addUser( @RequestBody User user )
    {
        final String pass = user.getPassword();
        user.setPassword( encrypt(pass) );
        return new ResponseEntity<>( userRepo.save( user ), HttpStatus.CREATED );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> deleteUser( @PathVariable long id, Principal principal )
    {
        User currentUser = userRepo.findOneByUsername( principal.getName() );

        if ( currentUser.getId() == id )
        {
            userRepo.deleteById( id );
            return new ResponseEntity<>( HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED );
        }
    }

    public String encrypt(String pass) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String password = bCryptPasswordEncoder.encode(pass);
        return password;
    }
}
