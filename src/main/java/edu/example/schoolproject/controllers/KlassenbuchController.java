package edu.example.schoolproject.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import edu.example.schoolproject.model.Klassenbuch;
import edu.example.schoolproject.repository.KlassenbuchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( "/klassenbuch" )
public class KlassenbuchController
{

    @Autowired
    private KlassenbuchRepository kbRepo;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Collection<Klassenbuch>> getKlassenbuecher()
    {
        return new ResponseEntity<>( kbRepo.findAll(), HttpStatus.OK );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<Klassenbuch> getKlassenbuch( @PathVariable long id )
    {
        final Optional<Klassenbuch> klassenbuchOptional = kbRepo.findById( id );

        if ( klassenbuchOptional.isPresent() )
        {
            return new ResponseEntity<>( klassenbuchOptional.get(), HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<?> addKlassenbuch( @RequestBody Klassenbuch klassenbuch )
    {
        return new ResponseEntity<>( kbRepo.save( klassenbuch ), HttpStatus.CREATED );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> deleteKlassenbuch( @PathVariable long id )
    {
        kbRepo.deleteById( id );
        return new ResponseEntity<Void>( HttpStatus.OK );
    }
}
