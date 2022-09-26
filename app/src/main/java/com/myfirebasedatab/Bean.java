package com.myfirebasedatab;

public class Bean {

    String firstName;
    String lastName;
    String id;

    public Bean(String s, String s1) {
        firstName=s;
        lastName=s1;
    }

    public Bean() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
