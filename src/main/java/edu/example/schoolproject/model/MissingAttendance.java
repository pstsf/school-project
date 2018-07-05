package edu.example.schoolproject.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="not_attendance")
public class MissingAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date;
    private String reason;

    @ManyToOne
    @JoinTable(name="attendance_person",
            joinColumns = @JoinColumn(name="person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "na_id", referencedColumnName = "id"))
    private Person person;

    @ManyToOne
    @JoinTable(name="attendance_klassenbuch",
            joinColumns = @JoinColumn(name="kb_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "na_id", referencedColumnName = "id"))
    private Klassenbuch klassenbuch;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Klassenbuch getKlassenbuch() {
        return klassenbuch;
    }

    public void setKlassenbuch(Klassenbuch klassenbuch) {
        this.klassenbuch = klassenbuch;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
