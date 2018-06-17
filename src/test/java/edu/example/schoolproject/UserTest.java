package edu.example.schoolproject;

import org.junit.Assert;
import org.junit.Test;

import edu.example.schoolproject.model.User;

public class UserTest
{
    @Test
    public void testUser()
    {
        User newUser = new User().setAddress( "testAddress" )
                                 .setLastName( "testLastName" )
                                 .setMail( "testMail" )
                                 .setName( "testName" )
                                 .setPassword( "testPassword" );
        Assert.assertEquals( "testAddress", newUser.getAddress() );
        Assert.assertEquals( "testLastName", newUser.getLastName() );
        Assert.assertEquals( "testMail", newUser.getMail() );
        Assert.assertEquals( "testName", newUser.getName() );
        Assert.assertEquals( "testPassword", newUser.getPassword() );

    }
}

