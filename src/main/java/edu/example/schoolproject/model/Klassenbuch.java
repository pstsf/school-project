package edu.example.schoolproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "klassenbuch")

public class Klassenbuch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private long id;
    private int klassen_stufe;
    private String klassenName;
    private String klassen_zusatz;
    private Date period_start;
    private Date period_end;
    private boolean archived;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    @JsonManagedReference
    private Person owner;

    public void setId(long klassen_id) {
        this.id = klassen_id;
    }

    public void setKlassen_stufe(int klassen_stufe) {
        this.klassen_stufe = klassen_stufe;
    }

    public void setKlassen_name(String klassen_name) {
        this.klassenName = klassen_name;
    }

    public void generateKlassen_name() {
        this.klassenName = getKlassen_stufe() + getKlassen_Zusatz();
    }

    public long getId() {
        return id;
    }

    public int getKlassen_stufe() {
        return klassen_stufe;
    }

    public String getKlassen_name() {
        return klassenName;
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

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getKlassen_Zusatz() {
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

    public Person getOwner() {
        return owner;
    }

    /*@OneToMany(mappedBy = "klassenbuch")
    private Collection<Person> students;

    public Collection<Person> getStudents() {
        return students;
    }

    public void setStudents(Collection<Person> students) {
        this.students = students;
    }*/

    /*@OneToMany(mappedBy ="klassenbuch")
    private Collection<MissingAttendance> missing;*/
};
