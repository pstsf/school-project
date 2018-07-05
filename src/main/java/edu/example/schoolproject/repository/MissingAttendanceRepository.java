package edu.example.schoolproject.repository;

import edu.example.schoolproject.model.MissingAttendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MissingAttendanceRepository
        extends CrudRepository<MissingAttendance, Long> {
    Collection<MissingAttendance> findAll();
    Optional<MissingAttendance> findById(Long id);
}
