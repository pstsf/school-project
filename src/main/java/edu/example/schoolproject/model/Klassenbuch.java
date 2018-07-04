package edu.example.schoolproject.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "klassenbuch")
public class Klassenbuch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "klassenbuch_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "klassen_stufe", nullable = false, unique = false)
    private int klassenStufe;

    @Column(name = "klassen_zusatz", nullable = false, unique = false)
    private String zusatz;

    @Column(name = "klassen_name", nullable = false, unique = false)
    private String name;

    @Column(name = "period_start", nullable = false, unique = false)
    private Date yearFrom;

    @Column(name = "period_end", nullable = false, unique = false)
    private Date yearTo;

    @Column(name = "archived", nullable = false, unique = false)
    private boolean archived;

    @Column(name = "owner_id", nullable = false, unique = false)
    private long ownerName;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getKlassenStufe() { return klassenStufe; }

    public void setKlassenStufe(int klassenStufe) { this.klassenStufe = klassenStufe; }

    public String getZusatz() { return zusatz; }

    public void setZusatz(String zusatz) { this.zusatz = zusatz; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getYearFrom() { return yearFrom; }

    public void setYearFrom(Date yearFrom) { this.yearFrom = yearFrom; }

    public Date getYearTo() { return yearTo; }

    public void setYearTo(Date yearTo) { this.yearTo = yearTo; }

    public long getOwnerName() { return ownerName; }

    public void setOwnerName(long ownerName) { this.ownerName = ownerName; }
}
