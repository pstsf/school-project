package edu.example.schoolproject.controllers;

import edu.example.schoolproject.model.MissingAttendance;
import edu.example.schoolproject.repository.MissingAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping( "/not_attendance" )
public class MissingAttendanceController {
    @Autowired
    private MissingAttendanceRepository missingAttendanceRepo;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<MissingAttendance> getMissingAttendance(@PathVariable long id )
    {
        final Optional<MissingAttendance> missingAttendanceOptional = missingAttendanceRepo.findById( id );

        if ( missingAttendanceOptional.isPresent() )
        {
            return new ResponseEntity<>( missingAttendanceOptional.get(), HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<?> addMissingAttendance( @RequestBody MissingAttendance missingAttendance )
    {
        return new ResponseEntity<>( missingAttendanceRepo.save( missingAttendance ), HttpStatus.CREATED );
    }
}
