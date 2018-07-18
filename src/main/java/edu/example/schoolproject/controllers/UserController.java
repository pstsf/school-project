package edu.example.schoolproject.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import edu.example.schoolproject.model.User;
import edu.example.schoolproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.repository.UserRepository;

@RestController
@RequestMapping( "/users" )
public class UserController
{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<User>> getUser(@RequestParam Map<String,String> requestParams)
    {
        String username=requestParams.get("username");
        if(username!=null&&!username.equals("")) {
            ArrayList<User> temp=new ArrayList<User>();
            if(userRepo.findOneByUsername(username)!=null) {
                temp.add(userRepo.findOneByUsername(username));
            }
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }

        String id=requestParams.get("id");
        if(id!=null&&!id.equals("")) {
            ArrayList<User> temp=new ArrayList<User>();
            if(userRepo.findById(Long.valueOf(id)).isPresent()) {
                temp.add(userRepo.findById(Long.valueOf(id)).get());
            }
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }

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
        Person person=personRepo.findByUsername(user.getUsername());

        user.setPerson(person);

        User output=userRepo.save( user );
        person.setUser(user);


        return new ResponseEntity<>( output, HttpStatus.CREATED );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> deleteUser( @PathVariable long id ) {
        userRepo.deleteById( id );
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam Map<String,String> requestParams) {
        String username=requestParams.get("username");
        if(username!=null&&!username.equals("")) {
            User byUsername = userRepo.findByUsername(username);

            userRepo.delete(byUsername);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    public String encrypt(String pass) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String password = bCryptPasswordEncoder.encode(pass);
        return password;
    }
}
