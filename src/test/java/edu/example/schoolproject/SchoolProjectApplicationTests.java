package edu.example.schoolproject;

import edu.example.schoolproject.controllers.UserController;
import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolProjectApplicationTests {

	@Autowired
	UserController uc;

	@Test
	public void getUserTest() {
		final ResponseEntity<Collection<User>> user = uc.getUser();
		Assert.assertEquals(200, user.getStatusCode());
	}

	@Test
	public void getUserByIdTest() {
		final ResponseEntity<User> user = uc.getUser (2);
		Assert.assertEquals(user.getStatusCode(), uc.getUser (2).getStatusCode());
	}

	@Test
	public void addUserTest() {
		final ResponseEntity<User> user = uc.getUser(2);
		//addUserTest(user);

	}
}
