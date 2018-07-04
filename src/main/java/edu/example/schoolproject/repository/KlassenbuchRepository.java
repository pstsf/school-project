package edu.example.schoolproject.repository;

import java.util.Collection;

import edu.example.schoolproject.model.Klassenbuch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassenbuchRepository
        extends CrudRepository<Klassenbuch, Long>
{
    Collection<Klassenbuch> findAll();

    Klassenbuch findById( int id );

    Klassenbuch findByName( String name );
}
