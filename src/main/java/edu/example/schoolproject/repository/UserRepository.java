package edu.example.schoolproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.example.schoolproject.model.User;

/**
 * Access to the user data. JpaRepository grants us convenient access methods here.
 */
@Repository
public interface UserRepository
    extends JpaRepository<User, Long>
{
	
	/**
	 * Find a user by username
	 *
	 * @param username the user's username
	 * @return user which contains the user with the given username or null.
	 */
	User findOneByUsername( String username );

}
