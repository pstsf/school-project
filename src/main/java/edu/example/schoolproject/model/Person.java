package edu.example.schoolproject.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String name;

    @OneToOne(mappedBy = "person")
    private User user;

    private String username;

    private String address;

    private Date birthDate;

    private String postalCode;

    private String town;

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return birthDate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.birthDate = date;
    }

    public void setPostalCode(String postal_code) {
        this.postalCode = postal_code;
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

    public User getUser()
    {
        return user;
    }

    public void setUser( final User user )
    {
        this.user = user;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate)
    {
        this.birthDate = birthDate;
    }

    @ManyToMany(mappedBy = "persons")
    private Collection<Role> roles;

    @ManyToOne
    @JoinTable(name="klassenbuch_prsn",
            joinColumns = @JoinColumn(name="klassenbuch_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    private Klassenbuch klassenbuch;
}