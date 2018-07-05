package edu.example.schoolproject.controllers;

import edu.example.schoolproject.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void getUser() {
        ResponseEntity<Collection<User>> users = userController.getUser();
        Assert.assertEquals(3, users.getBody().size());
    }

    @Test
    public void getUser1() {
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(Long.valueOf(4));
        user.setUsername("Username");
        user.setPassword("pass");
        ResponseEntity<?> responseEntity = userController.addUser(user);

    }

    @Test
    public void deleteUser() {
        
    }

    @Test
    public void encrypt() {
    }
}