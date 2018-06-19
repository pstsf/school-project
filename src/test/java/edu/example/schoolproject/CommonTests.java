package edu.example.schoolproject;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonTests
{
    @Test
    public void encrypt()
    {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String secret = bCryptPasswordEncoder.encode( "secret" );
        System.out.println( secret );
        final String password = bCryptPasswordEncoder.encode( "password" );
        System.out.println( password );
        boolean b = bCryptPasswordEncoder.matches( "password" , password );
        System.out.println( b );
    }
}
