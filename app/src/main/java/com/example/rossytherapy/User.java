package com.example.rossytherapy;

public class User {
    public String firstName, lastName, email, password, country, city, zipCode;

    public User() {

    }
    public User(String firstName,String lastName, String email, String password, String country, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }
}
