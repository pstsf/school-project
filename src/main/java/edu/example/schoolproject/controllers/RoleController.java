package edu.example.schoolproject.controllers;


import edu.example.schoolproject.model.Role;
import edu.example.schoolproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping
public class RoleController {
    @Autowired
    private RoleRepository roleRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<Role>> getRoles()
    {
        return new ResponseEntity<>( roleRepo.findAll(), HttpStatus.OK );
    }


    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<Role> getRole( @PathVariable long id )
    {
        final Optional<Role> roleOptional = roleRepo.findById( id );

        if ( roleOptional.isPresent() )
        {
            return new ResponseEntity<>( roleOptional.get(), HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<?> addRole( @RequestBody Role role )
    {
        return new ResponseEntity<>( roleRepo.save( role ), HttpStatus.CREATED );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> deleteRole( @PathVariable long id, Principal principal )
    {
        Role currentRole = roleRepo.findByName( principal.getName() );

        if ( currentRole.getId() == id )
        {
            roleRepo.deleteById( id );
            return new ResponseEntity<Void>( HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<Void>( HttpStatus.UNAUTHORIZED );
        }
    }

}