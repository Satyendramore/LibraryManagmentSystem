package com.sada.LibraryManagement.Eceptions;

public class userAllreadyExist extends RuntimeException {
    public userAllreadyExist(String message) {
        super(message);
    }
    public userAllreadyExist() {
        super("user is present already");
    }
}
