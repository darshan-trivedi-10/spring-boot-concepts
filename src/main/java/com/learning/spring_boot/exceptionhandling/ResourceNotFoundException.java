package com.learning.spring_boot.exceptionhandling;


public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String message){
        super(message);
    }
}
