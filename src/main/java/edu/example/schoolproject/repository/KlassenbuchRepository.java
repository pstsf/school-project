package edu.example.schoolproject.repository;

import java.util.Collection;

import edu.example.schoolproject.model.Klassenbuch;
import edu.example.schoolproject.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "kbRepo")
public interface KlassenbuchRepository
        extends CrudRepository<Klassenbuch, Long>
{
    Collection<Klassenbuch> findAll();

    Klassenbuch findById( int id );

    Klassenbuch findByKlassenName ( String name );

    Collection<Person> findByKlassenNameIgnoreCaseContaining(String search );
}