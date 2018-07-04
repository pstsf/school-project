package edu.example.schoolproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "klassenbuch")

public class Klassenbuch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private long id;
    private int klassen_stufe;
    private String klassen_name;
    private String klassen_zusatz;
    private Date period_start;
    private Date period_end;
    private boolean archived;
    private long owner_id;

    public void setId(long klassen_id) {
        this.id = klassen_id;
    }

    public void setKlassen_stufe(int klassen_stufe) {
        this.klassen_stufe = klassen_stufe;
    }

    public void setKlassen_name(String klassen_name) {
        this.klassen_name = klassen_name;
    }

    public long getId() {
        return id;
    }

    public int getKlassen_stufe() {
        return klassen_stufe;
    }

    public String getKlassen_name() {
        return klassen_name;
    }

    public void setKlassen_zusatz(String zusatz) {
        this.klassen_zusatz = zusatz;
    }

    public void setPeriod_start(Date period_begin) {
        this.period_start = period_begin;
    }

    public void setPeriod_end(Date period_end) {
        this.period_end = period_end;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    public String getZusatz() {
        return klassen_zusatz;
    }

    public Date getPeriod_start() {
        return period_start;
    }

    public Date getPeriod_end() {
        return period_end;
    }

    public boolean isArchived() {
        return archived;
    }

    public long getOwner_id() {
        return owner_id;
    }

    @OneToMany(mappedBy = "klassenbuch")
    private Collection<Person> students;

    public Collection<Person> getStudents() {
        return students;
    }

    public void setStudents(Collection<Person> students) {
        this.students = students;
    }
};
