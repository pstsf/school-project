package edu.example.schoolproject.model;

public class User
{
    private String mail;

    private String password;

    private String lastName;

    private String name;

    private String address;

    public String getMail()
    {
        return mail;
    }

    public User setMail( final String mail )
    {
        this.mail = mail;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public User setPassword( final String password )
    {
        this.password = password;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public User setLastName( final String lastName )
    {
        this.lastName = lastName;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public User setName( final String name )
    {
        this.name = name;
        return this;
    }

    public String getAddress()
    {
        return address;
    }

    public User setAddress( final String address )
    {
        this.address = address;
        return this;
    }
}
