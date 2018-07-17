package edu.example.schoolproject;

import edu.example.schoolproject.model.Person;
import edu.example.schoolproject.model.User;
import edu.example.schoolproject.repository.PersonRepository;
import edu.example.schoolproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SchoolProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolProjectApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PersonRepository personRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void setDefaultSettings(){
		Person person=new Person();
		User user=new User();

		person.setUsername("david@example.com");
		person.setName("David Polzer");
		person.setTown("Teststadt");
		//person.setRoles(null);
        personRepository.save(person);

		user.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
		user.setEnabled(true);
		user.setUsername("david@example.com");
		user.setPerson(person);
		userRepository.save(user);

        person.setUser(user);
	}

}
