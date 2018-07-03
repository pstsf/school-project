package edu.example.schoolproject.transfer;

import edu.example.schoolproject.model.User;

public class UserData
{
    private User user;

    public User getUser()
    {
        return user;
    }

    public UserData setUser( final User user )
    {
        this.user = user;
        return this;
    }
}
