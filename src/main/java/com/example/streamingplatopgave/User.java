package com.example.streamingplatopgave;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String subscriptionType;

    public User(int userId, String firstName, String lastName, String email, String subscriptionType){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subscriptionType = subscriptionType;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }
}


