package edu.example.schoolproject.repository;

import edu.example.schoolproject.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoleRepository
        extends CrudRepository<Role,Long> {
    Collection<Role> findAll();
    Role findByName(String name);
}