package com.example.personalinfo;

import java.io.Serializable;

public class UserInformation implements Serializable {
    private String name;
    private String job;
    private int age;
    private String country;

    // Constructor
    public UserInformation(String name, String job, int age, String country) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.country = country;
    }


    public String getName() { return name; }
    public String getJob() { return job; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
}