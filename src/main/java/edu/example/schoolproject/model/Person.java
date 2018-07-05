package edu.example.schoolproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "person")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String name;

    private String username;

    private String address;

    private Date birth_date;

    private String postal_code;

    private String town;

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return birth_date;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getTown() {
        return town;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.birth_date = date;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Klassenbuch getKlassenbuch() {
        return klassenbuch;
    }

    public void setKlassenbuch(Klassenbuch klassenbuch) {
        this.klassenbuch = klassenbuch;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(mappedBy = "persons")
    private Collection<Role> roles;

    @ManyToOne
    @JoinTable(name="klassenbuch_prsn",
            joinColumns = @JoinColumn(name="klassenbuch_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    private Klassenbuch klassenbuch;
}