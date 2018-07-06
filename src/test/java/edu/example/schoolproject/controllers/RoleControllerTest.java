package edu.example.schoolproject.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import edu.example.schoolproject.model.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {

    @Autowired
    RoleController rc;

    @Test
    public void getRolesTest() {
        ResponseEntity<Collection<Role>> rl = rc.getRoles();
    }

    @Test
    public void getRoleTest() {
    }

    @Test
    public void addRoleTest() {
    }

    @Test
    public void deleteRoleTest() {
    }
}
