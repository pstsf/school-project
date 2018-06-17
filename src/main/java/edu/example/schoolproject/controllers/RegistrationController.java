package edu.example.schoolproject.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.example.schoolproject.model.User;
import edu.example.schoolproject.transfer.UserData;

@RestController
public class RegistrationController {

    @RequestMapping(method = RequestMethod.POST,
        value = "/register",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public UserData register( @RequestBody User user) {

        return new UserData().setUser( user );
    }

    @ExceptionHandler
    void handleIllegalArgumentException(
        IllegalArgumentException e,
        HttpServletResponse response) throws IOException
    {

        response.sendError( HttpStatus.BAD_REQUEST.value());

    }
}
