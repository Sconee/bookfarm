package com.apps.bookfarm.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException (Long id){
        super("Error. Could not find author with id: " + id);
    }
}
